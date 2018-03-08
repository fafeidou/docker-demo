package com.anxpp.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class DockerApplication {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public static void main(String[] args) {
		SpringApplication.run(DockerApplication.class, args);
	}
	@RequestMapping("/")
	public String index(){
		Integer integer = jdbcTemplate.queryForObject("select count(1) from city", Integer.class);

		return integer.toString();
	}
}