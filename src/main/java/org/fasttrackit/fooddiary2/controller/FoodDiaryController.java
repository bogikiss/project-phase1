package org.fasttrackit.fooddiary2.controller;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.fooddiary2.model.Client;
import org.fasttrackit.fooddiary2.model.FoodDiary;
import org.fasttrackit.fooddiary2.service.FoodDiaryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food-diaries")
@RequiredArgsConstructor
@CrossOrigin(value= "http://localhost:4200")
public class FoodDiaryController {
    private final FoodDiaryService service;

    @GetMapping
    public List<FoodDiary> getAllDiaries() {
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
}
