package com.company.service;

import com.company.entity.Store;

import java.util.List;

public interface StoreService {
    void add(Store store);
    void deleteById(int id);
    Store findByName(String name);
    Store findById(int id);
    List<Store> findAll();
}
