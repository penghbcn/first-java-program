package springboot_docker_demo.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

@Configuration
@MapperScan(basePackages = "springboot_docker_demo.mapper.beta", sqlSessionFactoryRef = "betaSqlSessionFactory")
public class BetaDruidConfiguration {

	@Bean(name = "betaDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.druid.beta")
	public DataSource dataSourceOne() {
		DruidDataSource druidDataSource = DruidDataSourceBuilder.create().build();
		return druidDataSource;
	}

	@Bean(name = "betaSqlSessionFactory")
	public SqlSessionFactory alphaSqlSessionFactory(@Qualifier("betaDataSource") DataSource dataSource)
			throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		return sqlSessionFactoryBean.getObject();
	}

	@Bean
	public DataSourceTransactionManager alphaDataSourceTransactionManager(
			@Qualifier("betaDataSource") DataSource dataSource) {
		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource);
		return dataSourceTransactionManager;
	}

}
