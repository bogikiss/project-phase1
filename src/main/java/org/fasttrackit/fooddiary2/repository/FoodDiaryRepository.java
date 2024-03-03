package org.fasttrackit.fooddiary2.repository;

import org.fasttrackit.fooddiary2.model.FoodDiary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodDiaryRepository extends JpaRepository<FoodDiary, Long> {

}
