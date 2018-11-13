package yohm.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import yohm.web.service.NewsService;
import yohm.web.vo.News;
import yohm.web.vo.SysResult;

/**
 * @author tarena
 */
@Controller
public class NewsController {

	@Autowired
	private NewsService newsService;

	@RequestMapping("news/getNews")
	@ResponseBody
	public SysResult getNewsList(HttpServletRequest request) {
		String channel = request.getParameter("channel");
		Integer refreshId = Integer.parseInt(request.getParameter("refreshId"));
		System.out.println(channel);
		List<News> list = newsService.getNewsList(channel, refreshId);
		return SysResult.ok(list);
	}

	@RequestMapping("news/{newsId}")
	public String getNewsDetails(@PathVariable("newsId") String newsId) {
		System.out.println(newsId);

		return "news";
	}
}
