package com.casestudy.couponeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
@EnableEurekaServer
public class CouponEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CouponEurekaServerApplication.class, args);
	}

}
