package com.first.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.first.entity.Book;
import com.first.repository.BookRepository;

public class BookService {
	@Autowired
	private BookRepository bookRepository;
	
	
	public List<Book> getAllBooks(){
		
	List<Book> list = bookRepository.findAll();
		
		return list;
	}
	
	public List<Book> getBookById(int id){
		
		Book book = null;
	try {
		
		book = bookRepository.findById(id);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
		
		return (List<Book>) book;
	}
	
	public Book addBook(Book b) {
		
		Book result = bookRepository.save(b);
		
		return result;
		
	}
	
	public void deleteBook(int bid) {
		
		bookRepository.deleteById(bid);
		
	}
	
	public void updateBook(Book book , int bookId) {
		
		book.setId(bookId);
		
		bookRepository.save(book);
		
	}
	

}
