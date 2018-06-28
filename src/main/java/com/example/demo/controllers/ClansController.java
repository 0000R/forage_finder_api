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

import com.example.demo.models.Clans;
import com.example.demo.models.ClansRepository;

@RestController
@RequestMapping("/clans")

@CrossOrigin(origins = "http://localhost:4200")
public class ClansController {
	
	@Autowired
	ClansRepository clansRepository;
	
	
	@GetMapping()
	public List<Clans> getClans(){
		return clansRepository.findAll();
	}
	
	@PostMapping()
	public void createClans(@RequestBody Clans clans) {
		clansRepository.save(clans);
	}
	
	@PostMapping("/multiple")
	public void createClans(@RequestBody List<Clans> clans) {
		clansRepository.saveAll(clans);
	}
	
	@DeleteMapping("/{id}")
	public void deletClans(@PathVariable("id") int id)	{
		Clans clansDelete = clansRepository.findById(id).orElse(null);
		clansRepository.delete(clansDelete);
	}

}


