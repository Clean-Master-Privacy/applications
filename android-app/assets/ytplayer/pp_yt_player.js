    var tag = document.createElement('script');

      tag.src = "https://www.youtube.com/iframe_api";
      var firstScriptTag = document.getElementsByTagName('script')[0];
      firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);


      var LocString = String(window.document.location.href);
      function getQueryStr(str) {
      var rs = new RegExp("(^|)" + str + "=([^&]*)(&|$)", "gi").exec(LocString), tmp;
        if (tmp = rs) {
        return tmp[2];
        }
        return "";
      }

      var player;
      function onYouTubeIframeAPIReady() {
        player = new YT.Player('player', {
          height: '100%',
          width: '100%',
          videoId: getQueryStr('key'),
          playerVars : {
             'showinfo': 0,
             'rel': 0,
             'fs': 0,
             'controls':0
          },
          events: {
            'onReady': onPlayerReady,
            'onStateChange': onPlayerStateChange
          }
        });
        onInitPlayer();
      }

      function onInitPlayer() {
        AudioManager.onInitPlayer();
      }

      function onPlayerReady(event) {
        if (!paused) {
           event.target.playVideo();
        }
        hideLoading('loading');
      }

      function onPlayerAllReady() {
          AudioManager.onPlayerAllReady();
          isMuted = player.isMuted();
          AudioManager.ctrlAudioController(isMuted);
      }

      var done = false;
      var paused = false;
      function onPlayerStateChange(event) {
        if (event.data == YT.PlayerState.PLAYING && !done) {
          done = true;
          onPlayerAllReady();
        } else if (event.data == YT.PlayerState.ENDED ) {

        }
      }
      <!--function stopVideo() {-->
        <!--player.stopVideo();-->
      <!--}-->

      function hideLoading(id){
        if (document.getElementById){
            target=document.getElementById(id);
            target.style.display="none";
        }
      }

      function resumeVideo() {
          paused = false;
          player.playVideo();
      }

      function pauseVideo() {
          paused = true;
          player.pauseVideo();
      }

      function ctrlPlayerMute(){
           isMuted = player.isMuted();
           if (!isMuted) {
               player.mute();
               AudioManager.ctrlAudioController(true);
           } else {
              player.unMute();
               AudioManager.ctrlAudioController(false);
           }
      }

      function onAudioPlayFinish() {
          pauseVideo();
          AudioManager.onAudioPlayFinish();
      }

      function updatePlayTime() {
          plusPlayTime = getPlusPlayTime();
          if (plusPlayTime <= 1) {
             onAudioPlayFinish();
          }
          AudioManager.updatePlayTime(plusPlayTime);
      }

      function getPlusPlayTime() {
           duration = player.getDuration();
           currentTime = player.getCurrentTime();
           return duration - currentTime;
      }

    
