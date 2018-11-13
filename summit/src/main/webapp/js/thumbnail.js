$("div.carousel-inner div.item").click(function () {
    alert($(this).find("img").attr("alt"));
});