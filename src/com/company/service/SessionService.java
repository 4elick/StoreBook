package com.company.service;

import com.company.entity.Session;
import com.company.entity.User;

public interface SessionService {
    void add(Session session);
    Session getByUser(User user);
}
