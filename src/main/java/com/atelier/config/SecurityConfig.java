package com.atelier.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.atelier.login.LoginFailureHandler;
import com.atelier.login.LoginSuccessHandler;
import com.atelier.login.service.UserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 일단 모든 접근 허용
		http.authorizeRequests().antMatchers("/*").permitAll().and().csrf().disable();
		
		//  로그인 시
		http.formLogin().loginPage("/login").loginProcessingUrl("/loginProc")
			.successHandler(loginSuccessHandler()).failureHandler(loginFailuerHandler());
		
		// 로그아웃 시
		http.logout().logoutUrl("/logout").invalidateHttpSession(true).deleteCookies("remember-me", "JSESSION_ID");
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
	}
	
	@Bean
	public UserDetailsService userDetailService() {
		return new UserDetailService(null);
	}
	
	@Bean
	public AuthenticationSuccessHandler loginSuccessHandler() {
		return new LoginSuccessHandler();
	}

	@Bean
	public AuthenticationFailureHandler loginFailuerHandler() {
		return new LoginFailureHandler();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
