package com.pooja.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pooja.springboot.entity.Quetion;
import com.pooja.springboot.repository.QuetionRepository;

@Service
public class QuetionService {

	@Autowired
	private QuetionRepository quetionRepository;

	public ResponseEntity<List<Quetion>> getAllQuetions() {
		try {
			return new ResponseEntity<>(quetionRepository.findAll(), HttpStatus.FOUND);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> addQuetion(Quetion quetion) {
		try {
			quetionRepository.save(quetion);
			return new ResponseEntity<>("Quetion Added Sucessfully", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<List<Quetion>> getQuetionByCategory(String category) {
		try {
			return new ResponseEntity<>(quetionRepository.findByCategory(category), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
	}

	public Quetion updateQuetion(Quetion quetion) {
		return quetionRepository.save(quetion);
	}

	public Quetion getQuetionById(int id) {
		Optional<Quetion> quetion = quetionRepository.findById(id);
		return quetion.get();
	}

	public void deleteQuetionById(int id) {
		quetionRepository.deleteById(id);
	}

	public List<Quetion> getQuetionBydiffLevelAndCategory(String difficultyLevel, String category) {
		return quetionRepository.findByDifficultyLevelAndCategory(difficultyLevel, category);
	}

}
