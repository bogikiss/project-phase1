package org.fasttrackit.fooddiary2.service;

import org.fasttrackit.fooddiary2.model.Client;
import org.fasttrackit.fooddiary2.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public List<Client> getAllClients() {
        return repository.findAll();
    }
}
