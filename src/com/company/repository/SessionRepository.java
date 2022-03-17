package com.company.repository;

import com.company.entity.Session;
import com.company.entity.User;

public interface SessionRepository {
    void add(Session session);
    Session getByUser(User user);
}
