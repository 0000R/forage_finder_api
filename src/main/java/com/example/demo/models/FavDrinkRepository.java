package com.example.demo.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.models.FavDrink;

@Repository
@CrossOrigin(origins="http://localhost:4200")
public interface FavDrinkRepository extends JpaRepository<FavDrink, Integer>{

}


