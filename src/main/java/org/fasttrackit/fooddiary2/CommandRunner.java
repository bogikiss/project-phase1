package org.fasttrackit.fooddiary2;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.fasttrackit.fooddiary2.model.Client;
//import org.fasttrackit.fooddiary2.model.Food;
import org.fasttrackit.fooddiary2.model.FoodDiary;
import org.fasttrackit.fooddiary2.model.GenderEnum;
import org.fasttrackit.fooddiary2.model.MealsEnum;
import org.fasttrackit.fooddiary2.repository.ClientRepository;
import org.fasttrackit.fooddiary2.repository.FoodDiaryRepository;
//import org.fasttrackit.fooddiary2.repository.FoodRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class CommandRunner implements CommandLineRunner {
    private final ClientRepository clientRepository;
    //private final FoodRepository foodRepository;
    private final FoodDiaryRepository foodDiaryRepository;

    @Override
    public void run(String... args) {
        log.info("Runner is populating with data");

        Client client1 = Client.builder().fullName("Bill Moore")/*.age(20).gender(GenderEnum.MALE).height(180.0).weight(90.0)*/.build();
        Client client2 = Client.builder().fullName("Anne May")/*.age(20).gender(GenderEnum.FEMALE).height(160.0).weight(50.0)*/.build();
        Client client3 = Client.builder().fullName("George White")/*.age(20).gender(GenderEnum.MALE).height(190.0).weight(90.0)*/.build();
       /* Food food1 = Food.builder().nameOfFood("apple").build();
        Food food2 = Food.builder().nameOfFood("chicken breast sandwich").build();
        Food food3 = Food.builder().nameOfFood("milk").build();

        foodRepository.saveAll(List.of(food1, food2, food3));*/
        clientRepository.saveAll(List.of(client1, client2, client3));

        foodDiaryRepository.saveAll(List.of(
                FoodDiary.builder().client(client1).food("apple").quantityInGrams(150.0).dayOfConsumption(new Date(05-03-2024)).meal(MealsEnum.SNACK).build(),
                FoodDiary.builder().client(client2).food("chicken breast sandwich").quantityInGrams(200.0).dayOfConsumption(new Date(01-03-2024)).meal(MealsEnum.LUNCH).build(),
                FoodDiary.builder().client(client2).food("milk").quantityInGrams(150.0).dayOfConsumption(new Date(01-03-2024)).meal(MealsEnum.DINNER).observations("my stomach hurt afterwards").build()
        ));
    }
}
