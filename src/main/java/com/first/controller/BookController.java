package com.first.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.first.entity.Book;
import com.first.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	//get all books handler
	
	//@RequestMapping(value = "/books" , method = RequestMethod.GET
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks() {
		
		  List<Book> list = bookService.getAllBooks();
		  if(list.size() <= 0) {
			   
			  return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		  }
		
		 return ResponseEntity.status(HttpStatus.CREATED).body(list);	
	}
	
	//get single book handler
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
		
		 Book book = (Book) bookService.getBookById(id);
		  if(book == null) {
			   
			  return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		  }
		
		 return ResponseEntity.of(Optional.of(book));	
	}
	
	//new book handler
	
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book){
		Book b = null;
		try {
			
			b = bookService.addBook(book);
			System.out.println(book);
			return ResponseEntity.of(Optional.of(b));
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
		
		//Delete book handler
		
		@DeleteMapping("/books/{id}")
		public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId) {
			try {
				bookService.deleteBook(bookId);
				return ResponseEntity.ok().build();
				
			} 
			catch (Exception e) {
				e.printStackTrace();
				
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
				
			}
			
			
		}
			
		
		 
		
	

}
