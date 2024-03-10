package org.fasttrackit.fooddiary2.service;

import org.fasttrackit.fooddiary2.exceptions.ResourceNotFoundException;
import org.fasttrackit.fooddiary2.model.Client;
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

    public FoodDiary getFoodDiaryById(Long id) {
        FoodDiary foodDiary = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Food diary with id:%s was not found".formatted(id)));
        return foodDiary;
    }

    public FoodDiary addNewFoodDiary(FoodDiary newFoodDiary) {
        return repository.save(newFoodDiary);
    }

    public FoodDiary deleteById(Long id) {
        FoodDiary foodDiaryToBeDeleted = getFoodDiaryById(id);
        repository.deleteById(id);
        return foodDiaryToBeDeleted;
    }
}
