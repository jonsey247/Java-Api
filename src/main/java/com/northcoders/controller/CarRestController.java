package com.northcoders.controller;

import com.northcoders.model.Car;
import com.northcoders.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarRestController {

    @Autowired
    protected CarRepository carRepository;

    @RequestMapping(value="/cars", method = RequestMethod.GET)
    public List<Car> getAllCars() {
        return (List<Car>)carRepository.findAll();
    }

    @RequestMapping(value="/cars/{carId}", method = RequestMethod.GET)
    public Car getIndividualCar(@PathVariable Long carId) {
        Car car = carRepository.findOne(carId);

        return car;
    }

    @RequestMapping(value="/cars/{carId}", method = RequestMethod.POST)
    public void saveCar(@RequestBody Car car) {
        carRepository.save(car);
    }
}
