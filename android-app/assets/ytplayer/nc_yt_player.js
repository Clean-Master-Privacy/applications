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
             'fs': 1,
             'controls':2
          },
          events: {
            'onReady': onPlayerReady,
            'onStateChange': onPlayerStateChange
          }
        });
      }

      function onPlayerReady(event) {
        event.target.playVideo();
        hideLoading('loading');
      }

      var done = false;
      function onPlayerStateChange(event) {
        if (event.data == YT.PlayerState.PLAYING && !done) {
          <!--setTimeout(stopVideo, 6000);-->
          done = true;
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
        var state = player.getPlayerState();
        if (state == 1) {
            player.pauseVideo();
            player.playVideo();
        }
      }