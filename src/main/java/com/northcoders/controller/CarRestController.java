package com.northcoders.controller;

import com.northcoders.model.Car;
import com.northcoders.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public Car getIndividulaCar(@PathVariable Long carId) {
        Car car = carRepository.findOne(carId);

        return car;
    }
}
