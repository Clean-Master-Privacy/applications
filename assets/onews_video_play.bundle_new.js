//get data from java
var videoData = {
    id: '',
    title: ''
};

init();

function init() {
    var data = {};
    try {
        var dataString = window.news.getVideoData();
        data = JSON.parse(dataString) || {};
    } catch (err) {
        console.log('getVideoData error');
        console.log(err);
    }

    videoData.id = data.id || '';
    videoData.title = data.title || '';
}
document.getElementById('js_video_title').innerHTML = videoData.title;
document.title = videoData.title;

var tag = document.createElement('script');

tag.src = "https://www.youtube.com/iframe_api";
var firstScriptTag = document.getElementsByTagName('script')[0];
firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);

// 3. This function creates an <iframe> (and YouTube player)
//    after the API code downloads.
var youtubePlayer;
var iPublishVideoPlayProgressTaskId;

function onYouTubeIframeAPIReady() {
    youtubePlayer = new YT.Player('youtube_player', {
        height: '244',
        width: Math.min(window.screen.width, '640'),
        playerVars: {
            'controls': 2,
            'showinfo': 0,
            'modestbranding': 1,
            'enablejsapi': 1,
            'fs': 0
        },
        videoId: videoData.id,
        events: {
            'onReady': onPlayerReady,
            'onStateChange': onPlayerStateChange,
            'onError': onPlayerError
        }
    });
    if (!!window.news && window.news.hasOwnProperty('notifyVideoPlayerHeight')) {
        window.news.notifyVideoPlayerHeight(244);
    }
    if (!!window.news && window.news.hasOwnProperty('onVideoReady')) {
        window.news.onVideoReady();
    }
    iPublishVideoPlayProgressTaskId = setInterval(publishVideoPlayProgress, 1000);
}

function onPlayerReady(event) {
    isPlaying = true;
    if (!!window.news && window.news.hasOwnProperty('isWifiConnected')) {
        if (window.news.isWifiConnected()) {
            event.target.playVideo();
        }
    }
}

function onPlayerError(event) {
    if (!!window.news && window.news.hasOwnProperty('onVideoError')) {
        window.news.onVideoError(event.data);
    }
    clearInterval(iPublishVideoPlayProgressTaskId);
}

function onPlayerStateChange(event) {
    var ClientEvent = '';
    switch (event.data) {
        case YT.PlayerState.UNSTARTED:
            ClientEvent = 'onVideoUnStarted';
            break;
        case YT.PlayerState.PLAYING:
            isPlaying = true;
            ClientEvent = 'onVideoPlaying';
            break;
        case YT.PlayerState.PAUSED:
            ClientEvent = 'onVideoPaused';
            break;
        case YT.PlayerState.ENDED:
            ClientEvent = 'onVideoEnded';
            break;
        case YT.PlayerState.CUED:
            ClientEvent = 'onVideoCued';
            break;
        case YT.PlayerState.BUFFERING:
            ClientEvent = 'onVideoBuffering';
            break;
        default:
            break;
    }
    if (ClientEvent != '' && !!window.news && window.news.hasOwnProperty(ClientEvent)) {
        window.news[ClientEvent]();
    }
}

function publishVideoPlayProgress() {
    if (!youtubePlayer || !youtubePlayer.hasOwnProperty('getCurrentTime') || !youtubePlayer.hasOwnProperty('getDuration')) {
        return;
    }

    var percentage = parseInt(Math.round(youtubePlayer.getCurrentTime() * 100.0 / youtubePlayer.getDuration()));
    if (percentage >= 100) {
        clearInterval(iPublishVideoPlayProgressTaskId);
    }
    if (!!window.news && window.news.hasOwnProperty('onVideoPlayProgressChanged')) {
        window.news.onVideoPlayProgressChanged(percentage);
    }
}
