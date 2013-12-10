var run = function() {
  var opt1 = document.querySelector('#option1');
  var opt2 = document.querySelector('#option2');

  opt1.addEventListener('click', function(opt) {
    opt1.wasclicked = true;
  }, false);

  opt2.addEventListener('click', function(opt) {
    opt2.wasclicked = true;
  }, false);

  window.addEventListener('updateOptions', function(e) {
    //quick check to make sure we don't re-enable on polling clients and disabling on null options
    if(e.option1 !== undefined && e.option1 !== 'null' && e.option2 !== 'null'){
      if((option1.value != e.option1 && option2.value != e.option2)){
        option1.wasclicked = false;
        option2.wasclicked = false;
      }
    }
  }, false);

  window.addEventListener('remoteMarkup', function(e) {
    var option = 'undefined';
    if(opt1.wasclicked) {
      option = opt1;
    }
    else if(opt2.wasclicked) {
      option = opt2;
    }
    if(option !== 'undefined') {
      setTimeout(function() {
        var elements = document.querySelectorAll('.' + option.value);
        if(!elements) {
          return;
        }
        for(var i = 0; i < elements.length; i++) {
          elements[i].style.display = 'block';
        }
      }, 100)
    }
  }, false);

  var sub = document.querySelector('#about-page p');
  sub.innerHTML = "<br/>Follow <a target='_blank' href='https://plus.google.com/b/100660127586085393031/100660127586085393031'>Arquillian on G+</a>";
}

if(document.title.indexOf('Remote') != -1 && !window.enhanced) {
  run();
  window.enhanced = true;
}