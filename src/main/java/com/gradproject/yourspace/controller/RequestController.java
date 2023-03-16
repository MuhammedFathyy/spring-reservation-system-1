package com.gradproject.yourspace.controller;

import com.gradproject.yourspace.entity.Request;
import com.gradproject.yourspace.service.RequestService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class RequestController {
    private final RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping("")
    public List<Request> findAll() {
        return requestService.findAll();
    }

    @GetMapping("/{requestId}")
    public Request getRequest(@PathVariable int requestId) {
        return requestService.findById(requestId);
    }

    @PostMapping("")
    public void saveRequest(@RequestBody Request request) {
        request.setRequestId(0);
        requestService.saveRequest(request);
    }

    @PutMapping("")
    public void updateRequest(@RequestBody Request request) {
        requestService.updateRequest(request);
    }

    @DeleteMapping("/{requestId}")
    public void deleteRequest(@PathVariable int requestId) {
        requestService.deleteRequest(requestId);
    }

    @PatchMapping("/{id}")
    public void updateRequestPartially(@PathVariable int id, @RequestBody HashMap<String, Object> fields) {
        requestService.updateRequestPartially(id, fields);
    }

}
