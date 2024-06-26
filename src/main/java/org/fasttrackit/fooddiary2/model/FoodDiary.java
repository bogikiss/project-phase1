package org.fasttrackit.fooddiary2.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.DayOfWeek;
import java.util.Date;

@With
@Builder(toBuilder = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FoodDiary {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String food;

    @ManyToOne
    @JoinColumn(name="clientId")
    private Client client;

    @Column
    private DaysOfWeekEnum dayOfConsumption;

    @Column
    private MealsEnum meal;

    @Column
    private Double quantityInGrams;

    @Column
    private String observations;
}
