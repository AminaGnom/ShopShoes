package com.example.demo.models;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Shoes {



    public Shoes(String brand, Date releaseDate, Boolean season, Double weight, int article) {
        this.brand = brand;
        this.releaseDate = releaseDate;
        this.season = season;
        this.weight = weight;
        this.article = article;
    }
    public Shoes(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String brand;
    @DateTimeFormat(pattern = "гггг-мм-дд")
    private Date releaseDate;
    private Boolean season;
    private Double weight;
    private int article;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brandAndName) {

        this.brand = brandAndName;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Boolean getSeason() {
        return season;
    }

    public void setSeason(Boolean season) {

        this.season = season;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {

        this.weight = weight;
    }

    public int getArticle() {
        return article;
    }

    public void setArticle(int article) {

        this.article = article;
    }




}
