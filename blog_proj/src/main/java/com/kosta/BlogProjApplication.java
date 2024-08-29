package com.kosta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing//created_at, updated_at 자동으로 업데이트
@SpringBootApplication
public class BlogProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogProjApplication.class, args);
	}

}
