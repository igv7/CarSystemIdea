package com.igor.CarSystemIdea.service;

import com.igor.CarSystemIdea.model.Car;

import java.util.List;

public interface ClientService {

    public void setClientId(int id);

    public Car getCar(int id) throws Exception;

    public List<Car> getCars() throws Exception;

    public Car returnCar(int id) throws Exception;
}
