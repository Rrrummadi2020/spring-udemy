package com.example.firstproject.repository;

import com.example.firstproject.entity.Alien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController(path = "tycoons")
public interface AlienRepository extends JpaRepository<Alien, Integer> {
}
