package com.group4.service.interfaces;

import com.group4.model.Author;
import com.group4.model.Book;

import java.util.List;

public interface AuthorService {
    void addAuthor(Author author);

    void updateAuthor(Author author);

    void removeAuthor(int id);

    Author getAuthorById(int id);

    List<Author> listAuthor();

    Author getAuthorByFullName(String[] fullName);
}
