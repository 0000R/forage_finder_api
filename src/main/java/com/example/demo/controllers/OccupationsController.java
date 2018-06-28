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

import com.example.demo.models.Occupations;
import com.example.demo.models.OccupationsRepository;


@RestController
@RequestMapping("/occupations")

@CrossOrigin(origins = "http://localhost:4200")
public class OccupationsController {
	
	@Autowired
	OccupationsRepository occupationsRepository;
	
	
	@GetMapping()
	public List<Occupations> getOccupations(){
		return occupationsRepository.findAll();
	}
	
	@PostMapping()
	public void createOccupations(@RequestBody Occupations occupations) {
		occupationsRepository.save(occupations);
	}
	
	@PostMapping("/multiple")
	public void createOccupations(@RequestBody List<Occupations> occupations) {
		occupationsRepository.saveAll(occupations);
	}
	
	@DeleteMapping("/{id}")
	public void deleteOccupations(@PathVariable("id") int id)	{
		Occupations occupationsDelete = occupationsRepository.findById(id).orElse(null);
		occupationsRepository.delete(occupationsDelete);
	}

}
