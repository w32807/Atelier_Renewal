package com.atelier.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
public class TilesConfig {
    
    @Bean(name = "tilesConfigure")
    // Tiles Configure를 위한 경로 지정
    public TilesConfigurer tileConfigurer() {
    	final TilesConfigurer configurer = new TilesConfigurer();
    	configurer.setDefinitions(new String[] {"WEB-INF/views/tiles"});
    	configurer.setCheckRefresh(true);
    	return configurer;
    }
    
    @Bean(name = "viewResolver")
    // tiles ViewResolver
    public TilesViewResolver TilesViewResolver() {
    	final TilesViewResolver resolver = new TilesViewResolver();
    	resolver.setViewClass(TilesView.class);
    	resolver.setOrder(1); // TilesViewResolver를 가장 먼저 타도록 우선순위를 설정 
    	return resolver;
    }
}
