package com.eight.spring.controller.imp;

import com.eight.spring.controller.UserSignInController;
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
public class UserSignInControllerImp implements UserSignInController {
    @Autowired
    private UserSignService userSignService;

    @Override
    @RequestMapping(value = "/login",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity SignInController(
            @RequestBody ObjectNode requestBody) {
        return  userSignService.userLogIn(requestBody);
    }
}
