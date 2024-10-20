var lengthBeforeReadMore = 0; //default turn off - read more
var articleLength = 0;
var textCount = 0;
var textCountBeforeReadMore = 0;
var needReadMore = false;
var needReadSource = false;
var needPowered = false;
var bShowReadMore = false;

function cleanReadMoreModule() {
    needReadMore = false;
    needReadSource = false;
    needPowered = false;
    updateFooterElement();
}

function setReadMore() {

    //重复调用setReadmore会导致不显示新闻内容
    //重置articleLength
    articleLength = 0;
    if ("undefined" != typeof news) {
        lengthBeforeReadMore = news.getLengthBeforeReadMoreBtn();
    }

    if (1 > lengthBeforeReadMore) {
        console.log("zhang setReadMore : no read more button");
        return;
    }
    console.log("zhang setReadMore : lengthBeforeReadMoreBtn = " + lengthBeforeReadMore);

    $('.article_div p').each(function() {
        if ($(this).text().length > 0
            && $(this).text().length < 150) {
            $(this).addClass("articleLength");
            $(this).attr("data-articleLength", 1);
        } else if ($(this).text().length >= 150
                && $(this).text().length < 300) {
            $(this).addClass("articleLength");
            $(this).attr("data-articleLength", 2);
        } else if ($(this).text().length >= 300
                && $(this).text().length < 450) {
            $(this).addClass("articleLength");
            $(this).attr("data-articleLength", 3);
        } else if ($(this).text().length >= 450) {
            $(this).addClass("articleLength");
            $(this).attr("data-articleLength", 4);
        }
        $(this).attr("data-textCount", $(this).text().length);
        console.log("zhang div_p_textLength = " + $(this).text().length);
        textCount += $(this).text().length;
        console.log("zhang ++textCount = " + textCount);
    });

    // 一个图片算两个长度，为了计算算法完成度，把一张图片认为有200字数：一张图片的高度相当于5行文字，每行40个文字
    $('.article_div .div_img').each(function() {
        $(this).addClass("articleLength");
        $(this).attr("data-articleLength", 2);
        $(this).attr("data-textCount", 200);
        textCount += 200;
        console.log("zhang ++textCount_img = " + textCount);
    });


    $('.article_div .articleLength').each(function() {
        articleLength += parseInt($(this).attr("data-articleLength"));
        if (parseInt(articleLength) > parseInt(lengthBeforeReadMore)) {
            console.log("zhang articleLength = " + articleLength);
            $(this).addClass("readmore_hidden");
        } else {
            textCountBeforeReadMore += parseInt($(this).attr("data-textCount"));
            console.log("zhang textCountBeforeReadMore = " + textCountBeforeReadMore);
        }
    });
    needReadMore = true;
    updateFooterElement();
}

function updateFooterElement() {
    var noContent = parseInt(articleLength) == 0;
    var articleTooLong = parseInt(articleLength) > parseInt(lengthBeforeReadMore);
    bShowReadMore = needReadMore && !noContent && articleTooLong;
    console.log("updateFooterElement java status readmore:" + needReadMore + " readsource:" + needReadSource + " powered:" + needPowered);
    console.log("updateFooterElement inner status noContent:" + noContent + " articleTooLong:" + articleTooLong + " bReadmore:" + bShowReadMore);
    if (bShowReadMore) {
        if ($("div").hasClass("read_more_btn")) {
            console.log("remove existed readmore button");
            //重复调用readmore会导致多个readmore
            //这里删除掉老的
            $('.read_more_btn').remove();
        }
        console.log("add readmore button");
        $('.read_more ').append("<div class='read_more_btn'><span>"+str_read_more+"</span><img class='read_more_arrow' src='./expansion.png'/></div>");
        if ("undefined" != typeof news) {
            news.onShowReadMoreBtn(articleLength , lengthBeforeReadMore , textCount , textCountBeforeReadMore);
        }
        // 点击readMore
        //$(document).on('click', '.read_more_btn', function() {
        $('.read_more_btn').click(function() {
            needReadMore = false;
            updateFooterElement();
            if ("undefined" != typeof news) {
                console.log("zhang onClickReadMore");
                news.onClickReadMoreBtn();
            }
        });
    } else {
        removeReadMore();
    }
    var bShowReadSource;
    if (needReadSource && !bShowReadMore && !noContent) {
        $('.read_source').removeClass("hidden");
        bShowReadSource = true;
    } else {
        $('.read_source').addClass("hidden");
        bShowReadSource = false;
    }
    if (needPowered && bShowReadSource) {
        $('.powered').css('display', 'block');
    } else {
        $('.powered').css('display', 'none');
    }
}

function removeReadMore() {
    console.log("remove readmore button");
    $('.read_more_btn').remove();
    $(".readmore_hidden").each(function() {
        $(this).removeClass("readmore_hidden");
    });
}

function hideReadSource() {
    console.log("hide read source");
    needReadSource = false;
    updateFooterElement();
}

function showReadSource(){
    console.log("show read source");
    needReadSource = true;
    updateFooterElement();
}

function setPoweredDisplay(isShow) {
    console.log("set powered display " + isShow);
    if(true == isShow || "true" == isShow) {
        needPowered = true;
    } else {
        needPowered = false;
    }
    updateFooterElement();
}

//  确认社交引文 显示 不显示
function checkSocialReadMore(){
    console.log("checkSocialReadMore");
    if (bShowReadMore && parseInt(articleLength) <= parseInt(lengthBeforeReadMore)) {
        // 第2个引文以后不显示 - 有时间问题
        var iframeIdx = 0;
        $("iframe").each(function() {
            if (iframeIdx > 0) {
                $(this).addClass("readmore_hidden");
            }
            iframeIdx++;
        });
    }
}

// end of 确认社交引文 显示 不显示
