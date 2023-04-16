package com.gradproject.yourspace.service;

import com.gradproject.yourspace.entity.Request;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public interface RequestService {

    List<Request> findAll();

    Request findById(int requestId);

    void saveRequest(Request request);

    void updateRequest(Request request);

    void deleteRequest(int requestId);

    void updateRequestPartially(int id, HashMap<String, Object> fields);

    void requestCycle(int requestId , String status) throws IOException;
}
