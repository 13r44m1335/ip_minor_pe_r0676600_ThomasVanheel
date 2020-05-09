package com.example.taskr0676600;

import com.example.taskr0676600.domain.model.Subtask;
import com.example.taskr0676600.domain.model.Task;
import com.example.taskr0676600.domain.model.User;
import com.example.taskr0676600.domain.model.UserRole;
import com.example.taskr0676600.repository.TaskRepository;
import com.example.taskr0676600.repository.TaskRepositoryLocal;
import com.example.taskr0676600.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.time.Month;

import static com.example.taskr0676600.domain.model.UserRole.ADMIN;

@SpringBootApplication
public class TaskR0676600Application {

	public static void main(String[] args) {
		SpringApplication.run(TaskR0676600Application.class, args);
	}


	@Bean
	CommandLineRunner Runner(TaskRepository repository, UserRepository userRepository){
		//Subtask subtask = new Subtask("title", "Description");
		return args -> {
			repository.save(new Task("Ip-minor taak",
				"maken van een takenlijst",
				LocalDateTime.of(2020, Month.MAY,25,22,30)));
			repository.save(new Task("Mobiele toepassingen taak",
					"maken van een finance app",
					LocalDateTime.of(2022, Month.JUNE,1,23,30)));


			//userRepository.save(new User("admin","admin",ADMIN));


		};
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}
