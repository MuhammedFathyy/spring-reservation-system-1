package com.gradproject.yourspace.controller;

import com.gradproject.yourspace.entity.Request;
import com.gradproject.yourspace.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
