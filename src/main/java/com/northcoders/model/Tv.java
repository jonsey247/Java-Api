package com.northcoders.model;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
public class Tv {

    private Long tvId = null;
    private String tvModel = null;
    private int wattage = 0;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="tv_Id")
    public Long getTvId() {
        return tvId;
    }

    public void setTvId(Long tvId) {
        this.tvId = tvId;
    }

    @Column(name="tv_Model")
    @NotEmpty(message = "Please enter a model name.")
    public String getTvModel() {
        return tvModel;
    }

    public void setTvModel(String tvModel) {
        this.tvModel = tvModel;
    }

    @Column(name="wattage")
    @Min(value = 100, message = "The wattage should be at least 100")
    public int getWattage() {
        return wattage;
    }

    public void setWattage(int wattage) {
        this.wattage = wattage;
    }
}
