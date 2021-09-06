package com.eight.spring.controller.imp;

import com.eight.spring.controller.UserSignUpController;
import com.eight.spring.service.UserSignService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserSignUpControllerImp implements UserSignUpController {
    @Autowired
    UserSignService userSignService;
    @Override
    @RequestMapping(
            method =  RequestMethod.POST,
            value = "/sign",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity SignUpController(
            @RequestBody ObjectNode requestBody) {
        return userSignService.userSignUp(requestBody);
    }
}
