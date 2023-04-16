package com.gradproject.yourspace.service;

import com.gradproject.yourspace.APIs.SendEmailService;
import com.gradproject.yourspace.dao.RequestDAO;
import com.gradproject.yourspace.entity.Request;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import javax.transaction.Transactional;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RequestServiceImpl implements RequestService {

    private final RequestDAO requestDAO;

    public RequestServiceImpl(RequestDAO requestDAO) {
        this.requestDAO = requestDAO;
    }

    @Override
    @Transactional
    public List<Request> findAll() {
        return requestDAO.findAll();
    }

    @Override
    @Transactional
    public Request findById(int requestId) {
        Request request = requestDAO.findById(requestId).orElse(null);
        if (request == null)
            throw new RuntimeException("no request found with id " + requestId);
        return request;
    }

    @Override
    @Transactional
    public void saveRequest(Request request) {
        requestDAO.save(request);
    }

    @Override
    @Transactional
    public void updateRequest(Request request) {
        requestDAO.save(request);
    }

    @Override
    @Transactional
    public void deleteRequest(int requestId) {
        Request request = requestDAO.findById(requestId).orElse(null);
        if (request == null)
            throw new RuntimeException("no request found with id " + requestId);
        requestDAO.delete(request);
    }

    @Override
    public void updateRequestPartially(int id, HashMap<String, Object> fields) {
        Request request = requestDAO.findById(id).orElse(null);
        if (request == null)
            throw new RuntimeException("no request found with id " + id);
        fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Request.class, key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, request, value);
        });
        requestDAO.save(request);
    }

    @Override
    public void requestCycle(int requestId , String status) throws IOException {
        Optional<Request> request = requestDAO.findById(requestId);
        if(!request.isPresent()){
            throw new RuntimeException();
        }

        String requestStatus = status.toLowerCase();
        request.get().setStatus(status);

        SendEmailService sendEmailService = new SendEmailService();
        sendEmailService.sendEmail("mfathy56734@gmail.com"
                , "Request for new Space is " + status
                , "Dear " + request.get().getUser().getFirstName() + "\n"
                        + ((requestStatus == "accepted") ?
                        sendEmailService.getAcceptanceContentMessage() : sendEmailService.getRejectionContentMessage())
                , null);

        if(Objects.equals(requestStatus, "accepted")){
            // to be discussed hn3ml ehh hna?
        }
        else if(Objects.equals(requestStatus , "rejected")){
            requestDAO.delete(request.get());
        }
    }
}
