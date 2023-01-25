package com.example.trackersystem.controller;


import org.springframework.web.bind.annotation.*;
import  com.example.trackersystem.Pogo.Task;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

    ArrayList<Task> tasks =  new ArrayList<Task>();

    //Create a new taks
    @PostMapping("/create")
    public String createtask(@RequestBody  Task task){
        tasks.add(task);
        return "the task added successfully :)";
    }
    //Display all tasks .
    @GetMapping("/get")
    public ArrayList <Task> getTasks(){
        return tasks;
    }
    //Update a task
    @PutMapping("/update/{index}")
    public String updatetask(@PathVariable int index , @RequestBody Task task){
        tasks.set(index,task);
        return "the task updated successfully :)";

    }
    //Delete a task
    @DeleteMapping("/delete/{index}")
    public String deletetask(@PathVariable int index ){
        tasks.remove(index);
        return "the task deleted :)";
    }
    //Change the task status as done or not
    @PutMapping("/change/task/{index}")
    public String changetask(@PathVariable int index ,@RequestBody Task task ){
        if(task.getStatus().equals("not done")){
            task.setStatus("done");
            tasks.set(index,task);
        }
        return "the task updated successfully";
    }

    //Search for a task by given title
    @GetMapping("/search/{title}")
    Optional<Task> searchbytitle(@PathVariable String title){
        for(Task task :tasks){
            if(title.equals(task.getTitle())){
                return Optional.of(task);
            }
        }
        return Optional.empty();

    }



}
