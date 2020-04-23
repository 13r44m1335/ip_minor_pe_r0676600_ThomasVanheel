package com.example.taskr0676600.controller;


import com.example.taskr0676600.domain.model.Subtask;
import com.example.taskr0676600.domain.service.TaskServiceImpl;
import com.example.taskr0676600.dto.SubtaskDTO;
import com.example.taskr0676600.dto.TaskDTO;
import com.example.taskr0676600.domain.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
public class TaskController {
    @Qualifier("TaskServiceImpl")
    @Autowired
    TaskService taskService;

    @GetMapping("/")
    public String getIndex()
    {
        return "index";
    }

    //get tasks
    @GetMapping("/tasks")
    public String getTasks(Model model){
        model.addAttribute("tasks", taskService.getTasks());
        return "tasks";
    }

    @GetMapping("/tasks/{id}")
    public String getTask(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("task", taskService.getTaskById(id));
        model.addAttribute("subtasks",taskService.getTaskById(id).getSubtasks());
        return "taskDetail";
    }


    //create task
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

    //edit task
    @GetMapping("/tasks/edit/{id}")
    public String goEditTask(Model model, @PathVariable("id") Integer id){
        model.addAttribute("task", taskService.getTask(id));
        model.addAttribute("subtasks",taskService.getTaskById(id).getSubtasks());
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

    //remove task
    @GetMapping("/tasks/{id}/remove")
    public String removeTask(@PathVariable("id") Integer id) {
        taskService.removeTask(id);
        return "redirect:/tasks";
    }

    //create subtask
    @PostMapping("/tasks/{id}/sub/create")
    public String createSub(@Valid SubtaskDTO subtaskDTO, Model model, @PathVariable("id") Integer id, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            taskService.addSubtask(id, subtaskDTO);
        }
        return "redirect:/tasks/{id}";
    }

    //remove subtask
    @GetMapping("/tasks/{id}/sub/{subtaskid}/remove")
    public String removeSubTask(@PathVariable("id") Integer id, @PathVariable("subtaskid") Integer subtaskid) {
        taskService.removeSubtask(id, subtaskid);
        return "redirect:/tasks/{id}";
    }

    //edit subtask
    @GetMapping("/tasks/{id}/sub/{subtaskid}/edit")
    public String goToEditSubTask(Model model, @PathVariable("id") Integer id, @PathVariable("subtaskid") Integer subtaskid) {
        Subtask s = taskService.getSubtask(id,subtaskid);
        model.addAttribute("subtask", taskService.getSubtask(id,subtaskid));
        model.addAttribute("taskId",id);
        model.addAttribute("subtaskid",subtaskid);
        model.addAttribute("title",s.getTitle());
        model.addAttribute("description",s.getDescription());
        return "editSubtask";
    }

    @PostMapping("/tasks/{id}/sub/{subtaskid}/edit")
    public String editSubTask(@Valid SubtaskDTO subtaskDTO, @PathVariable("id") Integer id, @PathVariable("subtaskid") Integer subtaskid, BindingResult bindingResult,Model model) {
        if (!bindingResult.hasErrors()) {
            taskService.editSubtask(id,subtaskid, subtaskDTO);
            return "redirect:/tasks/{id}";
        } else {
            System.out.println(bindingResult.getAllErrors());
            model.addAttribute("task", taskService.getTask(id));
            model.addAttribute("subtasks",taskService.getTaskById(id).getSubtasks());
            return "/tasks/edit/{id}";
        }
    }







}
