package com.example.demo.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Staff {


    public Staff(String fio, java.sql.Date birth, Boolean work, Double wages, int bank) {
        this.fio = fio;
        this.birth = birth;
        this.work = work;
        this.wages = wages;
        this.bank = bank;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fio;
    @DateTimeFormat(pattern = "гггг-мм-дд")
    private java.sql.Date birth;
    private Boolean work;
    private Double wages;
    private int bank;

    public Staff() {

    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {

        this.id = id;
    }

    public String getFio() {
        return fio;
    }
    public void setFio (String fio) {
        this.fio = fio;
    }

    public Date getBirth() {
        return birth;
    }
    public void setBirth(java.sql.Date birth) {

        this.birth = birth;
    }

    public Boolean getWork() {
        return work;
    }
    public void setWork (Boolean work) {

        this.work = work;
    }

    public double getWages () {
        return wages;
    }
    public void setWages (Double wages) {

        this.wages = wages;
    }

    public int getBank() {return bank;}
    public void setBank (int bank){

        this.bank=bank;
    }

}
