package org.fasttrackit.fooddiary2.repository;

import org.fasttrackit.fooddiary2.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
