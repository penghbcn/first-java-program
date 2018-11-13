package yohm.web.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yohm.web.mapper.NewsMapper;
import yohm.web.vo.News;

@Service
public class NewsService {

	@Autowired
	private NewsMapper mapper;

	public List<News> getNewsList(String channel, Integer refreshId) {
		// PageHelper.startPage(refreshId, 10, "p_date");
		News news = new News();
		news.setChannel(channel);
		// List<News> list = mapper.select(news);
		// PageInfo<News> pageInfo = new PageInfo<>(list);
		// list = pageInfo.getList();
		RowBounds rowBounds = new RowBounds(refreshId * 10, 10);
		List<News> list = mapper.selectByRowBounds(news, rowBounds);
		System.out.println(refreshId);
		return list;
	}

}
