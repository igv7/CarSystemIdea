package com.igor.CarSystemIdea.repo;

import com.igor.CarSystemIdea.model.ClientReceipt;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientReceiptRepository extends MongoRepository<ClientReceipt, Long> {

    public boolean existsByClientName(String clientName);

    public ClientReceipt findByClientId(int clientId);

    public List<ClientReceipt> findAllByClientId(int clientId);
}
