package com.example.springapi.api.controller;

import com.example.springapi.api.model.Car;
import com.example.springapi.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/cars")
@CrossOrigin(origins = "http://localhost:5173")  // Adjust the origin as needed
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/{name}")
    public Car getCarByName(@PathVariable String name) {
        return carService.getCarByName(name);
    }

    @PostMapping
    public void addCar(@RequestBody Car car) {
        carService.addCar(car);
    }

    @GetMapping("/wheels/{wheels}")
    public List<Car> getCarsByWheels(@PathVariable int wheels) {
        return carService.getCarsByWheels(wheels);
    }

    @GetMapping("/wheels/{wheels}/count")
    public List<Car> getCarsByWheelsWithCount(@PathVariable int wheels) {
        return carService.getCarsByWheelsWithCount(wheels);
    }

    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @DeleteMapping
    public void resetData() {
        carService.resetData();  // Clears all data from the in-memory list
    }
}