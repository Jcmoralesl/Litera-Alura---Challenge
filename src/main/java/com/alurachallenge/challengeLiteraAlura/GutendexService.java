package com.alurachallenge.challengeLiteraAlura;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class GutendexService {

    @Autowired
    private BookRepository bookRepository;

    private final String API_URL = "https://gutendex.com/books";
    private final RestTemplate restTemplate = new RestTemplate();

    //Buscar libro por titulo

    public List<Book> searchBookByTitle(String title) {
        String url = API_URL + "?search=" + title;
        JsonArray booksArray = getBooksFromApi(url);
        List<Book> books = new ArrayList<>();

        for (int i = 0; i < booksArray.size(); i++) {
            JsonObject bookJson = booksArray.getAsJsonObject();
            String bookTitle = bookJson.getAsString();
            String author = bookJson.getAsJsonArray("authors").getAsJsonObject().getAsString();
            String language = bookJson.getAsJsonArray("languages").getAsString();
            books.add(new Book(bookTitle, author, language));
        }

        //Guardar libro en la base de datos

        for (Book book : books) {
            if (!bookRepository.existsById(book.getTitle())) {
                bookRepository.save(book);
            }
        }

        return books;
    }

    public List<Book> listRegisterdBooks() {
        return bookRepository.findAll();
    }

    //listar libro por idioma

    public List<Book> listBooksByLanguage(String language) {
        return bookRepository.findByLanguage(language);
    }

    private JsonArray getBooksFromApi(String url) {
        String jsonResponse = restTemplate.getForObject(url, String.class);
        System.out.println("API response:" + jsonResponse);

        JsonObject jsonObject = new JsonObject();
        return jsonObject.getAsJsonArray("results");
    }
}

