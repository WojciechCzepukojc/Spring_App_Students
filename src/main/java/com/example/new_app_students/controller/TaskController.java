package com.example.new_app_students.controller;

import com.example.new_app_students.model.Person;
import com.example.new_app_students.model.Task;
import com.example.new_app_students.service.PersonService;
import com.example.new_app_students.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class TaskController {

    private final TaskService taskService;

    private final PersonService personService;

    public TaskController(TaskService taskService, PersonService personService) {
        this.taskService = taskService;
        this.personService = personService;
    }

    @GetMapping("/tasks")
    public String getTasks(Model model){
        List<Task> taskList = taskService.getTasks();
        model.addAttribute("task", taskList);
        return "tasks/tasks";
    }

    @GetMapping("/addTask")
    public String getAddTask(Model model) {
        List<Person> personList = personService.getPersons();
        model.addAttribute("person", personList);
        return "tasks/addTask";
    }

    @PostMapping("/addTask")
    public RedirectView postAddTask(Task task) {
        taskService.addTask(task);
        return new RedirectView("/tasks");
}
    @GetMapping("/editTask/{id}")
    public String getEditTask(@PathVariable("id") Long id, Model model){
        List<Person> personList = personService.getPersons();
        model.addAttribute("person", personList);
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "tasks/editTask";
    }

    @PostMapping("/addTask/{id}")
    public RedirectView postEditTask(@PathVariable("id") Long id, Task task){
        taskService.editTask(task);
        return new RedirectView("/tasks");

    }
    @PostMapping("/editTask/{id}")
    public RedirectView deleteTask(@PathVariable("id") Long id) {
        taskService.deleteTask(id);
        return new RedirectView("/tasks");
    }


}
