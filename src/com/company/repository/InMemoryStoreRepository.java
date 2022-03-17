package com.company.repository;

import com.company.entity.Store;

import java.util.ArrayList;
import java.util.List;

public class InMemoryStoreRepository implements StoreRepository {
    private List<Store> stores;
    private int inc;

    {
        stores = new ArrayList<>();
    }

    @Override
    public void add(Store store) {
        store.setId(++inc);
        stores.add(store);
    }

    @Override
    public void deleteById(int id) {
        for (Store store : stores) {
            if (store.getId() == id) {
                stores.remove(store);
            }
        }
    }

    @Override
    public Store findByName(String name) {
        for (Store store : stores) {
            if (store.getName() == name) {
                return store;
            }
        }
        return null;
    }

    @Override
    public Store findById(int id) {
        for (Store store : stores) {
            if (store.getId() == id) {
                return store;
            }
        }
        return null;
    }

    @Override
    public List<Store> findAll() {
        return stores;
    }
}
