package org.fasttrackit.fooddiary2;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.fasttrackit.fooddiary2.model.*;
//import org.fasttrackit.fooddiary2.model.Food;
import org.fasttrackit.fooddiary2.repository.ClientRepository;
import org.fasttrackit.fooddiary2.repository.FoodDiaryRepository;
//import org.fasttrackit.fooddiary2.repository.FoodRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class CommandRunner implements CommandLineRunner {
    private final ClientRepository clientRepository;
    private final FoodDiaryRepository foodDiaryRepository;

    @Override
    public void run(String... args) {
        log.info("Runner is populating with data");

        Client client1 = Client.builder().fullName("Bill Moore").age(20).gender(GenderEnum.MALE).height(180.0).weight(90.0).build();
        Client client2 = Client.builder().fullName("Anne May").age(20).gender(GenderEnum.FEMALE).height(160.0).weight(50.0).build();
        Client client3 = Client.builder().fullName("George White").age(20).gender(GenderEnum.MALE).height(190.0).weight(90.0).build();

        clientRepository.saveAll(List.of(client1, client2, client3));

        foodDiaryRepository.saveAll(List.of(
                FoodDiary.builder().client(client1).food("apple").quantityInGrams(150.0).dayOfConsumption(DaysOfWeekEnum.MONDAY).meal(MealsEnum.SNACK).build(),
                FoodDiary.builder().client(client3).food("chicken breast sandwich").quantityInGrams(200.0).dayOfConsumption(DaysOfWeekEnum.MONDAY).meal(MealsEnum.LUNCH).build(),
                FoodDiary.builder().client(client3).food("milk").quantityInGrams(150.0).dayOfConsumption(DaysOfWeekEnum.TUESDAY).meal(MealsEnum.DINNER).observations("my stomach hurt afterwards").build(),
                FoodDiary.builder().client(client2).food("chicken breast sandwich").quantityInGrams(150.0).dayOfConsumption(DaysOfWeekEnum.WEDNESDAY).meal(MealsEnum.BREAKFAST).build(),
                FoodDiary.builder().client(client2).food("tomato").quantityInGrams(100.0).dayOfConsumption(DaysOfWeekEnum.WEDNESDAY).meal(MealsEnum.BREAKFAST).build(),
                FoodDiary.builder().client(client2).food("peach yougurt").quantityInGrams(125.0).dayOfConsumption(DaysOfWeekEnum.WEDNESDAY).meal(MealsEnum.SNACK).observations("my stomach hurt afterwards").build(),
                FoodDiary.builder().client(client2).food("pasta bolognese").quantityInGrams(300.0).dayOfConsumption(DaysOfWeekEnum.WEDNESDAY).meal(MealsEnum.LUNCH).build(),
                FoodDiary.builder().client(client2).food("green apple").quantityInGrams(150.0).dayOfConsumption(DaysOfWeekEnum.WEDNESDAY).meal(MealsEnum.SNACK).observations("symptoms of reflux").build(),
                FoodDiary.builder().client(client2).food("shrimp salad").quantityInGrams(200.0).dayOfConsumption(DaysOfWeekEnum.WEDNESDAY).meal(MealsEnum.DINNER).build(),
                FoodDiary.builder().client(client2).food("oatmeal made with milk").quantityInGrams(200.0).dayOfConsumption(DaysOfWeekEnum.FRIDAY).meal(MealsEnum.BREAKFAST).observations("my stomach hurt afterwards").build(),
                FoodDiary.builder().client(client2).food("banana").quantityInGrams(90.0).dayOfConsumption(DaysOfWeekEnum.FRIDAY).meal(MealsEnum.BREAKFAST).build()
        ));
    }
}
