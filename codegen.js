var langs = {
    c:           'c',
    java:        'java',
    python:      'py',
    go:          'go',
    kotlin:      'kt',
    mathematica: 'mathematica',
    //'brainf--k': 'bf',
    scala:       'scala'
};

var snippets = {};

$('#nullcode').each(function(i, block) { hljs.highlightBlock(block); });

$(function() {
    for(lang in langs) {
        var button = $('<codebutton>', {
            type: 'button', 
            id: lang + 'button', 
            text: lang[0].toUpperCase() + lang.slice(1)
        });
        button.click(handleCode);
        var $buttons = $('#buttons')
        $buttons.append(button).append(' ')
    }
    $('#scalabutton').click();
});

function doRequest(language, hide) {
    return $.ajax({
        lang: language,
        hide: hide,
        url: 'http://xor.boole.io/snippets/xor.' + langs[language],
        type: 'get',
        async: 'false',
        success: function(s) {

            var src = s;
            src = src
                .replace('&', '&amp;')
                .replace('<', '&lt;')
                .replace('>', '&gt;');

            // this exists to and only to make hljs not make
            // my valid kotlin look invalid
            // I dilike this hack as much as you do.
            if(this.lang === 'kotlin') {
                src = src
                    .replace('\n()', '\n<ktfix id="parens">()</ktfix>')
                    .replace('mapOf()', 'mapOf<ktfix id="map">()</ktfix>');

            }

            snippets[this.lang] = src;

            var code = $('<code>', {
                'class': this.lang,
                id: this.lang + 'code'
            }).append(src);

            if(this.hide) {
                code.css('display', 'none');
            } else {
                code.css('display', 'block');
            }

            $('#nullcode').css('display', 'none');
            
            code.each(function(i, block) { hljs.highlightBlock(block); });

            // kotlin fix contiuned
            if(this.lang === 'kotlin') {
                code.children('ktfix#parens').text(')');
                code.children('ktfix#map').text('(');
            }

            src = code.html();

            // yes I'm aware this is horrible
            src = src
                .replace(/(\n[ \t]*)(.+["'])(.+?@.+?\..+?)(["'].+)([ \t]*\n)/g, '$1$2<a href="mailto:$3" class="code">$3</a>$4$5')
                .replace(/(\n[ \t]*)(.+["'])((?!irc)[a-zA-Z0-9\-]+?\..+?)(["'].+)([ \t]*\n)/g,  '$1$2<a href="http://$3" class="code">$3</a>$4$5')
                .replace(/(\n[ \t]*)(.+["'])(drXor\/?.*?)(["'].+)([ \t]*\n)/g,   '$1$2<a href="http://github.com/$3" class="code">$3</a>$4$5');

            var precode = $('<pre>').append(code.empty().append(src));

            $('codes').after(precode).append('\n');
        }
    });
}

function handleCode(e) {
    var button = e.target.tagName.toLowerCase() === 'codebutton' ? e.target : e.target.parentElement;
    var lang = button.id.toLowerCase().match(/.+?(?=button)/)[0];

    function clearOthers() {
        for(key in langs) {
            if(key !== lang) {
                var $code = $('#' + key + 'code').css('display', 'none');
            }
        }
    }

    if(!(lang in snippets)){
        doRequest(lang, false).success(clearOthers);
    } else {
        $('#' + lang + 'code').css('display', 'block');
        clearOthers();
    } 
}