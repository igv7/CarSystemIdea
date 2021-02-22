package com.igor.CarSystemIdea.service;

import com.igor.CarSystemIdea.enums.ClientType;
import com.igor.CarSystemIdea.model.Client;
import com.igor.CarSystemIdea.repo.ClientRepository;
import com.igor.CarSystemIdea.task.SessionTimeout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class CarSystem {

    //	@Autowired
    // 	private ConfigurableApplicationContext context;

    @Autowired
    private ApplicationContext context;

    @Autowired
    private AdminServiceImpl adminServiceImpl;

    @Autowired
    private SessionTimeout sessionTask;

    @Autowired
    private ClientRepository clientRepository;



    @PostConstruct
    public void init() {
        System.out.println("Welcome to the Car System Idea!");
        System.out.println("Session Timeout Task in ACTION...");
        sessionTask.start();
    }

    @PreDestroy
    public void destroy() {
        System.out.println("The Car System is shut down.");
        sessionTask.stop();
//		context.close();
    }

    public Facade login(String userName, String password, ClientType type) throws Exception {
        switch (type) {
            case ADMIN:
                if (userName.equals("admin") && password.equals("1234")) {
                    System.out.println("Welcome Admin! You're logged into The Car System");
                    return adminServiceImpl;
                }
            case CLIENT:
                Client client = clientRepository.findByNameAndPassword(userName, password);
                if (client != null) {
                    ClientServiceImpl clientServiceImpl = context.getBean(ClientServiceImpl .class);
                    clientServiceImpl.setClientId(client.getId());
                    System.out.println("Welcome " +client.getName()+ "! You're logged into The Car System");
                    return clientServiceImpl;
                }

        }
        throw new Exception("Client not found. Check your data");
    }
}
