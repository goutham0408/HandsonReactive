package com.bezkoder.spring.data.cassandra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
//@Configuration
public class SpringBootDataCassandraApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataCassandraApplication.class, args);
	}

}
