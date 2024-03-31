package org.fasttrackit.fooddiary2.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.fasttrackit.fooddiary2.exceptions.ResourceNotFoundException;
import org.fasttrackit.fooddiary2.model.Client;
import org.fasttrackit.fooddiary2.model.DaysOfWeekEnum;
import org.fasttrackit.fooddiary2.model.FoodDiary;
import org.fasttrackit.fooddiary2.model.GenderEnum;
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

    public Client getClientById(Long id) {
        Client client = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client with id:%s was not found".formatted(id)));
        return client;
    }

    public Client addNewClient(Client newClient) {
        return repository.save(newClient);
    }

    public Client deleteById(Long id) {
        Client clientToBeDeleted = getClientById(id);
        repository.deleteById(id);
        return clientToBeDeleted;
    }

    public Client replaceClient(Long id, Client replaceClient) {
        Client foundClient = getClientById(id);
        Client updatedClient = Client.builder()
                .clientId(foundClient.getClientId())
                .fullName(replaceClient.getFullName())
                .age(replaceClient.getAge())
                .gender(replaceClient.getGender())
                .height(replaceClient.getHeight())
                .weight(replaceClient.getWeight())
                .build();
        return repository.save(updatedClient);
    }

    public List<Client> getAllClientsByGender(GenderEnum gender) {
        return repository.findByGender(gender);
    }

    public List<Client> getAllClientsOlderThan(Integer age){
        return repository.findAllByAgeGreaterThan(age);
    }
}
