var str_hint_tap = "Tap to load the image";
var str_loading = "Loading";
var str_more_story = "More Stories ";
var str_read_source = "Read Source";


var timeTick = 0;  // for share button
var V3API_WIDTH = 3; //for image Occupy
var V3API_HEIGHT = 4;


// for android set template
function setTitleDiv(title, source, time, logo) {
    if (logo == null || logo == "") {
         $('.title_div').replaceWith('<div class="title_div">'+
        '<div class="title">'+title+'</div>'+
        '<div class="source-logo"><img class="logo" src="./publisher_icon_default.png" />'+
        '<div class="source">'+source+'</div></div>'+
        '<div class="time">'+time+'</div></div>');
    } else {
         $('.title_div').replaceWith('<div class="title_div">'+
        '<div class="title">'+title+'</div>'+
        '<div class="source-logo"><img class="logo" src="'+logo+'" />'+
        '<div class="source">'+source+'</div></div>'+
        '<div class="time">'+time+'</div></div>');
    }
}

function setPoweredDisplay(isShow) {
    if(true == isShow || "true" == isShow) {
        $('.powered').css('display', 'block');
    } else {
        $('.powered').css('display', 'none');
    }
}

// set img 
function setDomImg(dom, base64Img){
    $('.'+dom).css('background-image', 'none');
    $('.'+dom).css('background-color', '#FFFFFF');
    $('.'+dom).css('content', 'url("'+ base64Img +'")');

    $('.'+dom).removeClass('hidden');
    $('.'+dom).removeClass('loading');
    
    $('.'+dom).parent().find("p:first").remove();

    $('.'+dom).siblings().each(function(){
        if ($(this).hasClass('loading_img')){
            $(this).remove();
        }
    });
}

function setArticle(contentId){
    var screen_width = document.getElementsByTagName('body')[0].scrollWidth;
    if (screen_width < 280) {
        // to fix first time html not finished issue
        setTimeout(function() {
            console.log("setArticle  scrollWidth : " + screen_width + " - not ready");
            setArticle(contentId);
        }, 300);
    } else {
        setImgOccupy(contentId);
    }
    setWebViewHeight();
}

