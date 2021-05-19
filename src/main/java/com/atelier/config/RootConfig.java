package com.atelier.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration // xml 대신 설정파일로 만들고자 하는 클래스에 붙이는 어노테이션
@EnableScheduling
@EnableTransactionManagement // 트랜잭션 사용을 위한 선언 <tx:annotation-driven/>과 매칭됨
// controller외의 Bean 패키지를 스캔
@ComponentScan(basePackages = {"com.atelier.*.service"})
@MapperScan(basePackages = {"com.atelier.dao"})
public class RootConfig {
	
	@Value("#{global['db.driver']}") 
	private String dbDriver;
	
	@Value("#{global['db.url']}") 
	private String dbUrl;
	
	@Value("#{global['db.username']}") 
	private String dbUser;
	
	@Value("#{global['db.password']}") 
	private String dbPassword;

	// Hikari CP를 이용한 DataSource Bean 생성
	@Bean
	public DataSource dataSource() {
	    HikariConfig hikariConfig = new HikariConfig();
		
	    hikariConfig.setDriverClassName(dbDriver);
	    hikariConfig.setJdbcUrl(dbUrl);
	    hikariConfig.setUsername(dbUser);
	    hikariConfig.setPassword(dbPassword);
	    return new HikariDataSource(hikariConfig);
	}
 
	// properties 파일 관리를 위한 Bean 등록
	// Junit과 tomcat의 RootConfig, ServletConfig의 실행순서가 다른 지는 몰라도, @Value와 같은 파일에 작성하지 않으면
	// Junit에서는 DB연결이 되나, tomcat에서는 안되는 상황이 발생할 수 있다. 
	@Bean(name = "global")
	public PropertiesFactoryBean properties() {
		PropertiesFactoryBean bean = new PropertiesFactoryBean();
		bean.setLocation(new ClassPathResource("com/atelier/properties/global.properties"));
		bean.setFileEncoding("UTF-8");
		return bean;
	}
 
	@Bean
	// mybatis 관련 설정으로 sqlSession을 생성
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		return (SqlSessionFactory) sessionFactory.getObject(); // Object를 얻어 형변환
	}
    
    @Bean(name = "transactionManager")
    public PlatformTransactionManager txManager() {
    	return new DataSourceTransactionManager(dataSource());
    }
}