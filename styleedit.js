// deal with mobile being stupid
var mobile = /Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent);

var extraStyle = '__extra_style__';
$('head').append('<style id="' + extraStyle + '" type="text/css"></style>');
extraStyle = $('#' + extraStyle);

if(mobile) {
  extraStyle.html('p.intro {font-size: 13px;}')
}

// do some runtime css stuff, since I don't want to hardcode this. it's horrible.
$(function() {
  var newColor = (function () {
  var $span = $('<span class="hljs-string"></span>').hide().appendTo("body");
  var color = $span.css('color');
  $span.remove();
  var colors = color.match(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/);
  return 'rgb(' + colors.slice(1).map(function(x){return Math.max(0, x - 70)}).join(', ') + ")"; // x: int -> str coersion
})()

  extraStyle.html('a:hover.code { color:' + newColor + '; }');
});