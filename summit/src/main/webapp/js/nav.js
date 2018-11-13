
$(function () {
	//给所有li添加点击事件
	$("#newstype").on('click', 'li', function () {
//		location.replace("index2.html");
		$("#main").html("");
		$("#newstype li").removeClass("active");
		$(this).addClass("active");
		var channel = getchannel();
		refresh(channel);
//		$("#main").append("<script src='js/main.js'></script>");
//		$.getScript("js/main.js");
	});

	$("#userinfo").load("user/checkLogin", function (result) {
		var obj = $.parseJSON(result);
		if (obj.status==200) {
			$("#userinfo").html("");
			$("#userinfo").html(
					"<li><a href='javascript:login()'>登录</a></li>" +
					"<li><a href='javascript:register()'>免费注册</a></li>"
			);
		} else {
			$("#userinfo").html("");
			$("#userinfo").html(
					"<li class='dropdown'>" +
					"<a href='#' class='dropdown-toggle' data-toggle='dropdown'>用户信息<strong " +
					"class='caret'></strong></a>" +
					"<ul class='dropdown-menu'>" +
					"<li><a href='#'>我的收藏</a></li>" +
					"<li><a href='#'>我的消息</a></li>" +
					"<li class='divider'></li>" +
					"<li><a href='#'>修改密码</a></li>" +
					"<li><a href=\"#\">退出登录</a></li>" +
					"</ul>" +
					"</li>"
			);
		}
	});
});

function search() {
	alert("TODO ajax");
	return false;
}

function login() {
	return location.href="/page/login.html";
}

function register() {
	return location.href="/page/register.html";
}

function index() {
	return location.href="/index.html";
}
