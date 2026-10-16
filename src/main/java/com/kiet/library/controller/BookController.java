package com.kiet.library.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiet.library.model.Book;
import com.kiet.library.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PutMapping("/{id}")
    public boolean updateBook(
            @PathVariable int id,
            @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public boolean deleteBook(@PathVariable int id) {
        return bookService.deleteBook(id);
    }

    @GetMapping("/category/{category}")
    public List<Book> searchByCategory(
            @PathVariable String category) {
        return bookService.searchByCategory(category);
    }

    @GetMapping("/year/{year}")
    public List<Book> findPublishedFromYear(
            @PathVariable int year) {
        return bookService.findPublishedFromYear(year);
    }
}