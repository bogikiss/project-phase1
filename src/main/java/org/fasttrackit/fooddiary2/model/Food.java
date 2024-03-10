package org.fasttrackit.fooddiary2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/*@With
@Builder(toBuilder = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Food {
    @Id
    @GeneratedValue
    private Long foodId;
    @Column
    private String nameOfFood;

    @OneToMany(mappedBy = "food")
    @JsonIgnore
    private List<FoodDiary> diaries;
}*/

