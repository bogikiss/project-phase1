package org.fasttrackit.fooddiary2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@With
@Entity
@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue
    private Long clientId;
    @Column
    private String fullName;
   /* @Column
    private Integer age;
    @Column
    private GenderEnum gender;
    @Column
    private Double height;
    @Column
    private Double weight;*/

    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<FoodDiary> diaries;
}
