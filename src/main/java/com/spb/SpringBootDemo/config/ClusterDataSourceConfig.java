package com.spb.SpringBootDemo.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
//扫描 Mapper 接口并容器管理
@MapperScan(basePackages = ClusterDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "clusterSqlSessionFactory")
public class ClusterDataSourceConfig {

	 // 精确到 cluster 目录，以便跟其他数据源隔离
	 static final String PACKAGE = "com.spb.SpringBootDemo.dao.cluster";
	 static final String MAPPER_LOCATION = "classpath:mapper/cluster/*.xml";
	
	 @Bean(name = "clusterDataSource")
	 @ConfigurationProperties(prefix = "spring.datasource.cluster")
	 public DataSource clusterDataSource() {
		 return DataSourceBuilder.create().build();
	 }
	
	 @Bean(name = "clusterTransactionManager")
	 public DataSourceTransactionManager clusterTransactionManager() {
	     return new DataSourceTransactionManager(clusterDataSource());
	 }
	
	 @Bean(name = "clusterSqlSessionFactory")
	 public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("clusterDataSource") DataSource clusterDataSource)
	         throws Exception {
	     final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
	     sessionFactory.setDataSource(clusterDataSource);
	     sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver() .getResources(ClusterDataSourceConfig.MAPPER_LOCATION));
	     return sessionFactory.getObject();
	 }
}