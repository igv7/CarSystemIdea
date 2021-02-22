package com.igor.CarSystemIdea.service;

import com.igor.CarSystemIdea.enums.CarType;
import com.igor.CarSystemIdea.model.Car;

import java.util.List;

public interface CarService {

    public List<Car> getAllCars() throws Exception;

    public List<Car> getAllCarsByType(CarType type) throws Exception;
}
