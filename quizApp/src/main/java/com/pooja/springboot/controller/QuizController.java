package com.pooja.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pooja.springboot.Response.QuetionResponse;
import com.pooja.springboot.Response.ResultResponse;
import com.pooja.springboot.service.QuizService;

@RestController
@RequestMapping(path = "/quiz")
public class QuizController {

	@Autowired
	private QuizService quizService;

//	@PostMapping(path = "/create")
//	protected ResponseEntity<String> CreateQuiz(@RequestParam String category, @RequestParam int numQue,
//			@RequestParam String title) {
//		return quizService.createQuiz(category, numQue, title);
//	}

	@GetMapping(path = "/{id}")
	protected ResponseEntity<List<QuetionResponse>> getQuizById(@PathVariable int id) {
		return quizService.getQuizQuetions(id);
	}

	@PostMapping(path="/submit/{id}")
	protected ResponseEntity<Integer> submitQuizResult(@PathVariable int id,
			@RequestBody List<ResultResponse> response) {
		return quizService.calculateResult(id, response);
	}

}
