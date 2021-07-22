package com.atelier.config;

import javax.sql.DataSource;

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
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

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
	private final DataSource dataSource;
	
	@Override
	// 정적자원에 대해서는 Security 설정을 허용하지 않음
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().requestMatchers().antMatchers("/resources/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// https://mangkyu.tistory.com/77 참고하기
		
		// 일단 모든 접근 허용
		http.authorizeRequests().antMatchers("/*").permitAll()
			
			//  로그인 시
			.and().formLogin().loginPage("/login").successHandler(loginSuccessHandler()).failureHandler(loginFailuerHandler())
			// 자동로그인
			.and().rememberMe().key("reMeKey").rememberMeParameter("reMeChk").tokenValiditySeconds(60*60*7).tokenRepository(jdbcTokenRepositoryImpl())
			.rememberMeServices(rememberMeServices())
			// 로그아웃 시 
			.and().logout().logoutUrl("/logout").invalidateHttpSession(true).deleteCookies("remember-me", "JSESSION_ID")
			.and().csrf().disable();
	}

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
		//authenticationFilter.setFilterProcessesUrl("/loginProc");
		authenticationFilter.setAuthenticationSuccessHandler(loginSuccessHandler());
		authenticationFilter.setAuthenticationFailureHandler(loginFailuerHandler());
		authenticationFilter.afterPropertiesSet(); // ????
		return authenticationFilter;
	}
	
	@Bean 
	public CustomAuthenticationProvider customAuthenticationProvider() { 
		return new CustomAuthenticationProvider(userDetailService(), passwordEncoder()); 
	}
	
	@Bean
	public RememberMeServices rememberMeServices() {
		PersistentTokenBasedRememberMeServices rememberMeServices = new PersistentTokenBasedRememberMeServices("reMeKey", userDetailService(), jdbcTokenRepositoryImpl());
		rememberMeServices.setParameter("reMeChk");
		rememberMeServices.setAlwaysRemember(true);
		return rememberMeServices;
	}
	
    @Bean
    public PersistentTokenRepository jdbcTokenRepositoryImpl() {
        JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
        db.setCreateTableOnStartup(false); //테이블 정보가 없으면 INSERT 한다. //처음 실행 할때 true 로 하고 그다음부터 false 로 하면 될듯;;?
        db.setDataSource(dataSource);
        return db;
    }
	

}
