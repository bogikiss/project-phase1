package org.fasttrackit.fooddiary2.repository;

import org.fasttrackit.fooddiary2.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
}
