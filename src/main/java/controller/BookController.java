package controller;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;
import model.Book;
import service.BookService;

import java.util.List;

@Controller("/book")
public class BookController {

    @Inject
    BookService bookService;

    @Get()
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @Post()
    public Book create(@Body Book book) {
        return bookService.create(book);
    }

}