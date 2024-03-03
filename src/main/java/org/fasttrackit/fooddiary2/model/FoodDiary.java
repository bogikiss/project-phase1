package org.fasttrackit.fooddiary2.model;

import jakarta.persistence.*;
import lombok.*;

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

    @ManyToOne
    @JoinColumn(name="foodId")
    private Food food;

    @ManyToOne
    @JoinColumn(name="clientId")
    private Client client;

    @Column
    private Double quantityInGrams;
}
