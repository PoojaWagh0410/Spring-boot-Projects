package com.pooja.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pooja.springboot.entity.Book;
import com.pooja.springboot.entity.BookList;
import com.pooja.springboot.service.BookListService;
import com.pooja.springboot.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private BookListService bookListService;

	@GetMapping(path = "/home")
	public String home() {
		return "home_page";
	}

	@GetMapping(path = "/book_register")
	public String bookRegister() {
		return "register_book";
	}

	@GetMapping(path = "/user_available_book")
	public String userAvailableBook() {
		return "user_available_book";
	}

	@GetMapping(path = "/user_my_book")
	public String userMyBook() {
		return "user_myBook";
	}

	@GetMapping(path = "/available_books")
	public ModelAndView getAllBook() {
		List<Book> list = bookService.getAllBook();
//		ModelAndView m=new ModelAndView();
//		m.setViewName("bookList");
//		m.addObject("book",list);
		return new ModelAndView("available_book", "book", list);
	}

	@PostMapping(path = "/save")
	public String addBook(@ModelAttribute Book b, ModelMap modelMap) {
		boolean bookSaved = bookService.save(b);
		if (bookSaved) {
			modelMap.addAttribute("message", "Book added sucessfully");
			return "redirect:/available_books";
		} else {
			return "redirect:/book_register";
		}
	}

	@GetMapping(path = "/my_books")
	public String getMyBooks(Model model) {
		List<BookList> list = bookListService.getAllMyBooks();
		model.addAttribute("book", list);
		return "my_books";
	}

	@RequestMapping(path = "/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b = bookService.getBookById(id);
		BookList mb = new BookList(b.getId(), b.getName(), b.getAuthor(), b.getPrice());
		bookListService.saveMyBooks(mb);
		return "redirect:/my_books";
	}

	@RequestMapping(path = "/editBook/{id}")
	public String editBook(@PathVariable("id") int id, Model model) {
		Book b = bookService.getBookById(id);
		model.addAttribute("book", b);
		return "bookEdit";
	}

	@RequestMapping(path = "/deleteBook/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		bookService.deleteById(id);
		return "redirect:/available_books";
	}

}