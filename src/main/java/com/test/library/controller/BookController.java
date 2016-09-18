package com.test.library.controller;

import com.test.library.model.Book;
import com.test.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@Controller
public class BookController {
    private BookService bookService;
    private HttpServletRequest request;
    @Autowired(required = true)
    @Qualifier(value = "bookService")
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "books", method = RequestMethod.GET)
    public String listBooks(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("listBooks", this.bookService.listBooks());

        return "books";
    }

    @RequestMapping(value = "/books/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book") Book book){
        if(book.getId() == 0){
            this.bookService.addBook(book);
        }else {
            this.bookService.updateBook(book);
        }

        return "redirect:/books";
    }

    @RequestMapping("/remove/{id}")
    public String removeBook(@PathVariable("id") int id){
        this.bookService.removeBook(id);

        return "redirect:/books";
    }

    @RequestMapping("edit/{id}")
    public String editBook(@PathVariable("id") int id, Model model){
        model.addAttribute("book", this.bookService.getBookById(id));
        model.addAttribute("listBooks", this.bookService.listBooks());

        return "books";
    }

    @RequestMapping("bookdata/{id}")
    public String bookData(@PathVariable("id") int id, Model model){
        model.addAttribute("book", this.bookService.getBookById(id));

        return "bookdata";
    }

    @RequestMapping(value = "search/{bookAuthor}", method = RequestMethod.POST)
    public String searchBookByAuthor(@ModelAttribute("book") Book book, Model model){
       // bookAuthor = request.getParameter("bookAuthor");
       // model.addAttribute ("book", new Book());
        for(int i=0;i<2;i++)
            System.out.println(book +"В классе Controller");
        model.addAttribute("listBooks", this.bookService.searchBooksByAuthor(book.getBookAuthor()));

        return "search";
    }

    @RequestMapping(value = "search/{bookTitle}", method = RequestMethod.POST)
    public String searchBookByTitle(@ModelAttribute("book") Book book, Model model){
        // bookAuthor = request.getParameter("bookAuthor");
        // model.addAttribute ("book", new Book());
        for(int i=0;i<2;i++)
            System.out.println(book +"В классе Controller");
        model.addAttribute("listBooks", this.bookService.searchBooksByTitle(book.getBookTitle()));

        return "search";
    }
}
