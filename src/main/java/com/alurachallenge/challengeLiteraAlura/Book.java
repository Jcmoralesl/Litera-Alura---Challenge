package com.alurachallenge.challengeLiteraAlura;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Book {

    @Id
    @Column (nullable = false)
    private String title;
    @Column (nullable = false)
    private String author;
    @Column (nullable = false)
    private String language;

    public Book() {}

    public Book(String title, String author, String language) {
        this.title = title;
        this. author = author;
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
