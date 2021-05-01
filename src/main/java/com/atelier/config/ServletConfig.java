package com.atelier.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.multipart.commons.CommonsFileUploadSupport;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

//servlet-context.xml에 설정된 모든 내용을 담는 클래스
@EnableWebMvc // 여기서는 @EnableWebMvc 어노테이션 + WebMvcConfigurer 인터페이스 상속을 받아서 사용함
@ComponentScan(basePackages = {"com.atelier.at.controller","com.atelier.main.controller","com.atelier.mypage.controller"
														,"com.atelier.ad.controller", "com.atelier.co.controller"})
public class ServletConfig implements WebMvcConfigurer{

    @Override
    // viewResolver 설정
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/views/");
        bean.setSuffix(".jsp");
        registry.viewResolver(bean);
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
}