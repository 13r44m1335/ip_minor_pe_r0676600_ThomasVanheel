package com.example.taskr0676600.controller;


import com.example.taskr0676600.dto.SubtaskDTO;
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
        model.addAttribute("subtasks",taskService.getSubtasks(id));
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
        model.addAttribute("subtasks",taskService.getSubtasks(id));
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

    @GetMapping("/tasks/{id}/remove")
    public String removeTask(@PathVariable("id") Integer id) {
        taskService.removeTask(id);
        return "redirect:/tasks";
    }

    @PostMapping("/tasks/{id}/sub/create")
    public String createSub(@Valid SubtaskDTO subtaskDTO, Model model, @PathVariable("id") Integer id, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            taskService.addSubTask(id, subtaskDTO);
        }
        return "redirect:/tasks/{id}";
    }

    @GetMapping("/tasks/{id}/sub/{subId}/remove")
    public String removeSubTask(@PathVariable("id") Integer id, @PathVariable("subId") Integer subId) {
        taskService.removeSubTask(id, subId);
        return "redirect:/tasks/{id}";
    }

    @GetMapping("/tasks/{id}/sub/{subId}/edit")
    public String goToEditSubTask(Model model, @PathVariable("id") Integer id, @PathVariable("subId") Integer subId) {
        model.addAttribute("task", taskService.getSubTask(id,subId));
        model.addAttribute("taskId",id);
        model.addAttribute("subId", subId);
        return "editSubtask";
    }

    @PostMapping("/tasks/{id}/sub/{subId}/edit")
    public String editSubTask(@Valid SubtaskDTO subtaskDTO, @PathVariable("id") Integer id, @PathVariable("subId") Integer subId, BindingResult bindingResult,Model model) {
        if (!bindingResult.hasErrors()) {
            taskService.editSubTask(id, subtaskDTO);
            return "redirect:/tasks/{id}";
        } else {
            System.out.println(bindingResult.getAllErrors());
            model.addAttribute("task", taskService.getTask(id));
            model.addAttribute("subtasks",taskService.getSubtasks(id));
            return "/tasks/edit/{id}";
        }
    }







}
