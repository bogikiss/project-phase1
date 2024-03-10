package org.fasttrackit.fooddiary2.controller;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.fooddiary2.model.Client;
import org.fasttrackit.fooddiary2.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService service;

    @GetMapping
    public List<Client> getAllClients() {
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
}