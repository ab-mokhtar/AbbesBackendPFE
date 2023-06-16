package com.example.BackendPFE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
//@SpringBootApplication(scanBasePackages = {"test"} , exclude = JpaRepositoriesAutoConfiguration.class  )
//@ComponentScan(basePackages = "com.example.BackendPFE.demo")
//@EnableTransactionManagement
//@EnableAdminServer
//@EnableAutoConfiguration
//@SpringBootApplication(scanBasePackages = {"com.module.restapi1.controller"})
public class BackendPfeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendPfeApplication.class, args);
	}
}
