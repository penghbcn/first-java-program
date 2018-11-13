package yohm.web.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
import yohm.web.vo.News;

public interface NewsMapper extends Mapper<News>, MySqlMapper<News> {

}
