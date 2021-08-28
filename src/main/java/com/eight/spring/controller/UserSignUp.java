package com.eight.spring.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.ResponseEntity;

public interface UserSignUp {
    public ResponseEntity<ObjectNode> SignUpController(ObjectNode requestBody);
}
