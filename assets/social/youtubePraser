function youtubeParser(that, clickClass, youtube_video_id, thumburl, height, width, str_loading){
  var results = [];
  var id = youtube_video_id;
  var thumb = thumburl;
  $.ajax({
    url: "http://www.youtube.com/get_video_info?video_id="+id+"&asv=2",
    dataType: "text"
  }).done(function(data) {
    var info = {};
    parse_str(data, info);
    var streams = explode(',', info['url_encoded_fmt_stream_map']);
    for(var i=0; i<streams.length; i++){
      var real_stream = {};
      parse_str(streams[i], real_stream);
      real_stream['url'] += '&signature=' + real_stream['sig'];
      results.push(real_stream);
    }
    var hasUrl = false;
    if(results.length > 0){
      var youtube_url="";
      $.each(results, function(index, value) {
        if ("medium" == value.quality && (value.type.indexOf("video/mp4") > -1)) {
          showStreamData(value);
          youtube_url = value.url;
          hasUrl = true;
        }
      });
      if (false == hasUrl) {
          $.each(results, function(index, value) {
          if ("medium" == value.quality && (value.type.indexOf("video/webm") > -1)) {
            showStreamData(value);
            youtube_url = value.url;
            hasUrl = true;
          }
        });
      }
      if (false == hasUrl) {
          $.each(results, function(index, value) {
          if ("small" == value.quality && (value.type.indexOf("video/3gpp") > -1)) {
            showStreamData(value);
            youtube_url = value.url;
            hasUrl = true;
          }
        });
      }
      if (false == hasUrl) {
          $.each(results, function(index, value) {
          if ("small" == value.quality && (value.type.indexOf("video/x-flv") > -1)) {
            showStreamData(value);
            youtube_url = value.url;
            hasUrl = true;
          }
        });
      }
      if (false == hasUrl) {
          $.each(results, function(index, value) {
          if ("hd720" == value.quality && (value.type.indexOf("video/mp4") > -1)) {
            showStreamData(value);
            youtube_url = value.url;
            hasUrl = true;
          }
        });
      }
      console.log("thumburl : " + thumburl);
      var hint_margin_top = -1 * ((height * 59/ 100) - 40);

      var newVideoDom = '<div class="video-controls" id="video-container">'+
            '<video autoplay="autoplay" class="video_view" id="video'+clickClass+'" style="margin-top:10px; margin-bottom:20px; height:'+ height +'px; width:'+width+'px; poster="'+thumburl+'">'+
              '<source src="'+youtube_url+'">'+
            '</video>'+
            '<div class="videoControler" id="videoControler'+clickClass+'">'+
              '<button type="button" class="button detail-player-play"  id="play-pause'+clickClass+'"></button>'+
              '<p class="current-time" id="current-time'+clickClass+'">00:00</p>'+
              '<div class="seekbar" id="seekbar'+clickClass+'">'+
                '<div class="progress-bar" id="progress-bar'+clickClass+'">'+
                  '<div class="button-holder" id="progress-button-holder'+clickClass+'">'+
                    '<div class="progress-button"> </div>'+
                  '</div>'+
                '</div>'+
                '<div class="buffered" id="buffered'+clickClass+'"></div>'+
                '<div class="progressbg"></div>'+
              '</div>'+
              '<button type="button" class=" button detail-player-fullscreen" id="full-screen'+clickClass+'"></button>'+
              '<p class="duration-time" id="duration-time'+clickClass+'">00:00</p>'+
            '</div> <!-- End video Controls -->'+
            '<p class="hint_p'+clickClass +'" style="color:white; position: relative; z-index:99999; margin-left:'+((width/2) -38)+'px;margin-top: '+ hint_margin_top +'px;">'+ str_loading +'</p>'+
          '</div>';
          that.replaceWith(newVideoDom);
          loadingAni(".hint_p"+clickClass);
            // set vidoe control button
            // Buttons
            var CurrentVideo = document.getElementById("video"+clickClass);
            var videoControls = $("#videoControler"+clickClass);
            var playButton = document.getElementById("play-pause"+clickClass);
            var seekbar = document.getElementById("seekbar"+clickClass);
            var play_percent_bar = document.getElementById("progress-bar"+clickClass);
            var progress_btn = document.getElementById("progress-button-holder"+clickClass);
            var buffer_bar = document.getElementById("buffered"+clickClass);
            var fullScreenButton = document.getElementById("full-screen"+clickClass);
            var seekWidth = (videoControls.width()) - 126 -30; //button total width 126 //offset 30 
            $("#seekbar"+clickClass).width(seekWidth);
            // Event listener for the CurrentVideo
            CurrentVideo.addEventListener("click", function() {
                playButton.click();
            });

            // Event listener for the play/pause button
            playButton.addEventListener("click", function() {
              if (CurrentVideo.paused == true) {
                // Play the video
                CurrentVideo.play();

                // Update the button text to 'Pause'
                $(this).addClass("detail-player-pause");
                $(this).removeClass("detail-player-play");
                videoControls.fadeTo( "slow" , 0.01, function() {
                    // Animation complete.
                });


              } else {
                // Pause the video
                CurrentVideo.pause();

                // Update the button text to 'Play'
                $(this).addClass("detail-player-play");
                $(this).removeClass("detail-player-pause");
                videoControls.fadeTo( "slow" , 1, function() {
                    // Animation complete.
                });
              }
            });

            // Event listener for the full-screen button
            fullScreenButton.addEventListener("click", function() {
              if (CurrentVideo.requestFullscreen) {
                CurrentVideo.requestFullscreen();
              } else if (CurrentVideo.mozRequestFullScreen) {
                CurrentVideo.mozRequestFullScreen(); // Firefox
              } else if (CurrentVideo.webkitRequestFullscreen) {
                CurrentVideo.webkitRequestFullscreen(); // Chrome and Safari
              }
              console.log("playVideo :" + youtube_url);
            });

            // Update the seek bar as the video plays
            CurrentVideo.addEventListener("timeupdate", function() {
                // hide loading hint
                if(CurrentVideo.currentTime > 0.3 && ($(".hint_p"+clickClass).length > 0)){
                  console.log("remove hint -  CurrentVideo.currentTime:" + CurrentVideo.currentTime);
                  $(".hint_p"+clickClass).remove();
                }
                //console.log("video.currentTime " + video.currentTime);
                var currentTime_m =  Math.floor(CurrentVideo.currentTime / 60);
                var currentTime_s = Math.floor(CurrentVideo.currentTime % 60);
                var currentTime;
                if (currentTime_s < 10){
                   currentTime_s =  "0"+currentTime_s;
                }
                if (currentTime_m < 10){
                   currentTime =  "0"+currentTime_m+":"+currentTime_s;
                } else {
                   currentTime =  currentTime_m+":"+currentTime_s;
                }
                $("#current-time"+clickClass).html(currentTime);

                var play_percent =  (CurrentVideo.currentTime / Math.floor(CurrentVideo.duration)) * 100 ;
                play_percent_bar.style.width= play_percent+"%";
            });

            CurrentVideo.addEventListener('progress', function() {
                try{
                    // console.log(CurrentVideo.buffered.end(CurrentVideo.buffered.length-1));
                    var buffered = Math.floor(CurrentVideo.buffered.end(CurrentVideo.buffered.length-1));
                    var buffered_percent = (buffered / Math.floor(CurrentVideo.duration)) * 100 ;
                    buffer_bar.style.width= buffered_percent+"%"; 
                }
                catch(e) {console.log(e)}
            });


            CurrentVideo.addEventListener('loadeddata', function() {
           // Video is loaded and can be played
                //console.log("video.duration " + video.duration);
                var duration_m =  Math.floor(CurrentVideo.duration / 60);
                var duration_s = Math.floor(CurrentVideo.duration % 60);
                var duration;
                if (duration_m < 10){
                   duration =  "0"+duration_m+":"+duration_s;
                } else {
                   duration =  duration_m+":"+duration_s;
                }
                $("#duration-time"+clickClass).html(duration);
            }, false);
            CurrentVideo.addEventListener('loadstart', function() {
            // Video is loaded and can be played
                console.log("video loadstart & play" );
                CurrentVideo.play();
                videoControls.fadeTo( "slow" , 0.01, function() {
                    // Animation complete.
                });
            }, false);

            // Bind a function to the progress bar so the user can select a point in the video
            seekbar.addEventListener('mousedown', function(e) {    
                try {
                    // The x position of the mouse in the progress bar 
                    var x = e.pageX -  buffer_bar.offsetLeft - 20;
                    console.log(  x );
                    // Update current time
                    currentTime = (x / seekbar.offsetWidth) * CurrentVideo.duration;
                    
                    CurrentVideo.currentTime = currentTime;   

                    var currentTime_m =  Math.floor(CurrentVideo.currentTime / 60);
                    var currentTime_s = Math.floor(CurrentVideo.currentTime % 60);
                    var currentTime;
                    if (currentTime_s < 10){
                       currentTime_s =  "0"+currentTime_s;
                    }
                    if (currentTime_m < 10){
                       currentTime =  "0"+currentTime_m+":"+currentTime_s;
                    } else {
                       currentTime =  currentTime_m+":"+currentTime_s;
                    }
                    $("#current-time"+clickClass).html(currentTime);
                    var play_percent =  (CurrentVideo.currentTime / Math.floor(CurrentVideo.duration)) * 100 ;
                    play_percent_bar.style.width= play_percent+"%";

                }        
                catch(e) {console.log(e)}  
            });

            seekbar.addEventListener('touchend', function(e) {
                try{
                    // The x position of the mouse in the progress bar 
                    var x = e.changedTouches[0].pageX -  buffer_bar.offsetLeft - 20;
                    console.log(  x );
                    // Update current time
                    currentTime = (x / seekbar.offsetWidth) * CurrentVideo.duration;
                    
                    CurrentVideo.currentTime = currentTime;
                    var currentTime_m =  Math.floor(CurrentVideo.currentTime / 60);
                    var currentTime_s = Math.floor(CurrentVideo.currentTime % 60);
                    var currentTime;
                    if (currentTime_s < 10){
                       currentTime_s =  "0"+currentTime_s;
                    }
                    if (currentTime_m < 10){
                       currentTime =  "0"+currentTime_m+":"+currentTime_s;
                    } else {
                       currentTime =  currentTime_m+":"+currentTime_s;
                    }
                    $("#current-time"+clickClass).html(currentTime);
                    var play_percent =  (CurrentVideo.currentTime / Math.floor(CurrentVideo.duration)) * 100 ;
                    play_percent_bar.style.width= play_percent+"%";
                }           
                catch(e) {console.log(e)}  
            });

            seekbar.addEventListener('touchmove', function(e) {
                try{
                    // The x position of the mouse in the progress bar 
                    var x = e.changedTouches[0].pageX -  buffer_bar.offsetLeft - 20;
                    console.log(  x );
                    // Update current time
                    currentTime = (x / seekbar.offsetWidth) * CurrentVideo.duration;
                    
                    CurrentVideo.currentTime = currentTime;
                    CurrentVideo.currentTime = currentTime;
                    var currentTime_m =  Math.floor(CurrentVideo.currentTime / 60);
                    var currentTime_s = Math.floor(CurrentVideo.currentTime % 60);
                    var currentTime;
                    if (currentTime_s < 10){
                       currentTime_s =  "0"+currentTime_s;
                    }
                    if (currentTime_m < 10){
                       currentTime =  "0"+currentTime_m+":"+currentTime_s;
                    } else {
                       currentTime =  currentTime_m+":"+currentTime_s;
                    }
                    $("#current-time"+clickClass).html(currentTime);
                    var play_percent =  (CurrentVideo.currentTime / Math.floor(CurrentVideo.duration)) * 100 ;
                    play_percent_bar.style.width= play_percent+"%";
                }           
                catch(e) {console.log(e);}  
            });
            console.log("auto play");
            // end of set video control button
        }    
    });  
}

