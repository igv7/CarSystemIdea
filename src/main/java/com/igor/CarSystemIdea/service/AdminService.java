package com.igor.CarSystemIdea.service;

import com.igor.CarSystemIdea.exceptions.CarDoesntExist;
import com.igor.CarSystemIdea.exceptions.ClientDoesntExist;
import com.igor.CarSystemIdea.model.Car;
import com.igor.CarSystemIdea.model.Client;

import java.util.List;

public interface AdminService {

    //Client Operations
    public Client createClient(Client client) throws Exception;

    public Client updateClient(Client client) throws Exception;

    public Client getClientById(int id) throws Exception;

    public List<Client> getAllClients() throws Exception;

    public Client deleteClient(int id) throws ClientDoesntExist, Exception;



    //Car Operations
    public Car createCar(Car car) throws Exception;

    public Car updateCar(Car car) throws Exception;

    public Car getCarById(int id) throws Exception;

    public Car getCarByNumber(String number) throws Exception;

    public List<Car> getAllCars() throws Exception;

    public Car deleteCar(int id) throws CarDoesntExist, Exception;
}
