package com.company.repository;

import com.company.model.Session;
import com.company.model.User;

import java.util.ArrayList;
import java.util.List;

public class InMemorySessionRepository implements SessionRepository{
    List<Session> sessions;
    int inc;
    {
        sessions = new ArrayList<>();
    }
    @Override
    public void add(Session session) {
        session.setId(++inc);
        sessions.add(session);
    }

    @Override
    public Session getByUser(User user) {
        for (Session session : sessions) {
            if (session.getUser().equals(user)){
                return session;
            }
        }
        return null;
    }
}
