package com.company.service;

import com.company.entity.Store;
import com.company.repository.DBRepository.DBStoreRepository;
import com.company.repository.InMemoryStoreRepository;
import com.company.repository.StoreRepository;

import java.util.List;

public class StoreServiceImpl implements StoreService{
    private DBStoreRepository storeRepository;
    {
        storeRepository = new DBStoreRepository();
    }
    @Override
    public void add(Store store) {
        storeRepository.add(store);
    }

    @Override
    public void deleteById(int id) {
        storeRepository.deleteById(id);
    }

    @Override
    public Store findByName(String name) {
        return storeRepository.findByName(name);
    }

    @Override
    public Store findById(int id) {
        return storeRepository.findById(id);
    }

    @Override
    public List<Store> findAll() {
        return storeRepository.findAll();
    }
}
