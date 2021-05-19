package com.atelier.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsFileUploadSupport;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

//servlet-context.xml에 설정된 모든 내용을 담는 클래스
@EnableWebMvc // 여기서는 @EnableWebMvc 어노테이션 + WebMvcConfigurer 인터페이스 상속을 받아서 사용함
@ComponentScan(basePackages = {"com.atelier.*.controller"})
@EnableTransactionManagement // 트랜잭션 사용을 위한 선언 <tx:annotation-driven/>과 매칭됨
public class ServletConfig implements WebMvcConfigurer{

    @Override
    // WebMvcConfigurer 상속을 통한 기본 viewResolver 설정
    public void configureViewResolvers(ViewResolverRegistry registry) {
    	// 기본 viewResolver
        InternalResourceViewResolver resolver1 = new InternalResourceViewResolver();
        resolver1.setViewClass(JstlView.class);
        resolver1.setPrefix("/WEB-INF/views/");
        resolver1.setSuffix(".jsp");
        registry.viewResolver(resolver1);
    }
    
    @Override
    // 정적 리소스 설정
    // <resources mapping="/resources/**" location="/resources/" /> 과 대응
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
    
    // 파일 업로드를 위한 MultipartResolver Bean으로 등록
    /*
    @Bean
    public MultipartResolver multipartResolver() {
    	StandardServletMultipartResolver resolver = new StandardServletMultipartResolver();
    	return resolver;
    }
    */
    // 파일 업로드
    @Bean(name = "multipartResolver") // 메소드를 사용할 때만 Bean을 주입해준다
    public CommonsFileUploadSupport getResolver() throws IOException{
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        
        resolver.setMaxUploadSize(1024 * 1024 * 10);
        resolver.setMaxUploadSizePerFile(1024 * 1024 * 2);
        resolver.setMaxInMemorySize(1024 * 1024);
        //resolver.setUploadTempDir(new FileSystemResource("C:\\upload\\tmp"));
        resolver.setDefaultEncoding("UTF-8");
        return resolver;
    }
    
    @Bean(name = "jsonView")
    public MappingJackson2JsonView getJsonView() {
    	MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
    	jsonView.setContentType("application/json;charset=UTF-8");
    	return jsonView;
    }
    
    @Bean
    public ViewResolver customViewResolver() {
        // jsonView Resolver
        BeanNameViewResolver resolver = new BeanNameViewResolver();
        resolver.setOrder(0);
        return resolver;
    }
}