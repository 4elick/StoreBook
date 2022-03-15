package com.company.service;

import com.company.model.Session;
import com.company.model.User;

public interface SessionService {
    void add(Session session);
    Session getByUser(User user);
}
