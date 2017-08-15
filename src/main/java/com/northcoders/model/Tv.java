package com.northcoders.model;

import javax.persistence.*;

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
    public String getTvModel() {
        return tvModel;
    }

    public void setTvModel(String tvModel) {
        this.tvModel = tvModel;
    }

    @Column(name="wattage")
    public int getWattage() {
        return wattage;
    }

    public void setWattage(int wattage) {
        this.wattage = wattage;
    }
}
