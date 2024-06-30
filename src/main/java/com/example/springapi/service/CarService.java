package com.example.springapi.service;

import com.example.springapi.api.model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class CarService {
    private List<Car> cars = new ArrayList<>();

    public Car getCarByName(String name) {
        return cars.stream()
                .filter(car -> car.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getCarsByWheels(int wheels) {
        return cars.stream()
                .filter(car -> car.getWheels() == wheels)
                .distinct()  // Ensure unique car names
                .collect(Collectors.toList());
    }

    public List<Car> getAllCars() {
        return new ArrayList<>(cars);
    }

    public void resetData() {
        cars.clear();  // Clears all data from the in-memory list
    }

    public List<Car> getCarsByWheelsWithCount(int wheels) {
        return cars.stream()
                .filter(car -> car.getWheels() == wheels)
                .distinct()  // Ensure unique car names
                .collect(Collectors.toList());
    }
}