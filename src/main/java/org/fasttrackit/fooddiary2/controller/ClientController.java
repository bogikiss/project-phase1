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
}