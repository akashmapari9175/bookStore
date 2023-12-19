package com.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bookstore.service.MyBookService;

@Controller
public class MyBookController {
	
	@Autowired
	private MyBookService bookService;

	@GetMapping("deleteByid/{id}")
	public String deleteById(@PathVariable("id") int id) {
		bookService.deleteByIdBook(id);
		return "redirect:/mybook";
	}
}
