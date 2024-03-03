package org.fasttrackit.fooddiary2;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.fasttrackit.fooddiary2.model.Client;
import org.fasttrackit.fooddiary2.model.Food;
import org.fasttrackit.fooddiary2.model.FoodDiary;
import org.fasttrackit.fooddiary2.repository.ClientRepository;
import org.fasttrackit.fooddiary2.repository.FoodDiaryRepository;
import org.fasttrackit.fooddiary2.repository.FoodRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class CommandRunner implements CommandLineRunner {
    private final ClientRepository clientRepository;
    private final FoodRepository foodRepository;
    private final FoodDiaryRepository foodDiaryRepository;

    @Override
    public void run(String... args) {
        log.info("Runner is populating with data");

        Client client1 = Client.builder().fullName("Bill Moore").build();
        Client client2 = Client.builder().fullName("Anne May").build();
        Client client3 = Client.builder().fullName("George White").build();
        Food food1 = Food.builder().nameOfFood("apple").build();
        Food food2 = Food.builder().nameOfFood("chicken breast sandwich").build();
        Food food3 = Food.builder().nameOfFood("milk").build();

        foodRepository.saveAll(List.of(food1, food2, food3));
        clientRepository.saveAll(List.of(client1, client2, client3));

        foodDiaryRepository.saveAll(List.of(
                FoodDiary.builder().client(client1).food(food1).quantityInGrams(150.0).build(),
                FoodDiary.builder().client(client2).food(food3).quantityInGrams(200.0).build(),
                FoodDiary.builder().client(client3).food(food3).quantityInGrams(150.0).build()
        ));
    }
}
