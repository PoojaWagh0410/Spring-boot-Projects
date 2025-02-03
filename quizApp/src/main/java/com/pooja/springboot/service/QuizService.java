package com.pooja.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pooja.springboot.Response.QuetionResponse;
import com.pooja.springboot.Response.ResultResponse;
import com.pooja.springboot.entity.Quetion;
import com.pooja.springboot.entity.Quiz;
import com.pooja.springboot.repository.QuetionRepository;
import com.pooja.springboot.repository.QuizRepository;

@Service
public class QuizService {

	@Autowired
	private QuizRepository quizRepository;

	@Autowired
	private QuetionRepository quetionRepository;

//	public ResponseEntity<String> createQuiz(String category, int numQue, String title) {
//		List<Quetion> quetions = quetionRepository.findRandomQuetionByCategory(category, numQue);
//		Quiz quiz = new Quiz();
//		quiz.setTitle(title);
//		quiz.setQuetion(quetions);
//		quizRepository.save(quiz);
//		return new ResponseEntity<String>("Quiz added Sucessfully", HttpStatus.CREATED);
//	}

	public ResponseEntity<List<QuetionResponse>> getQuizQuetions(int id) {
		Optional<Quiz> quiz = quizRepository.findById(id);
		List<Quetion> quetionFromDB = quiz.get().getQuetion();
		List<QuetionResponse> quetionsForUser = new ArrayList<>();
		for (Quetion q : quetionFromDB) {
			QuetionResponse response = new QuetionResponse(q.getId(), q.getQuetionTitle(), q.getOption1(),
					q.getOption2(), q.getOption3(), q.getOption4());
			quetionsForUser.add(response);
		}
		return new ResponseEntity<>(quetionsForUser, HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateResult(int id, List<ResultResponse> responses) {
		Quiz quiz = quizRepository.findById(id).get();
		List<Quetion> quetions = quiz.getQuetion();
		int result = 0;
		int i = 0;
		for (ResultResponse res : responses) {
			if (res.getResponse().equalsIgnoreCase(quetions.get(i).getRightAnswer()))
				result++;

			i++;
		}
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
	
	
}





