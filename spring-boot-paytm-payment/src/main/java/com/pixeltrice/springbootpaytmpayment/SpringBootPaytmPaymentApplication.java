package com.pixeltrice.springbootpaytmpayment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;



@Configuration
@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
@EnableEurekaClient
public class SpringBootPaytmPaymentApplication{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPaytmPaymentApplication.class, args);
	}
}
