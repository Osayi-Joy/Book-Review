package com.osayijoy.bookreview.controllers;

import com.osayijoy.bookreview.service.BookService;
import com.osayijoy.bookreview.util.ApiResponseUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import com.osayijoy.bookreview.DTO.request.BookDTO;
import com.osayijoy.bookreview.DTO.response.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;


@RestController
@AllArgsConstructor
@RequestMapping(value="/api/book-review")
public class BookController {
    private BookService bookService;


    @PostMapping("/books")
    public ResponseEntity<BaseResponse<BookDTO>> saveBook(@Valid @RequestBody BookDTO book) {
        return ApiResponseUtil.response(CREATED, bookService.saveBook(book), "Successfully Saved");
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<BaseResponse<BookDTO>> updateBook(@PathVariable String id, @RequestBody BookDTO book) {
        return ApiResponseUtil.response(OK, bookService.updateBook(id, book), "Successfully Updated");
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<BaseResponse<BookDTO>> getBookById(@PathVariable String id){
        return ApiResponseUtil.response(OK, bookService.getBookById(id), "Successfully Retrieved");
    }

    @GetMapping("/books/{title}")
    public ResponseEntity<BaseResponse<BookDTO>> getBookByTitle(@PathVariable("title") String title){
        return ApiResponseUtil.response(OK, bookService.getBookByTitle(title), "Successfully Retrieved");
    }

    @GetMapping("/books/{ISBN}")
    public ResponseEntity<BaseResponse<BookDTO>> getBookByISBN(@PathVariable("ISBN") String ISBN){
        return ApiResponseUtil.response(OK, bookService.getBookByISBN(ISBN), "Successfully Retrieved");
    }
    @DeleteMapping("/books/{id}")
    public String deleteBookById(@PathVariable("id") String id) {
        bookService.deleteBookById(id);
        return "Book deleted Successfully!!";
    }

}
