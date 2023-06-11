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
	/*@Bean
	public CommandLineRunner commandLineRunner(
			AuthenticationService service
	) {
		return args -> {
			var admin = RegisterRequest.builder()
					.nom("Admin")
					.prenom("Admin")
					.mail("admin@mail.com")
					.motdePasse("password")
					.role(ADMIN)
					.build();
			System.out.println("Admin token: " + service.register(admin).getToken());

			var manager = RegisterRequest.builder()
					.nom("Admin")
					.prenom("Admin")
					.mail("manager@mail.com")
					.motdePasse("password")
					.role(MANAGER)
					.build();
			System.out.println("Manager token: " + service.register(manager).getToken());

		};
	}*/
}
