package com.atelier.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer{
	
	/*
    1. 스프링이 시작되면 먼저 ApplicationContext라는 이름의 객체가 만들어짐.
    2. 그 다음 스프링이 객체를 관리하고 생성해야하는 객체들에 대한 설정이 필요함 (root-context.xml파일, 혹은 getRootConfigClasses의 반환값이 되는 클래스)
    3. 만약 여러 설정들을 다른 클래스로 나누어서 관리한다면, return 값에 여러 클래스를 써주면 됨
    */
    @Override
    // root-context.xml을 대신하는 메소드 (DB, Bean scan 등의 내용을 작성)
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {RootConfig.class}; 
    }

    @Override
    // servlet-context.xml을 대신하는 메소드 (웹 관련 설정파일)
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {ServletConfig.class};
    }

    @Override
    // 기본 Servlet 매핑 경로를 지정
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
    
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
        // 파일 업로드 설정 (파일은 서버 컴퓨터의 어딘가의 폴더에 저장된다.
        MultipartConfigElement multipartConfig = new MultipartConfigElement("C:\\upload\\tmp", 20971520, 41943040, 20971520);
        registration.setMultipartConfig(multipartConfig);
    }

    // 한글 필터
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return new Filter[] {characterEncodingFilter};
    }
    
    // 에러페이지
    @Bean
    public SimpleMappingExceptionResolver getExceptionResolver() {
    	SimpleMappingExceptionResolver smer = new SimpleMappingExceptionResolver();
    	smer.setDefaultErrorView("/WEB-INF/views/error/error404.jsp");
    	return smer;
    }
}
