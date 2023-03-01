package com.gradproject.yourspace.controller;

import com.gradproject.yourspace.entity.Request;
import com.gradproject.yourspace.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RequestController {
    @Autowired
    private RequestService requestService;

    @GetMapping("/requests")
    public List<Request> findAll() {
        return requestService.findAll();
    }

    @GetMapping("/request/{requestId}")
    public Request getRequest(@PathVariable int requestId) {
        if (requestService.findById(requestId) == null)
            throw new RuntimeException("no request found with id " + requestId);
        return requestService.findById(requestId);
    }

    @PostMapping("/requests")
    public void saveRequest(@RequestBody Request request) {
        request.setRequestId(0);
        requestService.saveRequest(request);
    }

    @PutMapping("/requests")
    public void updateRequest(@RequestBody Request request) {
        requestService.updateRequest(request);
    }

    @DeleteMapping("/request/{requestId}")
    public void deleteRequest(@PathVariable int requestId) {
        if (requestService.findById(requestId) == null)
            throw new RuntimeException("no request found with id " + requestId);
        requestService.deleteRequest(requestId);
    }

    @PatchMapping("/requests/{id}")
    public void updateRequestPartially(@PathVariable int id, @RequestBody HashMap<String, Object> fields) {
        Request request = requestService.findById(id);
        fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Request.class, key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, request, value);
        });
        requestService.updateRequest(request);
    }
















}
