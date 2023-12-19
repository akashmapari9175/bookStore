package com.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.bookstore.entity.Book;
import com.bookstore.repository.BookRepository;

@Service
public class ServiceBook {

	@Autowired
	private BookRepository repo;
	

	public void save(Book b) {
	  repo.save(b);
	}
	public List<Book> getAllBook(){
		List<Book> list = repo.findAll();
		return list;
	}
	public Book getBookById(int id) {
		Book book = repo.findById(id).get();  //this get method is change the optional to the book object
		return book;
	}
	
}
