package com.example.firstproject.entity;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "engineer")
public class Engineer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "position")
    private String position;

    @Column(name = "start_date")
    private Date startDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Engineer(){}

    public Engineer(Integer id, String name, String position, Date startDate) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "Engineer [id=" + id + ", name=" + name + ", position=" + position + ", startDate=" + startDate + "]";
    }

    
}
