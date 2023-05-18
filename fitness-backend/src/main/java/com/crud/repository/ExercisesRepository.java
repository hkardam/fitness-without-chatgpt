package com.crud.repository;

import com.crud.model.Exercises;
import org.springframework.data.repository.CrudRepository;

public interface ExercisesRepository  extends CrudRepository<Exercises, Integer> {
}
