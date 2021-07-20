package com.atelier.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.atelier.filter.CustomAuthenticationFilter;
import com.atelier.main.login.security.CustomAuthenticationProvider;
import com.atelier.main.login.security.LoginFailureHandler;
import com.atelier.main.login.security.LoginSuccessHandler;
import com.atelier.main.login.service.UserDetailsServiceImpl;
import com.atelier.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private final UserRepository userRepository;
	
	@Override
	// 정적자원에 대해서는 Security 설정을 허용하지 않음
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().requestMatchers().antMatchers("/resources/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// https://mangkyu.tistory.com/77 참고하기
		
		// 일단 모든 접근 허용
		http.authorizeRequests().antMatchers("/*").permitAll().and().csrf().disable();
		
		//  로그인 시
		http.formLogin().loginPage("/login").loginProcessingUrl("/loginProc")
			.successHandler(loginSuccessHandler()).failureHandler(loginFailuerHandler());
		
		// 로그아웃 시
		http.logout().logoutUrl("/logout").invalidateHttpSession(true).deleteCookies("remember-me", "JSESSION_ID");
	}
	/*
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService()).passwordEncoder(passwordEncoder());
	}
	*/
	@Bean
	public UserDetailsService userDetailService() {
		return new UserDetailsServiceImpl(userRepository);
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
	
	@Bean
	public CustomAuthenticationFilter customAuthenticationFilter() throws Exception{
		CustomAuthenticationFilter authenticationFilter = new CustomAuthenticationFilter(authenticationManager());
		authenticationFilter.setFilterProcessesUrl("/loginProc");
		authenticationFilter.setAuthenticationSuccessHandler(loginSuccessHandler());
		authenticationFilter.setAuthenticationFailureHandler(loginFailuerHandler());
		authenticationFilter.afterPropertiesSet(); // ????
		return authenticationFilter;
	}
	
	@Bean public CustomAuthenticationProvider customAuthenticationProvider() { 
		return new CustomAuthenticationProvider(userDetailService(), passwordEncoder()); 
		}

}
