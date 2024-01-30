package com.bookstore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.entity.Book;
import com.bookstore.entity.MyBookList;
import com.bookstore.repository.BookRepository;
import com.bookstore.service.MyBookService;
import com.bookstore.service.ServiceBook;

@Controller
public class BookController {

	@Autowired
	private ServiceBook serviceBook;
	// private BookRepository bookRepository;

	@Autowired
	private MyBookService myBookService;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/register")
	public String register(Model m) {
		m.addAttribute("title", "resister page");
		return "register";
	}

	@GetMapping("/availeblebook")
	public String getAllBook(Model m) {
		List<Book> list = serviceBook.getAllBook();
		m.addAttribute("book", list);
		m.addAttribute("title","availeblebook");
		// return new ModelAndView("bookList", "book",list);
		return "bookList";
	}

	@GetMapping("/mybook")
	public String getBook(Model m) {
		List<MyBookList> myAllBook = myBookService.getMyAllBook();
		m.addAttribute("myBookList", myAllBook);
		return "mybook";
	}

	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		// Book save = bookRepository.save(b);
		//ServiceBook sr = new ServiceBook();
		serviceBook.save(b);
		return "redirect:/availeblebook"; // redirect to the url so we have to give url here
	}

	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		System.out.println(id);
		Book bookById = serviceBook.getBookById(id);

		MyBookList myBookList = new MyBookList(bookById.getId(), bookById.getName(), bookById.getAuthor(),
				bookById.getPrice());

		myBookService.saveMyBook(myBookList);

		return "redirect:/mybook";
	}
	@RequestMapping("deleteBookById/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		
		serviceBook.deleteBook(id);
		return "redirect:/availeblebook";
	}

}
