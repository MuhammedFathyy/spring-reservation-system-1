package com.gradproject.yourspace.controller;

import com.gradproject.yourspace.dto.RequestDTO;
import com.gradproject.yourspace.entity.Request;
import com.gradproject.yourspace.service.RequestService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/requests")
public class RequestController {
    private final RequestService requestService;
    private final ModelMapper modelMapper;

    public RequestController(RequestService requestService, ModelMapper modelMapper) {
        this.requestService = requestService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("")
    public List<RequestDTO> findAll() {
        return requestService.findAll()
                .stream()
                .map(request -> modelMapper.map(request, RequestDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{requestId}")
    public RequestDTO getRequest(@PathVariable int requestId) {
        return modelMapper.map(requestService.findById(requestId), RequestDTO.class);
    }

    @PostMapping("")
    public void saveRequest(@Valid @RequestBody RequestDTO requestDTO) {
        requestDTO.setRequestId(0);
        requestService.saveRequest(modelMapper.map(requestDTO, Request.class));
    }

    @PutMapping("")
    public void updateRequest(@Valid @RequestBody RequestDTO requestDTO) {
        Request request = modelMapper.map(requestDTO, Request.class);
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

    @PostMapping("/{requestId}")
    public ResponseEntity<?> requestService(@PathVariable int requestId, @RequestParam String status) {
        try {
            requestService.requestCycle(requestId, status);
            return ResponseEntity.ok("You Request has been handeled");
        } catch (IOException e) {
            return new ResponseEntity<>("Bad Request", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/users/{userId}")
    public List<RequestDTO> getRequestsByUserID(@PathVariable int userId) {
        List<Request> requests = requestService.getRequestsByUserID(userId);
        return requests.stream()
                .map(request -> modelMapper.map(request, RequestDTO.class))
                .collect(Collectors.toList());
    }

}
