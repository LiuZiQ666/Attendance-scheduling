package com.elead.group4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.elead.group4.mapper")
public class AttendanceSchedulingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AttendanceSchedulingApplication.class, args);
	}

}
