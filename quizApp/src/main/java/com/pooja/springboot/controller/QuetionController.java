package com.pooja.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pooja.springboot.entity.Quetion;
import com.pooja.springboot.service.QuetionService;

@RestController
@RequestMapping(path = "/quetions")
public class QuetionController {

	@Autowired
	private QuetionService quetionService;

	@GetMapping
	protected ResponseEntity<List<Quetion>> getAllQuetions() {
		return quetionService.getAllQuetions();
	}

	@GetMapping(path = "/byId/{id}")
	protected Quetion getQuetionById(@PathVariable int id) {
		return quetionService.getQuetionById(id);
	}

	@PostMapping
	protected ResponseEntity<String> addQuetion(@RequestBody Quetion quetion) {
		return quetionService.addQuetion(quetion);
	}

	@GetMapping(path = "/{category}")
	protected ResponseEntity<List<Quetion>> getQuetionByCategory(@PathVariable String category) {
		return quetionService.getQuetionByCategory(category);
	}

	@PutMapping(path = "/update")
	protected Quetion updateQuetion(@RequestBody Quetion quetion) {
		return quetionService.updateQuetion(quetion);
	}
	
	@DeleteMapping(path="/delete/{id}")
	protected void deleteQuetionById(@PathVariable int id) {
		quetionService.deleteQuetionById(id);
	}
	
	@GetMapping(path="/byQuery")
	protected List<Quetion> getQuetionBydiffLevelAndCategory(@RequestParam String difficultyLevel,@RequestParam String category){
		return quetionService.getQuetionBydiffLevelAndCategory(difficultyLevel, category);
	}	
	
}