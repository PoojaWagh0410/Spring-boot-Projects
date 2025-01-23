package com.pooja.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pooja.springboot.service.BookListService;

@Controller
public class BookListController {
	
	@Autowired
	private BookListService bookListService;
	
	@DeleteMapping("/deleteMyBook/{id}")
	public String deleteMyList(@PathVariable("id") int id) {
		bookListService.deleteById(id);
		return "redirect:/my_books";
	}
}
