package com.coding.books.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//..
import com.coding.books.models.Book;
import com.coding.books.services.BookService;
@RestController
public class BooksApi {
//	CONSTRUCTOR AND DEPENDENCY INJECTION
	 private final BookService bookService;
	 public BooksApi(BookService bookService){
	     this.bookService = bookService;
	 }
	 
//	 READ ALL
	 @RequestMapping("/api/books")
	 public List<Book> index() {
	     return bookService.allBooks();
	 }
//	 CREATE
	 @RequestMapping(value="/api/books", method=RequestMethod.POST)
	 public Book create(
			 @RequestParam(value="title") String title, 
			 @RequestParam(value="description") String desc, 
			 @RequestParam(value="language") String lang, 
			 @RequestParam(value="pages") Integer numOfPages) {
	     Book book = new Book(title, desc, lang, numOfPages);
	     return bookService.createBook(book);
	 }
	 
//	 UPDATE
	 @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
	 public Book update(
			 @PathVariable("id") Long id,
			 @RequestParam(value="title") String title, 
			 @RequestParam(value="description") String desc, 
			 @RequestParam(value="language") String lang, 
			 @RequestParam(value="pages") Integer numOfPages) {
	     Book book = bookService.updateBook(id,title,desc,lang,numOfPages);
	     return book;
	 }
//	 READ ONE
	 @RequestMapping("/api/books/{id}")
	 public Book show(@PathVariable("id") Long id) {
	     Book book = bookService.findBook(id);
	     return book;
	 } 
	 
	 
//	 DELETE
	 @RequestMapping(value="/api/books/{id}",method=RequestMethod.DELETE)
	 public String delete(@PathVariable("id")Long id) {
		 String response=bookService.deleteBook(id);
		 return response;
	 }
}
