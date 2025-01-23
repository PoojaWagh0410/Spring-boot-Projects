package com.pooja.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pooja.springboot.entity.Book;
import com.pooja.springboot.entity.User;
import com.pooja.springboot.service.BookListService;
import com.pooja.springboot.service.BookService;
import com.pooja.springboot.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private BookService bookService;

	@Autowired
	private BookListService bookListService;

	@GetMapping(path = "/signup")
	protected String getSignUpPage() {
		return "user_signup";
	}

	@PostMapping(path = "/addUser")
	protected String addUser(User user) {
		userService.addUser(user);
		return "user_login";
	}

	@GetMapping(path = "/")
	protected String getLoginPage() {
		return "user_login";
	}

	@RequestMapping(path = "/authUser")
	protected String authUser(@RequestParam String email, @RequestParam String password) {
		User authUser = userService.authUser(email, password);
		if (authUser != null) {
			if (authUser.getRole().equals("Admin")) {
				return "home_page";
			}
		}
		return "user_home";
	}

	@GetMapping(path = "/user_available_books")
	public ModelAndView allBooks() {
		List<Book> list = userService.allBooks();
//		ModelAndView m=new ModelAndView();
//		m.setViewName("bookList");
//		m.addObject("book",list);
		return new ModelAndView("user_available_book", "book", list);
	}

	@RequestMapping(path = "/all_users")
	public String findAllUsers(Model model) {
		List<User> users = userService.findAllUsers();
		model.addAttribute("users", users);
		return "all_users";
	}

	@GetMapping(path = "/user_home")
	protected String getUserHomePage() {
		return "user_home";
	}

	@GetMapping(path = "/logout")
	protected String userLogout() {
		return "user_login";
	}

//	@RequestMapping(path = "/user_my_list/{id}")
//	public String getMyList(@PathVariable("id") int id, @PathVariable int userId) {
//		Optional<User> user = userService.findUserById(userId);
//		if (user != null) {
//			Book books = bookService.getBookById(id);
//			BookList mb = new BookList(books.getId(), books.getName(), books.getAuthor(), books.getPrice());
//			bookListService.saveMyBooks(mb);
//			return "redirect:/user_my_books";
//		} else
//			return "redirect:/user_available_book";
//	}
	
	

}
