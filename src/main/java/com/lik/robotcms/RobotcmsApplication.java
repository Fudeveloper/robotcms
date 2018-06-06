package com.lik.robotcms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.lik.robotcms.mapper*")
@SpringBootApplication
public class RobotcmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RobotcmsApplication.class, args);
	}
}
