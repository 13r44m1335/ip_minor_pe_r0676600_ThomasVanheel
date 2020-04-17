package com.example.taskr0676600.controller;


import com.example.taskr0676600.dto.TaskDTO;
import com.example.taskr0676600.domain.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
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
        //model.addAttribute("subtasks",taskService.getSubtasks(id));
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


    @GetMapping("/tasks/edit/{id}")
    public String goEditTask(Model model, @PathVariable("id") Integer id){
        model.addAttribute("task", taskService.getTask(id));
        //model.addAttribute("subtasks",taskService.getSubTask(id));
        return "editTask";
    }

    @PostMapping("/tasks/edit/{id}")
    public String editTask(@Valid TaskDTO taskDTO,@PathVariable("id") Integer id ,BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            taskService.editTask(id, taskDTO);
            return "redirect:/tasks/{id}";
        } else {
            return "/tasks/edit/{id}";
        }
    }


}
