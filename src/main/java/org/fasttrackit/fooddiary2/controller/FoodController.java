package org.fasttrackit.fooddiary2.controller;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.fooddiary2.model.Food;
import org.fasttrackit.fooddiary2.service.FoodService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("foods")
@RequiredArgsConstructor
public class FoodController {
    private final FoodService service;

    @GetMapping
    public List<Food> getAllFoods() {
        return service.getAllFoods();
    }
}
