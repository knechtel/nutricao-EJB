package br.com.nutricao.bean;

import javax.ejb.Remote;

@Remote
public interface BookService {
    void createOrUpdate(Book book);
    void remove(Book book);
    Book find(Object id);
}