package com.api.lojamaterial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class 	LojaMaterialApplication {

	public static void main(String[] args) {
		SpringApplication.run(LojaMaterialApplication.class, args);
	}

	@GetMapping("/teste")
	public String index(){
		return "Api cadastro de materiais";
	}

}
