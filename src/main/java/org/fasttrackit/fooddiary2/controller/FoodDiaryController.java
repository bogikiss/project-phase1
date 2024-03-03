package org.fasttrackit.fooddiary2.controller;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.fooddiary2.model.FoodDiary;
import org.fasttrackit.fooddiary2.service.FoodDiaryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("fooddiaries")
@RequiredArgsConstructor
public class FoodDiaryController {
    private final FoodDiaryService service;

    @GetMapping
    public List<FoodDiary> getAllDiaries() {
        return service.getAllFoodDiaries();
    }
}
