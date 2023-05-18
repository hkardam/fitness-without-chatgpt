package com.crud.service;

import com.crud.model.Exercises;
import com.crud.repository.ExercisesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExercisesService {
    @Autowired
    ExercisesRepository exercisesRepository;

    public List<Exercises> getAll() {
        List<Exercises> exercises = new ArrayList<>();
        exercisesRepository.findAll().forEach(books1 -> exercises.add(books1));
        return exercises;
    }

    public Exercises getById(int id) {
        return exercisesRepository.findById(id).get();
    }

    public void create(Exercises exercises) {
        exercisesRepository.save(exercises);
    }

    public void update(int id, Exercises exercises) {
        exercisesRepository.save(exercises);
    }

    public void delete(int id) {
        exercisesRepository.deleteById(id);
    }
}
