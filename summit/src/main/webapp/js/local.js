$(function () {
    load_nav();
//    load_thumbnail();
    load_main();
});

//加载导航栏
function load_nav() {
    $("#nav").load("page/nav.html");
    $.getScript("js/nav.js");
}

//加载幻灯片
//function load_thumbnail() {
//    $("#thumbnail").load("page/thumbnail.html");
//    $.getScript("js/thumbnail.js");
//}

//加载新闻板块
function load_main() {
    $.getScript("js/main.js");
}