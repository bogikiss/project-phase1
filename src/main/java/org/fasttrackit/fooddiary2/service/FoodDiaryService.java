package org.fasttrackit.fooddiary2.service;

import org.fasttrackit.fooddiary2.model.FoodDiary;
import org.fasttrackit.fooddiary2.repository.FoodDiaryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodDiaryService {
    private final FoodDiaryRepository repository;

    public FoodDiaryService(FoodDiaryRepository repository) {
        this.repository = repository;
    }

    public List<FoodDiary> getAllFoodDiaries() {
        return repository.findAll();
    }
}
