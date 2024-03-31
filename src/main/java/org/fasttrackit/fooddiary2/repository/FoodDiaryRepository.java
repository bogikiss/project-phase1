package org.fasttrackit.fooddiary2.repository;

import org.fasttrackit.fooddiary2.model.Client;
import org.fasttrackit.fooddiary2.model.DaysOfWeekEnum;
import org.fasttrackit.fooddiary2.model.FoodDiary;
import org.fasttrackit.fooddiary2.model.MealsEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodDiaryRepository extends JpaRepository<FoodDiary, Long> {
    List<FoodDiary> findByDayOfConsumption(DaysOfWeekEnum dayOfConsumption);
    List<FoodDiary> findAllByQuantityInGramsGreaterThan(Double minQuantity);
    @Query(value = "SELECT * FROM FOOD_DIARY WHERE client_id=:clientId", nativeQuery = true)
    List<FoodDiary> findByClient(@Param("clientId") Integer clientId);

    @Query(value = "SELECT * FROM FOOD_DIARY WHERE client_id=:clientId AND day_of_consumption=:dayOfConsumption", nativeQuery = true)
    List<FoodDiary> findByClientAndDayOfConsumption(@Param("clientId") Integer clientId, @Param("dayOfConsumption") DaysOfWeekEnum dayOfConsumption);

    @Query(value = "SELECT * FROM FOOD_DIARY WHERE client_id=:clientId AND meal=:meal", nativeQuery = true)
    List<FoodDiary> findByClientAndMeal(@Param("clientId") Integer clientId, @Param("meal") MealsEnum meal);
}
