package org.fasttrackit.fooddiary2.controller;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.fooddiary2.model.Client;
import org.fasttrackit.fooddiary2.model.DaysOfWeekEnum;
import org.fasttrackit.fooddiary2.model.FoodDiary;
import org.fasttrackit.fooddiary2.model.MealsEnum;
import org.fasttrackit.fooddiary2.service.FoodDiaryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food-diaries")
@RequiredArgsConstructor
@CrossOrigin(value = "http://localhost:4200")
public class FoodDiaryController {
    private final FoodDiaryService service;

    @GetMapping
    public List<FoodDiary> getAllDiaries(Integer clientId, DaysOfWeekEnum dayOfConsumption, MealsEnum meal, Double minQuantity) {
        if (clientId != null) {
            return service.getAllDiariesByClient(clientId);
        }
        if (dayOfConsumption != null) {
            return service.getAllDiariesByDayOfConsumption(dayOfConsumption);
        }
        if (clientId != null && dayOfConsumption != null) {
            return service.getAllDiariesByClientAndDayOfConsumption(clientId, dayOfConsumption);
        }
        if (clientId != null && meal != null) {
            return service.getAllDiariesByClientAndMeal(clientId, meal);
        }
        if (minQuantity != null) {
            return service.getAllDiariesWithQuantityGreaterThan(minQuantity);
        }
        return service.getAllFoodDiaries();
    }

    @GetMapping("{id}")
    public FoodDiary getFoodDiaryById(@PathVariable Long id) {
        return service.getFoodDiaryById(id);
    }

    @PostMapping
    public FoodDiary addFoodDiary(@RequestBody FoodDiary newFoodDiary) {
        FoodDiary foodDiary = service.addNewFoodDiary(newFoodDiary);
        return foodDiary;
    }

    @DeleteMapping("{id}")
    public FoodDiary deleteById(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @PutMapping("{id}")
    public FoodDiary replaceFoodDiary(@PathVariable Long id, @RequestBody FoodDiary replaceFoodDiary) {
        return service.replaceFoodDiary(id, replaceFoodDiary);
    }
}
