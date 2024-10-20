function setIframeHeight(iframeObject) {
    console.log("iframe width before : " +$(iframeObject).width());
    console.log("iframe height before : " +$(iframeObject).height());
    var screen_width = document.getElementsByTagName('body')[0].scrollWidth;
    console.log("screen_width : " + screen_width );
    if (screen_width < 200 ) {
        screen_width = 360;
    }
    var width = screen_width - 36;
    try {
        var iframeWidth = $(iframeObject).width();
        var iframeHeight = $(iframeObject).height();
        if (iframeHeight > 0 ) {
           height = ( width * iframeHeight  / iframeWidth ); 
       } else {
            height = ( width * 315  / 560 );
       }   
    } catch ( exception )  {
        console.log(" exception : " + exception);
        height = ( width * 315  / 560 );
    }
    $(iframeObject).width(width);
    $(iframeObject).height(height);
    console.log("iframe width after : " +$(iframeObject).width());
    console.log("iframe height after : " +$(iframeObject).height());

}
