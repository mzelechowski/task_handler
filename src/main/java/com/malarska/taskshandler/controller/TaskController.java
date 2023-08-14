package com.malarska.taskshandler.controller;

import com.malarska.taskshandler.domain.Task;
import com.malarska.taskshandler.repositories.TasksRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Optional;

@Controller
public class TaskController {
    private final String title="Tasks Handler ver. 2023.08.13";

    public static final Logger logger= LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private TasksRepository tasksRepository;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("title", title);
        model.addAttribute("tasks", tasksRepository.findAll());
        return "index";
    }


    @GetMapping("/user/{id}")
    public String single(@PathVariable("id") int id, Model model){
        model.addAttribute("title", title);
        model.addAttribute("tasks", tasksRepository.findById(id).get());
        return "task";
    }

    @PostMapping("/delete")
    public String deleteRecord(@RequestParam("id") int id){
        logger.debug("input id:{}", id);
        tasksRepository.deleteById(id);
        return "redirect:/";
    }

    @PostMapping("/add-task")
    public String addTask(@RequestParam String name,
                          @RequestParam double breaklength,
                          @RequestParam(required = false) boolean again) {

        Task task = new Task(name, null, breaklength, false, again);
        tasksRepository.save(task);
        return "redirect:/";
    }

    @PostMapping("/start")
    public String startTask(@RequestParam int id) {
        Optional<Task> optionalTask = tasksRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
//            if (task.getStartDate() == null) {
                LocalDateTime initialDateTime = LocalDateTime.now();
                task.setStartDate(initialDateTime);
                task.setEndDate(initialDateTime.plusSeconds((long) (task.getBreaklength()*60)));
                tasksRepository.save(task);
//            }
        }

        return "redirect:/";
    }

    @PostMapping("/stop")
    public String stopTask(@RequestParam int id) {
        Optional<Task> optionalTask = tasksRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setStartDate(null);
            task.setEndDate(null);
            tasksRepository.save(task);
        }
        return "redirect:/";
    }

}
