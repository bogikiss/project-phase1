package org.fasttrackit.fooddiary2.service;

import org.fasttrackit.fooddiary2.model.Food;
import org.fasttrackit.fooddiary2.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    private final FoodRepository repository;

    public FoodService(FoodRepository repository) {
        this.repository = repository;
    }

    public List<Food> getAllFoods() {
        return repository.findAll();
    }

}
