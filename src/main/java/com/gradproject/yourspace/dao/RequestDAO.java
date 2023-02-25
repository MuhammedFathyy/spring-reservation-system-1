package com.gradproject.yourspace.dao;

import com.gradproject.yourspace.entity.Request;

import java.util.List;

public interface RequestDAO {
    List<Request> findAll();

    Request findById(int requestId);

    void saveRequest(Request request);

    void deleteRequest(int requestId);
}
