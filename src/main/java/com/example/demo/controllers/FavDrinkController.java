package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.FavDrink;
import com.example.demo.models.FavDrinkRepository;



@RestController
@RequestMapping("/favdrink")

@CrossOrigin(origins = "http://localhost:4200")
public class FavDrinkController {
	
	@Autowired
	FavDrinkRepository favDrinkRepository;
	
	
	@GetMapping()
	public List<FavDrink> getFavDrink(){
		return favDrinkRepository.findAll();
	}
	
	@PostMapping()
	public void createFavDrink(@RequestBody FavDrink favDrink) {
		favDrinkRepository.save(favDrink);
	}
	
	@PostMapping("/multiple")
	public void createFavDrink(@RequestBody List<FavDrink> favDrink) {
		favDrinkRepository.saveAll(favDrink);
	}
	
	@DeleteMapping("/{id}")
	public void deletFavDrink(@PathVariable("id") int id)	{
		FavDrink favDrinkDelete = favDrinkRepository.findById(id).orElse(null);
		favDrinkRepository.delete(favDrinkDelete);
	}

}

