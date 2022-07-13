package com.mms.hr_service;

import com.mms.hr_service.entities.User;
import com.mms.hr_service.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
public class HrServiceApplication implements CommandLineRunner {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(HrServiceApplication.class, args);
	}

	@Override
	public void run(String...args) throws Exception {
		userRepository.save(new User("trung", bCryptPasswordEncoder.encode("123"), true));
	}
}
