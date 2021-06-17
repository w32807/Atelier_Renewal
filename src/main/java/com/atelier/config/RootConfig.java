package com.atelier.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.hibernate5.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration // xml 대신 설정파일로 만들고자 하는 클래스에 붙이는 어노테이션
@EnableScheduling
@EnableTransactionManagement // 트랜잭션 사용을 위한 선언 <tx:annotation-driven/>과 매칭됨
// controller외의 Bean 패키지를 스캔
// hibernate-vaildator API도 있음
@ComponentScan(basePackages = {"com.atelier.*.service", "com.atelier.*.*.service", "com.atelier.validator"})
@MapperScan(basePackages = {"com.atelier.dao"})
@EnableJpaRepositories(basePackages = {"com.atelier.testJpa", "com.atelier.repository"}, entityManagerFactoryRef="emf", transactionManagerRef="jpaTxManager")
@EnableJpaAuditing
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
 
	@Bean(name = "sqlSessionFactory")
	// mybatis 관련 설정으로 sqlSession을 생성
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		return (SqlSessionFactory) sessionFactory.getObject(); // Object를 얻어 형변환
	}
    
    @Bean(name = "mybatisTxManager")
    public PlatformTransactionManager transactionManager() {
    	return new DataSourceTransactionManager(dataSource());
    }
    
    /////////////////////////////////////////////////////////////////
    // Hibernate 설정을 위한 Bean 설정 (Hibernate로 한번에 변경이 어려우므로, Mybatis와 동시 사용을 위함)
    // JPA 사용을 위해서 JPA transaction manager를 사용해야 하며 Hibernate를 이용하여 JPA transaction manager bean을 설정한다.

    @Bean 
    // 1. LocalContainerEntityManagerFactoryBean에 주입할 HibernateJpaVendorAdapter 생성
    // JPA를 구현한 Hibernate 만의 설정을 해주는 bean (그러나 properties를 만들어 설정해주어도 된다)
    public HibernateJpaVendorAdapter hibernateJpaVendorAdapter() { 
    	HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter(); 
    	hibernateJpaVendorAdapter.setShowSql(true); 
    	hibernateJpaVendorAdapter.setGenerateDdl(true);
    	return hibernateJpaVendorAdapter; 
    }
    
    @Bean(name = "emf")
    // 스프링이 직접 제공하는 컨테이너 관리 EntityManager를 구현한 EntityManagerFactory를 만들어준다. 
    // 이 방법을 이용하면 JavaEE 서버에 배치하지 않아도 컨테이너에서 동작하는 
    // JPA의 기능을 활용할 수 있을 뿐만 아니라, 스프링이 제공하는 일관성 있는 데이터 액세스 기술의 
    // 접근 방법을 적용할 수 있고 스프링의 JPA 확장 기능도 활용할 수 있다.
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        // 1) Factory Bean에 adaptor 주입 (JPA를 구현한 제품은 여러가지가 있는데 그 제품마다 설정방법이 다르다.
        // 그러나 adaptor를 주입해주면, 각 제품마다 설정이 달라고 JPA 설정에서는 동일한 코드 사용이 가능하다.
        emf.setJpaVendorAdapter(hibernateJpaVendorAdapter());
        // 2) Entity를 스캔
        emf.setPackagesToScan("com.atelier.dto","com.atelier.entity");
        //emf.setPackagesToScan(new String []{"com.atelier.dto"});
        emf.setDataSource(dataSource());
        // POJO 클래스의 바이트 코드를 조작하여, 지연된 로딩, 엔티티 값의 변화를 추적, 최적화와 그룹 페칭 등을 사용하기 위한 LTW 주입
        emf.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
        emf.setJpaProperties(hibernateProperties());
        emf.afterPropertiesSet();
        return emf;
    }

    // JPA 사용을 위해서는 hibernate transaction manager가 아닌 JpaTransactionManager를 사용해야 한다.
    @Bean(name = "jpaTxManager")
    public PlatformTransactionManager jpaTransactionManager() throws Exception {
    	return new JpaTransactionManager(entityManagerFactory().getObject());
    }   
    
    @Bean
    public HibernateExceptionTranslator hibernateExceptionTranslator() {
        return new HibernateExceptionTranslator();
    }
    
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        // hibernate의 ddl 사용. 보통 실 운영 DB에서는 none을, create는 있는 테이블을 지우고 재 생성, update 는 테이블이 있으면 그대로, 없으면 생성을 한다.
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        // hibernate와 사용하는 DB를 연결
        properties.setProperty("hibernate.hbm2ddl.dialect", "org.hibernate.dialect.MySQL8Dialect");
        // hibernate5 이상부터는 jta.platform 설정을 해 주어야 한다.
        properties.setProperty("hibernate.transaction.jta.platform", "org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform");
        // hibernate의 자동키 생성 전략 설정
        properties.setProperty("hibernate.id.new_generator_mappings", "true");
        return properties;
    }

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
    	ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
    	// 주의점. message 프로퍼티의 확장자명을 적어주면 안된다.
    	source.setBasename("classpath:com/atelier/properties/message");
    	source.setDefaultEncoding("UTF-8");
    	source.setCacheSeconds(600);
    	source.setUseCodeAsDefaultMessage(true);
    	return source;
    }
    
}