package org.fasttrackit.fooddiary2.controller;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.fooddiary2.model.Client;
import org.fasttrackit.fooddiary2.model.FoodDiary;
import org.fasttrackit.fooddiary2.model.GenderEnum;
import org.fasttrackit.fooddiary2.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
@RequiredArgsConstructor
@CrossOrigin(value = "http://localhost:4200")
public class ClientController {
    private final ClientService service;

    @GetMapping
    public List<Client> getAllClients(GenderEnum gender, Integer minAge) {
        if (gender != null) {
            return service.getAllClientsByGender(gender);
        }
        if (minAge != null) {
            return service.getAllClientsOlderThan(minAge);
        }
        return service.getAllClients();
    }

    @GetMapping("{id}")
    public Client getClientById(@PathVariable Long id) {
        return service.getClientById(id);
    }

    @PostMapping
    public Client addClient(@RequestBody Client newClient) {
        return service.addNewClient(newClient);
    }

    @DeleteMapping("{id}")
    public Client deleteById(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @PutMapping("{id}")
    public Client replaceClient(@PathVariable Long id, @RequestBody Client replaceClient) {
        return service.replaceClient(id, replaceClient);
    }
}