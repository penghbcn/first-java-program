package springboot_docker_demo.mapper.beta;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BetaMapper {

	@Select("select name from test where id=#{id}")
	String selectNameById(String id);
}
