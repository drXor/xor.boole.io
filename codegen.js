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
    var count = 1;
    for(lang in langs) {
        var button = $('<codebutton>', {
            type: 'button', 
            id: lang + 'button', 
            text: lang[0].toUpperCase() + lang.slice(1)
        });
        button.click(handleCode);
        var $buttons = $('#buttons')
        $buttons.append(button).append(' ')
        //if(count % 4 == 0)
        //    $buttons.append($('<br><br>'));
        count++;
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
               .replace(/(\n[ ]*)(.+["'](.+?@.+?\..+?)["'].+)([ ]*\n)/g, '$1<a href="mailto:$3" class="code">$2</a>$4')
               .replace(/(\n[ ]*)(.+["']((?!irc)[a-zA-Z0-9\-]+?\..+?)["'].+)([ ]*\n)/g,  '$1<a href="http://$3" class="code">$2</a>$4')
               .replace(/(\n[ ]*)(.+["'](drXor\/?.*?)["'].+)([ ]*\n)/g,   '$1<a href="http://github.com/$3" class="code">$2</a>$4');

            snippets[this.lang] = src;

            var code = $('<code>', {
                'class': this.lang,
                id: this.lang + 'code'
            }).append(src);

            var precode = $('<pre>', {
                
            }).append(code);

            if(this.hide) {
                code.css('display', 'none');
            } else {
                code.css('display', 'block');
            }

            $('#nullcode').css('display', 'none');
            
            code.each(function(i, block) { hljs.highlightBlock(block); });

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