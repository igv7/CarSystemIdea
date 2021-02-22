package com.igor.CarSystemIdea.service;

import com.igor.CarSystemIdea.model.Client;
import com.igor.CarSystemIdea.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpServiceImpl implements SignUpService, Facade {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client signUp(Client client) throws Exception {
        System.out.println("************************StartSignUp************************");
        try {
            if (clientRepository.existsByName(client.getName())) {
                System.out.println("This client name already exist in system, please try another name.");
                throw new Exception("This client name already exist in system, please try another name.");
            } else {
                clientRepository.save(client);
                System.out.println("Success on sign up: " + client.getName() + " -> " +client);
                System.out.println("************************EndSignUp************************");
            }
        } catch (Exception e) {
            System.out.println("Failed on sign up!");
            throw new Exception("Failed on sign up! " + e.getMessage());
        }
        return client;
    }
}
