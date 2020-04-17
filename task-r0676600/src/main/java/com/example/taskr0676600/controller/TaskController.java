package com.example.taskr0676600.controller;


import com.example.taskr0676600.dto.TaskDTO;
import com.example.taskr0676600.domain.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import javax.validation.Valid;

@Controller
//@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String getIndex()
    {
        return "index";
    }


    @GetMapping("/tasks")
    public String getTasks(Model model){
        model.addAttribute("tasks", taskService.getTasks());
        return "tasks";
    }

    @GetMapping("/tasks/{id}")
    public String getTask(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("task", taskService.getTask(id));
        //model.addAttribute("subTasks",taskService.getSubtasks(id));
        return "taskDetail";
    }



    @GetMapping("/tasks/new")
    public String createTask(){
        return "createTask";
    }

    @PostMapping("/tasks/createTask")
    public String newTask(@Valid TaskDTO taskDTO, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            taskService.addTask(taskDTO);
            return "redirect:/tasks";
        } else {
            return "/tasks/new";
        }
    }





    @PostMapping
    public String addTask(@ModelAttribute TaskDTO taskDTO){
        taskService.addTask(taskDTO);
        return "redirect:/tasks";
    }
}
