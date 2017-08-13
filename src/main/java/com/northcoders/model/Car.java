package com.northcoders.model;

import javax.persistence.*;

@Entity
public class Car {

    private Long carId = null;
    private String carMake = null;
    private String carModel = null;
    private int engineSize = 0;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="car_id")
    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    @Column(name="car_make")
    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    @Column(name="car_model")
    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    @Column(name="engine_size")
    public int getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(int engineSize) {
        this.engineSize = engineSize;
    }
}