function setImgOccupy(contentId) {
    if ("undefined" != typeof news) {    
        var html_src = news.getArticle();
        $('.article_div').removeClass('loading');

        var idx = 1;
        var img_class = 'volley_img_';
        var class_name = "";
        var screen_width = window.innerWidth;
        console.log("setArticle  scrollWidth : " + document.getElementsByTagName('body')[0].scrollWidth);
        if ($('body').hasClass('noImgMode')) {
            var object = $('<div/>').append(html_src);
            object.find('img').each(function() {
                var src = $(this).attr("src");
                var width = screen_width -36;
                var height = 206;
                if ( this.height > 0 ) {
                    try {
                        height = ( width * this.height  / this.width );
                    } catch ( exception )  { console.log(" exception : " + exception);}
                } else {
                    try{
                        var res = src.split("_");
                        var img_height = res[parseInt(V3API_HEIGHT)].replace(".jpg", "");
                        img_height = img_height.replace(".png", "");
                        height = ( parseInt(width) * parseInt(img_height)  / res[parseInt(V3API_WIDTH)] );
                    }
                    catch (exception){
                        console.log('exception : ' + exception);   
                    }
                }
                var hint_margin_top = -1 * ((height * 59/ 100) - 36);

                class_name = img_class + contentId + idx;

                console.log("noImgMode height : " + height);
                
                $(this).replaceWith(
                    '<div style="height:'+ height +'px;" class="div_img div_'+ class_name +'"><img height="' + height +
                    '" class=" '+ class_name +'" data-imgSrc="'+ src +'" data-clickClass="'+class_name +'"/>'+
                    '<p class="hint_p'+class_name +'" style=" margin-top: '+ hint_margin_top +'px;">'+ str_hint_tap +'</p></div>');
                idx = idx + 1;
            });
            $('.article_div').html(object.html());
            $('.div_img').each(function() {
                $(this).click(function() {
                    $(this).addClass('clicked');

                    var div_height = $(this).height();
                    var img_src = $(this).find('img:first').attr("data-imgSrc");
                    var clickClass = $(this).find('img').attr("data-clickClass");
                    news.setImgbyVolley(img_src, clickClass);
                    $(this).unbind();

                    loadingAni(".hint_p"+clickClass);

                });
            });
            $('.article_div img').each(function() {
                var img_src = $(this).attr("data-imgSrc");
                var clickClass = $(this).attr("data-clickClass");
                // try to load cache
                news.setImgbyVolleyCache(img_src, clickClass);
            });

        } else {
            var object = $('<div/>').append(html_src);
            object.find('img').each(function() {
                var src = $(this).attr("src");
                var width = screen_width -36;
                var height = 206; 
                var loading_margin_top;

                if ( this.height > 0 ) {
                    try {
                        height = ( width * this.height  / this.width );
                    } catch (exception) {console.log(" exception : " + exception);}       
                } else {
                    try{
                        var res = src.split("_");
                        console.log('res[V3API_WIDTH] : ' + res[V3API_WIDTH]);
                        console.log('res[V3API_HEIGHT] : ' + res[V3API_HEIGHT]);
                        res[V3API_HEIGHT] = res[V3API_HEIGHT].replace(".jpg", "");
                        res[V3API_HEIGHT] = res[V3API_HEIGHT].replace(".png", "");
                        height = ( width * res[V3API_HEIGHT]  / res[V3API_WIDTH] );
                    }
                    catch (exception){
                        console.log('exception : ' + exception);   
                    }
                }

                class_name = img_class + contentId + idx;

                console.log('height : ' + height);

               
                $(this).replaceWith(
                    '<div style="height:'+ height +'px;" class="div_img div_'+ class_name +'"><img height="' + height +
                        '" class=" '+ class_name +'" data-imgSrc="'+ src +'" data-clickClass="'+class_name +'"/>'+
                    '</div>');
                news.setImgbyVolley(src, class_name);

                idx = idx + 1;
            });
            $('.article_div').html(object.html());
        }
    }
    
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

function removeDownloadEvent(dom) {
    $(".div_" + dom).addClass('clicked');
    $(".div_" + dom).unbind();
}

function setNoImgMode(){
    $('body').addClass('noImgMode');
}

function setShowImgMode(){
    $('body').removeClass('noImgMode');
}


function cleanContent() {
    setWebViewHeight();
    $(window).scrollTop(0);
    
    $('.title_div').replaceWith('<div class="title_div">'+
    '<div class="title"> </div>'+
    '<div class="source"></div>'+
    '<div class="time"></div></div>');

    $('.article_div').replaceWith('<div class="article_div loading"><img class="loading_img" src="file:///android_asset/onews__loading.png"/></div>');
    $('.imgTitle').replaceWith('<div class="imgTitle hidden"></div>');

    $('.div_related').addClass("hidden");
    $('#related_list').html('');
    $(".read_source").addClass("hidden");
    $("#iframeView").remove();

}

function hideReadSource(){
    $(".read_source").addClass("hidden");
}

function showReadSource(){
    $(".read_source").removeClass("hidden");
}

function deleteUnuseSocialAppBtn(dom){
    $("."+dom).remove();
}

function setFontStyle(fontStyle) {
    $(".body").removeClass("small");
    $(".body").removeClass("normal");
    $(".body").removeClass("large");
    $(".body").removeClass("xlarge");
    $(".body").addClass(fontStyle);
    setWebViewHeight();
}

$(function() {
    $(".shareBtn").click(function() {
        var now = $.now();
        if ((parseInt($.now()) - parseInt(timeTick)) > 1000)
        {
            timeTick = now;
            var type = $(this).data('share');
            if ("undefined" != typeof news) {
                console.log("shareBtn click");
                news.shareNewsby(type);
            }
        }
    });

    $('.read_source').click(function() {
        if ("undefined" != typeof news) {
            news.openOriginal();
        }
    });
    
});

// for style test 
function setFont(dom , fontsize, lineHeight, color, letterSpacing) {
    $("."+dom).css( 'font-size', fontsize+"px" );
    $("."+dom).css("line-height", lineHeight+"px"); 
    $("."+dom).css('color', '#'+color);
    $("."+dom).css('letter-spacing', letterSpacing+'px'); 
}

// set related news
function setRelatedNews(image_condition, title, source, img_url, contentId) {
    $('.div_related').removeClass('hidden');
    var exist = false;
    $('#related_list li').each(function() {
        var content_id = $(this).attr("data-contentid");
        if (content_id == contentId){
            exist = true;
        }
    });
    if (false == exist) {
        $('#related_list').append('<li class="related_news '+ image_condition +'" data-contentid="'+ contentId +'">'+
            '<div class="text_part">'+
                '<div class="news_title">'+ title +'</div>'+
                '<div class="news_source">'+ source +'</div>'+
            '</div>'+
            '<div class="img_part"><img src="'+ img_url +'" data-imgSrc="'+ img_url +'" ></div>'+
        '</li>');
         $('#related_list li').unbind();
         $('#related_list li').click(function() {
            console.log("click -> related news");
            var contentid = $(this).data('contentid');
            console.log("click contentId :" + contentId);
            if ("undefined" != typeof news) {
                news.goRelatedNews(""+contentid);
                $(window).scrollTop(0);
                $('#related_list').html('');
            }
        });
        $("#related_list li img").error(function() {
            console.log("related news img - on error ! use default img");
            $(this).addClass("image_error");
        });
        $("#related_list li img").load(function() {
            console.log("related news img - on load ");
            $(this).addClass("image_success");
        });      
    }
    setWebViewHeight();
}

function displayONewDiv(bShow) {
    if (true == bShow || "true" == bShow) {
        $('.div_onews').removeClass('hidden');
    } else {
        $('.div_onews').addClass('hidden');
    }
}

//create iframe
function iframeView(url){
	var frame = document.createElement('iframe');
	frame.id = "iframeView";
	frame.width = '100%';
	frame.height = document.documentElement.clientHeight;
	frame.seamless = "seamless";
	frame.border = "0";
	frame.frameborder = "no";
	frame.marginwidth = "0";
	frame.marginheight = "0";
	frame.style.border = "none";
	frame.src = url;
	document.getElementsByTagName('body')[0].insertBefore(frame, document.querySelector('.read_source'));

	window.setInterval(function(){
		try {
			frame.height = frame.contentWindow.document.body.scrollHeight;
		} catch(e){}
	},100);
}

// set dom height width
function setImgTitleOccupy(width, height) {
    console.log("Device - scrollWidth: " + document.getElementsByTagName('body')[0].scrollWidth);
    var screen_width = document.getElementsByTagName('body')[0].scrollWidth;
    if (screen_width < 280) {
        // to fix first time html not finished issue
        setTimeout(function() {
            console.log("setImgTitleOccupy  scrollWidth : " + screen_width + " - not ready");
            setImgTitleOccupy(width, height);
        }, 400);
    } else {
        setOccupy(width, height);
    }
}

function setOccupy(width, height) {
    var screen_width = document.getElementsByTagName('body')[0].scrollWidth;
    var newHeight = Math.round( parseInt(screen_width) * parseInt(height)  / parseInt(width) );

    $('.imgTitle').removeClass('hidden');
    $('.imgTitle').width(parseInt(screen_width));
    $('.imgTitle').height(newHeight);
    var class_imgTitle = "imgTitle_img"
    $('.imgTitle').append('<div style="height:'+ newHeight +'px;" class="div_img"><img height="' + newHeight +
                        '" class=" '+ class_imgTitle +'" />'+
                    '</div>');
}

function setLanguage(language_hint_tap, language_loading, language_more_story, language_read_source) {
    str_hint_tap   = language_hint_tap;
    str_loading    = language_loading;
    str_more_story = language_more_story;
    str_read_source= language_read_source;
    $('#related_title_text').text(str_more_story);
    $('#read_source_text').text(str_read_source);
}

function setWebViewHeight() {
    if ("undefined" != typeof news) {
        var height = document.body.getBoundingClientRect().height;
        console.log("setWebViewHeight : " + setWebViewHeight);
        news.setWebViewHeight(height);
    }
}
function setDefineMode(){
    $('body').addClass('define');
}

function setDisableDefineMode(){
    $('body').removeClass('define');
}
