package com.eight.spring.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.ResponseEntity;

public interface UserSignService {
    public ResponseEntity userLogIn(ObjectNode requestBody);
    public ResponseEntity userSignUp(ObjectNode requestBody);
}
