package com.example.new_app_students.service;

import com.example.new_app_students.model.Task;
import com.example.new_app_students.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public void addTask(Task task){
        taskRepository.save(task);
        System.out.println("Dodano taska o id: " + task.getId());
    }

    public List<Task> getTasks(){
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id){
        return taskRepository.findById(id).orElse(null);
    }

    public void editTask(Task task){
        taskRepository.save(task);
    }

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }
}
