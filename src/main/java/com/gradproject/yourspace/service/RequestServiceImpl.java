package com.gradproject.yourspace.service;

import com.gradproject.yourspace.dao.RequestDAO;
import com.gradproject.yourspace.entity.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class RequestServiceImpl implements RequestService{

    @Autowired
    private RequestDAO requestDAO;
    @Override
    @Transactional
    public List<Request> findAll() {
        return requestDAO.findAll();
    }

    @Override
    @Transactional
    public Request findById(int requestId) {
        Request request = requestDAO.findById(requestId);
        if (request == null) throw new RuntimeException("No Request found with id " + requestId);
        return request;
    }

    @Override
    @Transactional
    public void saveRequest(Request request) {
        request.setRequestId(0);
        requestDAO.saveRequest(request);
    }

    @Override
    @Transactional
    public void updateRequest(Request request) {
        Request tempRequest = requestDAO.findById(request.getRequestId());
        if (tempRequest != null) requestDAO.saveRequest(request);
    }

    @Override
    @Transactional
    public void deleteRequest(int requestId) {
        Request request = requestDAO.findById(requestId);
        if (request == null) throw new RuntimeException("no request found with id " + requestId);
        requestDAO.deleteRequest(requestId);
    }
}
