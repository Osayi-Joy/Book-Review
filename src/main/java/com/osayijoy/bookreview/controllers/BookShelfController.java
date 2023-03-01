package com.osayijoy.bookreview.controllers;

import com.osayijoy.bookreview.service.BookShelfService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value="/api/book-review")
public class BookShelfController {
    private final BookShelfService bookShelfService;





}
