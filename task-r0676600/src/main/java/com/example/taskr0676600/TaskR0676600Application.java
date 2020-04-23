package com.example.taskr0676600;

import com.example.taskr0676600.domain.model.Subtask;
import com.example.taskr0676600.domain.model.Task;
import com.example.taskr0676600.repository.TaskRepository;
import com.example.taskr0676600.repository.TaskRepositoryLocal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.Month;

@SpringBootApplication
public class TaskR0676600Application {

	public static void main(String[] args) {
		SpringApplication.run(TaskR0676600Application.class, args);
	}


	@Bean
	CommandLineRunner Runner(TaskRepository repository){
		return args -> {repository.save(new Task("Ip-minor taak",
				"maken van een takenlijst",
				LocalDateTime.of(2020, Month.MAY,25,22,30)));
			repository.save(new Task("Mobiele toepassingen taak",
					"maken van een finance app",
					LocalDateTime.of(2022, Month.JUNE,1,23,30)));
			/*Task t = repository.getTaskById(1);
			Subtask s = new Subtask("/tasks","toon alle taken");
			t.addSubtask(s);
			repository.save(t);*/



		};
	}
}
