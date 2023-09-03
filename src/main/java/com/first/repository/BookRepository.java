package com.first.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.first.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
 
	public Book findById(int id);
}
