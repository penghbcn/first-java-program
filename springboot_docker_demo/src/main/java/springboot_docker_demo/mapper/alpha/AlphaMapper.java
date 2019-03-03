package springboot_docker_demo.mapper.alpha;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AlphaMapper {
	@Select("select name from test where id=#{id}")
	String selectNameById(String id);
}
