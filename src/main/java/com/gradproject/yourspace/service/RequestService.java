package com.gradproject.yourspace.service;

import com.gradproject.yourspace.entity.Request;

import java.util.List;

public interface RequestService {

    List<Request> findAll();

    Request findById(int requestId);

    void saveRequest(Request request);

    void updateRequest(Request request);

    void deleteRequest(int requestId);
}
