package com.fst.commandeapiv4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.fst.commandeapiv4.domain.rest")
public class CommandeApiV4Application {

	public static void main(String[] args) {
		SpringApplication.run(CommandeApiV4Application.class, args);
	}

}

