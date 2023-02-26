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
        return requestDAO.findById(requestId);
    }

    @Override
    @Transactional
    public void saveRequest(Request request) {
        requestDAO.saveRequest(request);
    }

    @Override
    @Transactional
    public void updateRequest(Request request) {
        requestDAO.saveRequest(request);
    }

    @Override
    @Transactional
    public void deleteRequest(int requestId) {
        requestDAO.deleteRequest(requestId);
    }
}
