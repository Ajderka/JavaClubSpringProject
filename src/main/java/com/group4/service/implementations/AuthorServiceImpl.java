package com.group4.service.implementations;

import com.group4.dao.interfaces.AuthorDAO;
import com.group4.model.Author;
import com.group4.service.interfaces.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorDAO authorDAO;

    @Autowired
    public AuthorServiceImpl(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    @Override
    @Transactional
    public void addAuthor(Author book) {
        this.authorDAO.save(book);
    }

    @Override
    @Transactional
    public void updateAuthor(Author author) {
        this.authorDAO.update(author);
    }

    @Override
    @Transactional
    public void removeAuthor(int id) {
        this.authorDAO.deleteById(id);

    }

    @Override
    @Transactional
    public Author getAuthorById(int id) {
        return this.authorDAO.findById(id);
    }

    @Override
    @Transactional
    public List<Author> listAuthor() {
        return this.authorDAO.findAll();
    }
}