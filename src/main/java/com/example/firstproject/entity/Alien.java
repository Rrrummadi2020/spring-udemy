package com.example.firstproject.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "alien")
public class Alien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    public Alien(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public Alien() {
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alien alien = (Alien) o;
        return Objects.equals(id, alien.id) && Objects.equals(name, alien.name) && Objects.equals(email, alien.email) && Objects.equals(address, alien.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, address);
    }
}
