package org.fasttrackit.fooddiary2.service;

import org.fasttrackit.fooddiary2.exceptions.ResourceNotFoundException;
import org.fasttrackit.fooddiary2.model.Client;
import org.fasttrackit.fooddiary2.model.DaysOfWeekEnum;
import org.fasttrackit.fooddiary2.model.FoodDiary;
import org.fasttrackit.fooddiary2.model.MealsEnum;
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

    public List<FoodDiary> getAllDiariesByClient(Integer clientId) {
        return repository.findByClient(clientId);
    }

    public List<FoodDiary> getAllDiariesByDayOfConsumption(DaysOfWeekEnum dayOfConsumption) {
        return repository.findByDayOfConsumption(dayOfConsumption);
    }

    public List<FoodDiary> getAllDiariesByClientAndDayOfConsumption(Integer clientId, DaysOfWeekEnum dayOfConsumption) {
        return repository.findByClientAndDayOfConsumption(clientId, dayOfConsumption);
    }

    public List<FoodDiary> getAllDiariesByClientAndMeal(Integer clientId, MealsEnum meal) {
        return repository.findByClientAndMeal(clientId, meal);
    }

    public List<FoodDiary> getAllDiariesWithQuantityGreaterThan(Double minQuantity){
        return repository.findAllByQuantityInGramsGreaterThan(minQuantity);
    }

    public FoodDiary replaceFoodDiary(Long id, FoodDiary replaceFoodDiary) {
        FoodDiary foundFoodDiary = getFoodDiaryById(id);
        FoodDiary updatedFoodDiary = FoodDiary.builder()
                .id(foundFoodDiary.getId())
                .food(replaceFoodDiary.getFood())
                .client(replaceFoodDiary.getClient())
                .dayOfConsumption(replaceFoodDiary.getDayOfConsumption())
                .meal(replaceFoodDiary.getMeal())
                .quantityInGrams(replaceFoodDiary.getQuantityInGrams())
                .observations(replaceFoodDiary.getObservations())
                .build();
        return repository.save(updatedFoodDiary);
    }
}
