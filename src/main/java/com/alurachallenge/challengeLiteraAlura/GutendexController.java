package com.alurachallenge.challengeLiteraAlura;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GutendexController {

    private GutendexService gutendexService;

    @GetMapping("/books/search/{title}")
    public List<Book> seachBookByTitle(@PathVariable("title") String title) {
        return gutendexService.searchBookByTitle(title);
    }

    @GetMapping ("/books")
    public List <Book> listRegisteredBook () {
        return gutendexService.listRegisterdBooks();
    }

    @GetMapping("/books/language/{language}")
    public List <Book> listBooksByLanguage(@PathVariable("language") String language) {
        return gutendexService.listBooksByLanguage(language);
    }

}
