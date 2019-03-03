package springboot_docker_demo.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

@Configuration
@MapperScan(basePackages = "springboot_docker_demo.mapper.alpha", sqlSessionFactoryRef = "alphaSqlSessionFactory")
public class AlphaDruidConfiguration {

	@Primary
	@Bean(name = "alphaDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.druid.alpha")
	public DataSource alphaDataSource() {
		DruidDataSource druidDataSource = DruidDataSourceBuilder.create().build();
		return druidDataSource;
	}

	@Primary
	@Bean(name = "alphaSqlSessionFactory")
	public SqlSessionFactory alphaSqlSessionFactory(@Qualifier("alphaDataSource") DataSource dataSource)
			throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		return sqlSessionFactoryBean.getObject();
	}

	@Primary
	@Bean
	public DataSourceTransactionManager alphaDataSourceTransactionManager(
			@Qualifier("alphaDataSource") DataSource dataSource) {
		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource);
		return dataSourceTransactionManager;
	}

}
