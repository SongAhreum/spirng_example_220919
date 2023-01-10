package com.example;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@SpringBootApplication 
/* 세개를 합쳐놓은 어노테이션
@Configuration              // 스프링 설정
@EnableAutoConfiguration    // 스프링 동작을 위한 많은 빈들의 목록을 등록
@ComponentScan              // (우리가 만든) 스프링 빈들을 탐색 
 */
 
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})

public class SpringExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringExampleApplication.class, args);
	}
	
}


