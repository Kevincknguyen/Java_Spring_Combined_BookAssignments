package com.coding.books.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.coding.books.models.Book;
import com.coding.books.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;
	
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository=bookRepository;
	}

	
//	READ ALL
 
	 public List<Book> allBooks() {
	     return bookRepository.findAll();
	 }
	 
//	 CREATE BOOK
	 public Book createBook(Book b) {
		 return bookRepository.save(b);
	 }
	 
//	 READ ONE
	 public Book findBook(Long id) {
	     Optional<Book> optionalBook = bookRepository.findById(id);
	     if(optionalBook.isPresent()) {
	         return optionalBook.get();
	     } else {
	         return null;
	     }
	 	}
//	DELETE ONE
	 public String deleteBook(Long id) {
	     Optional<Book> optionalBook = bookRepository.findById(id);
	     if(optionalBook.isPresent()) {
	         bookRepository.deleteById(id);
	         return "Completed delete";
	         
	     } 
	     else {
	    	 return "No book with ID found";
	     }
	 	}
	 
//	UPDATE ONE
	 
	 public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
	     Optional<Book> optionalBook = bookRepository.findById(id);
	     if(optionalBook.isPresent()) {
	    	 Book book=optionalBook.get();
	    	 book.setTitle(title);
	    	 book.setDescription(desc);
	    	 book.setLanguage(lang);
	    	 book.setNumberOfPages(numOfPages);
	    	 
	    
	    	 
	    	
	         bookRepository.save(book);
	         return book;
	         
	     } 
	     else {
	    	 return null;
	     }
	 	}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
 }


