$(function () {
	var channel = getchannel();
	refresh(channel);
	
});

function getchannel(){
	var channel = $("#newstype .active").text().trim();
	if(channel=='热门'){
		channel='news';
	}else if(channel=='经济'){
		channel='eco';
	}else if(channel=='时尚'){
		channel='fas';
	}else if(channel=='美食'){
		channel='food';
	}else if(channel=='游戏'){
		channel='game';
	}else if(channel=='国际'){
		channel='world';
	}else if(channel=='军事'){
		channel='mil';
	}else{
		return;
	}
//	alert("getChannel:"+channel);
	return channel;
}

function refresh(channel){
	var refreshId=0;
	getNews(channel,refreshId);

	$(window).scroll(function(){
		var scrollTop = $(this).scrollTop();
		var scrollHeight = $(document).height();
		var windowHeight = $(this).height();
		if(scrollTop + windowHeight == scrollHeight){
			refreshId += 1;
//			alert("refresh:"+channel);
			getNews(channel,refreshId);
		}
	});

}

function getNews(channel,refreshId) {
	$.post("/news/getNews/",{'channel':channel,'refreshId':refreshId},function (result) {
		var news = result.data;
		if(news==""){
			alert("到底了");
			return;
		}

		for (var i in news) {
			//  alert(news[i].newsId)
			if(news[i].covers==""){
				news[i].covers="v3/avatar.jpg";
			}
			var newsDiv = "<hr>"+
			"<div class='row clearfix'>" +
			"<div class='col-md-2 column'>" +
			"<img alt='140x140' src='"+news[i].covers+"'  width='140'/>" +
			"</div>" +
			"<div class='col-md-10 column'>" +
			"<h2>"+
			"<a href='"+news[i].url+"'>" +
			news[i].title+
			"</a>" +
			"</h2>" +
			"<p>" +
			"Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui." +
			"</p>" +
			"<div class='col-md-2 column'>"+
			"<p><a class='btn' href="+news[i].url+">View details »</a></p>"+
			"</div >"+
			"<div class='col-md-8 column'>"+"</div>"+
			"<div class='col-md-2 column'>"+
			"<p>"+news[i].pdate+"</p>"+
			"</div>"+

			"</div>" +
			"</div>"
			$("#main").append(newsDiv);
		}
	});
//	$("#main").append("<hr>");
}

//function news(newsId) {
//return location.href='/news/'+newsId;
//}