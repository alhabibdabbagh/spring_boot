package com.example.demo.dao;


import java.util.List;

public interface BaseDAO<T> {

    List<T> findAll();
    T findById(int id);
    String save(T object);
    void deleteById(int id);
}

