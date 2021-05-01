package com.atelier.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;

import com.atelier.testConfig.ApplicationContextTest;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
public class DataSourceTest extends ApplicationContextTest{

	@Setter(onMethod_ = @Autowired)
	private DataSource dataSource;
	
	@Test
	public void testConnection() {
		try (Connection con = dataSource.getConnection()){
			log.info(con);
			log.info("DB 연결 성공!");
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}//DataSourceTest Class end
