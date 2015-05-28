$(hljs.initHighlighting)
$.ajax({
    url: 'http://xor.boole.io/scalaexprs/exprs.json',
    type: 'get',
    datatype: 'json',
    success: function(exprs) {
        
        /*
        exprs = [
            {
                "name": str,
                "language": str?,
                "about": str,
                "source": [str] | str
            }, ...
        ]
        */

        for(key in exprs) {
            if(exprs[key].source.constructor !== Array)
                exprs[key].source = [exprs[key].source];
        }

        var len = exprs.length;
        var index_ = 0;

        // mirrors expr, source
        // is an array of jquery 
        // objs
        var displays = [];

        var lock = false;

        function updateDisplay() {

            var index = index_;

            if(!displays[index]) {

                lock = true;
                var desc = exprs[index];
                var requests = desc.source.map(function(src) {
                    return {
                        url: 'http://xor.boole.io/scalaexprs/' + src,
                        type: 'get'
                    };
                });

                var sources = [];

                for(var i = requests.length; i-- > 0;) {
                    if(i === requests.length - 1) {
                        var func = function(s) {

                            sources.push(s);

                            var display = {
                                name: desc.name,
                                language: desc.language,
                                about: desc.about,
                                source: sources.map(function(src) {

                                    var code = $('<code>', {
                                        class: 'scala',
                                        text: src
                                    })

                                    code.each(function(i, block) { hljs.highlightBlock(block); })

                                    var pre = $('<pre>').append(code);

                                    return pre;
                                })
                            };

                            display.sources = $('<div>', {id: 'expr' + display.name, class: 'expr', style: 'display:none;'})
                            display.source.forEach(function(s) {display.sources.append(s)})

                            $('codes').append(display.sources);

                            lock = false;

                            displays[index] = display;

                            updateDisplay();
                        }
                    } else {
                        requests[i].next = requests[i + 1]
                        var func = function(s) { 
                            sources.push(s); 
                            $.ajax(this.next); 
                        };
                    }

                    requests[i].success = func;
                }

                $.ajax(requests[0]);

            } else {

                var display = displays[index];

                $('#exprname').text(display.name);

                if(display.language) {
                    $('#inspiration').text('Taken from ' + display.language);
                } else {
                    $('#inspiration').text('');
                }

                var about = display.about.replace(/`(.*?)`/g, '<code style="display: inline">$1</code>');

                $('#about').empty();
                $('#about').append(about);

                $('.expr').hide();
                $('#expr' + display.name).css('display', 'block');

                $('#nullcode').hide();
            }
        }

        updateDisplay();

        $('leftexprbutton').click(function() {
            if(lock) return;

            index_--;
            if(index_ < 0)
                index_ += len;

            updateDisplay();
        })

        $('rightexprbutton').click(function() {
            if(lock) return;

            index_++;
            if(index_ >= len)
                index_ -= len;

            updateDisplay();
        })
    }
})