package com.atelier.testConfig;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.atelier.config.RootConfig;
import com.atelier.config.ServletConfig;

import lombok.Setter;

@RunWith(SpringJUnit4ClassRunner.class)
//지정된 클래스나 문자열을 이용하여 필요한 객체들을 스프링 내에 객체로 등록하게 됨 (Bean으로 등록하게 됨)
//아래와 같이 classpath 혹은 file 을 사용할 수 있음
//@ContextConfiguration(locations = "classpath:src/main/webapp/WEB-INF/spring/root-context.xml")
//근데 문제. webapp은 classPath가 아니기 때문에, classpath를 사용하여 위치 지정을 해 줄 수 없다.
//그러므로 file을 사용하고, 해당 configueration을 상속받아 사용할 수 있도록 하자
//https://hightin.tistory.com/42 참고하기
//테스트에서 ServletConfig.class (@EnableWebMvc를 가지고 있음) 등과 같은 MVC 관련 bean이 포함되면 junt에서 예외를 던진다. 
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class})
@WebAppConfiguration
public abstract class ApplicationContextTest {
	@Setter(onMethod_ = @Autowired)
	protected ApplicationContext context;
  
	@Setter(onMethod_ = @Autowired)
	protected WebApplicationContext ctx;
  
	protected MockMvc mockMvc;
  
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
}