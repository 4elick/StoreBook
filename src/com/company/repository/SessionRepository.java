package com.company.repository;

import com.company.model.Session;
import com.company.model.User;

public interface SessionRepository {
    void add(Session session);
    Session getByUser(User user);
}
