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

import com.example.demo.models.Dwarf;
import com.example.demo.models.DwarfRepository;

@RestController
@RequestMapping("/dwarf")

@CrossOrigin(origins = "http://localhost:4200")
public class DwarfController {
	
	@Autowired
	DwarfRepository dwarfRepository;
	
	@GetMapping()
	public List<Dwarf> getDwarves(){
		return dwarfRepository.findAll();
	}

	@PostMapping()
	public void createDwarf(@RequestBody Dwarf dwarf) {
		dwarfRepository.save(dwarf);
	}
	
	@DeleteMapping("/{id}")
	public void deleteDwarf(@PathVariable("id") int id)	{
		Dwarf dwarfDelete = dwarfRepository.findById(id).orElse(null);
		dwarfRepository.delete(dwarfDelete);
	}
}
