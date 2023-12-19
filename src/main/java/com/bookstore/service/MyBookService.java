package com.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.entity.Book;
import com.bookstore.entity.MyBookList;
import com.bookstore.repository.MyBookRepository;

@Service
public class MyBookService {

	@Autowired
	private MyBookRepository myBookrepo;
	
	public void saveMyBook(MyBookList b) {
		myBookrepo.save(b);
	}
	public List<MyBookList> getMyAllBook(){
		List<MyBookList> findAll = myBookrepo.findAll();
		return findAll;
	}
	public void deleteByIdBook(int id) {
		myBookrepo.deleteById(id);
	}
	
}