function loadingAni(dom) {
    if ($(dom).length > 0){
        
        $(dom).text(str_loading + " ...");
        setTimeout(
          function() 
          {
            loadingAni2(dom);
            //do something special
          }, 350
        );
    }
}
function loadingAni2(dom) {
    if ($(dom).length > 0){
        
        $(dom).text(str_loading + " .\xa0\xa0 ");
        setTimeout(
          function() 
          {
            loadingAni3(dom);
            //do something special
          }, 350
        );
    }
}
function loadingAni3(dom) {
    if ($(dom).length > 0) {
        
        $(dom).text(str_loading + " ..\xa0");
        setTimeout(
          function() 
          {
            loadingAni(dom);
            //do something special
          }, 350
        );  
    }
}

function parse_str(str, array) {
  var strArr = String(str).replace(/^&/, '').replace(/&$/, '').split('&'),
    sal = strArr.length,
    i, j, ct, p, lastObj, obj, lastIter, undef, chr, tmp, key, value,
    postLeftBracketPos, keys, keysLen,
    fixStr = function (str) {
      return decodeURIComponent(str.replace(/\+/g, '%20'));
    };
  if (!array) {
    array = this.window;
  }
  for (i = 0; i < sal; i++) {
    tmp = strArr[i].split('=');
    key = fixStr(tmp[0]);
    value = (tmp.length < 2) ? '' : fixStr(tmp[1]);

    while (key.charAt(0) === ' ') {
      key = key.slice(1);
    }
    if (key.indexOf('\x00') > -1) {
      key = key.slice(0, key.indexOf('\x00'));
    }
    if (key && key.charAt(0) !== '[') {
      keys = [];
      postLeftBracketPos = 0;
      for (j = 0; j < key.length; j++) {
        if (key.charAt(j) === '[' && !postLeftBracketPos) {
          postLeftBracketPos = j + 1;
        }
        else if (key.charAt(j) === ']') {
          if (postLeftBracketPos) {
            if (!keys.length) {
              keys.push(key.slice(0, postLeftBracketPos - 1));
            }
            keys.push(key.substr(postLeftBracketPos, j - postLeftBracketPos));
            postLeftBracketPos = 0;
            if (key.charAt(j + 1) !== '[') {
              break;
            }
          }
        }
      }
      if (!keys.length) {
        keys = [key];
      }
      for (j = 0; j < keys[0].length; j++) {
        chr = keys[0].charAt(j);
        if (chr === ' ' || chr === '.' || chr === '[') {
          keys[0] = keys[0].substr(0, j) + '_' + keys[0].substr(j + 1);
        }
        if (chr === '[') {
          break;
        }
      }

      obj = array;
      for (j = 0, keysLen = keys.length; j < keysLen; j++) {
        key = keys[j].replace(/^['"]/, '').replace(/['"]$/, '');
        lastIter = j !== keys.length - 1;
        lastObj = obj;
        if ((key !== '' && key !== ' ') || j === 0) {
          if (obj[key] === undef) {
            obj[key] = {};
          }
          obj = obj[key];
        }
        else { // To insert new dimension
          ct = -1;
          for (p in obj) {
            if (obj.hasOwnProperty(p)) {
              if (+p > ct && p.match(/^\d+$/g)) {
                ct = +p;
              }
            }
          }
          key = ct + 1;
        }
      }
      lastObj[key] = value;
    }
  }
}

function explode (delimiter, string, limit) {
  if ( arguments.length < 2 || typeof delimiter == 'undefined' || typeof string == 'undefined' ) return null;
  if ( delimiter === '' || delimiter === false || delimiter === null) return false;
  if ( typeof delimiter == 'function' || typeof delimiter == 'object' || typeof string == 'function' || typeof string == 'object'){
    return { 0: '' };
  }
  if ( delimiter === true ) delimiter = '1';
  delimiter += '';
  string += '';
  var s = string.split( delimiter );
  if ( typeof limit === 'undefined' ) return s;
  if ( limit === 0 ) limit = 1;
  if ( limit > 0 ){
    if ( limit >= s.length ) return s;
    return s.slice( 0, limit - 1 ).concat( [ s.slice( limit - 1 ).join( delimiter ) ] );
  }
  if ( -limit >= s.length ) return [];
  s.splice( s.length + limit );
  return s;
}


function parseStreamUrl(url){
  var id = youtube_parser(url);
  if (false != id) {
    // is youtube url - do something 
    getYoutubeUrl(url, id);
  } else {
    // not youtube url -parse other source in the future
    var videoJson = {};
    videoJson.thumburl = "-1";
    videoJson.youtube_url = "-1";
    if ("undefined" != typeof insta) {
      insta.setVideoData(JSON.stringify(videoJson));
    }
  }
}

function getYoutubeUrl(url, youtube_id) {
  var sourceUrl = url;
  var thumburl ="http://img.youtube.com/vi/"+ youtube_id +"/0.jpg";
  // get data from get_video_info
  $.ajax({
      url: "http://www.youtube.com/get_video_info?video_id="+youtube_id+"&asv=2",
      dataType: "text"
      }).done(function(data) {
      var results = [];
      var videoJson = {};
      var info = {};
      parse_str(data, info);
      var streams = explode(',', info['url_encoded_fmt_stream_map']);
      for(var i=0; i<streams.length; i++){
          var real_stream = {};
          parse_str(streams[i], real_stream);
          real_stream['url'] += '&signature=' + real_stream['sig'];
          results.push(real_stream);
      }
      var hasUrl = false;
      if(results.length > 0) {
          var youtube_url="";
          $.each(results, function(index, value) {
          if ("medium" == value.quality && (value.type.indexOf("video/mp4") > -1)) {
                showStreamData(value);
                youtube_url = value.url;
                hasUrl = true;
        }
          });
      if (false == hasUrl) {
              $.each(results, function(index, value) {
              if ("medium" == value.quality && (value.type.indexOf("video/webm") > -1)) {
                showStreamData(value);
                youtube_url = value.url;
                hasUrl = true;
              }
            });
          }
          if (false == hasUrl) {
              $.each(results, function(index, value) {
              if ("small" == value.quality && (value.type.indexOf("video/3gpp") > -1)) {
                showStreamData(value);
                youtube_url = value.url;
                hasUrl = true;
                }
            });
          }
          if (false == hasUrl) {
              $.each(results, function(index, value) {
              if ("small" == value.quality && (value.type.indexOf("video/x-flv") > -1)) {
                showStreamData(value);
                youtube_url = value.url;
                hasUrl = true;
                }
            });
          }
          if (false == hasUrl) {
              $.each(results, function(index, value) {
              if ("hd720" == value.quality && (value.type.indexOf("video/mp4") > -1)) {
                showStreamData(value);
                youtube_url = value.url;
                hasUrl = true;
                }
            });
          }
          console.log("sourceUrl : " + sourceUrl);
          console.log("thumburl : " + thumburl);
          console.log("youtube_url : " + youtube_url);
          videoJson.sourceUrl = sourceUrl;
          videoJson.thumburl = thumburl;
          videoJson.youtube_url = youtube_url;
      if ("undefined" != typeof insta) {
              insta.setVideoData(JSON.stringify(videoJson));
          }
       }    // end of results.length > 0
    });  
} // end of getYoutubeUrl

// These are the types of Youtube URLs supported
// http://www.youtube.com/watch?v=0zM3nApSvMg&feature=feedrec_grec_index
// http://www.youtube.com/user/IngridMichaelsonVEVO#p/a/u/1/QdK8U-VIH_o
// http://www.youtube.com/v/0zM3nApSvMg?fs=1&amp;hl=en_US&amp;rel=0
// http://www.youtube.com/watch?v=0zM3nApSvMg#t=0m10s
// http://www.youtube.com/embed/0zM3nApSvMg?rel=0
// http://www.youtube.com/watch?v=0zM3nApSvMg
// http://youtu.be/0zM3nApSvMg

function youtube_parser(url){
  if("undefined" != typeof url) {
    var regExp = /^.*((youtu.be\/)|(v\/)|(\/u\/\w\/)|(embed\/)|(watch\?))\??v?=?([^#\&\?]*).*/;
    var match = url.match(regExp);
    return (match&&match[7].length==11)? match[7] : false;
  } else {
    return false;
  }

}

function showStreamData(streamData) {
  try{
    console.log(streamData.quality);
    console.log(streamData.type);
    console.log(streamData.url);
  } catch ( exception )  { console.log(" exception : " + exception);}
}
