package com.alurachallenge.challengeLiteraAlura;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository <Book, String>{

    List <Book> findByTitleContaining (String title);
    List <Book> findByLanguage (String language);
}
