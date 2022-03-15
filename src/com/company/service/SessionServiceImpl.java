package com.company.service;

import com.company.model.Session;
import com.company.model.User;
import com.company.repository.InMemorySessionRepository;
import com.company.repository.SessionRepository;

public class SessionServiceImpl implements SessionService{
    private SessionRepository sessionRepository;
    {
        sessionRepository = new InMemorySessionRepository();
    }
    @Override
    public void add(Session session) {
        sessionRepository.add(session);
    }

    @Override
    public Session getByUser(User user) {
        return sessionRepository.getByUser(user);
    }
}
