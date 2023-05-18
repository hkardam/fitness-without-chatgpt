package com.crud.controller;

import com.crud.model.Exercises;
import com.crud.service.ExercisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/exerciseservice")
public class ExercisesController {
    @Autowired
    ExercisesService exercisesService;

    public ExercisesController(ExercisesService exercisesService) {
        this.exercisesService = exercisesService;
    }

    @GetMapping("/exercise")
    private List<Exercises> getAll() {
        return exercisesService.getAll();
    }

    @GetMapping("/exercise/{id}")
    private Exercises getById(@PathVariable("id") int id) {
        return exercisesService.getById(id);
    }

    @PostMapping("/exercise")
    private int create(@RequestBody Exercises exercises) {
        exercisesService.create(exercises);
        return exercises.getId();
    }

    @PutMapping("/exercise/{id}")
    private Exercises update(@PathVariable("id") int id, @RequestBody Exercises exercises) {
        exercisesService.update(id, exercises);
        return exercises;
    }

    @DeleteMapping("/exercise/{id}")
    private void delete(@PathVariable("id") int id) {
        exercisesService.delete(id);
    }
}
