package org.fasttrackit.fooddiary2.repository;

import org.fasttrackit.fooddiary2.model.Client;
import org.fasttrackit.fooddiary2.model.DaysOfWeekEnum;
import org.fasttrackit.fooddiary2.model.FoodDiary;
import org.fasttrackit.fooddiary2.model.GenderEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findByGender(GenderEnum gender);
    List<Client> findAllByAgeGreaterThan(Integer age);
}
