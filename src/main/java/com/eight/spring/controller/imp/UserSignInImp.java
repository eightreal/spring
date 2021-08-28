package com.eight.spring.controller.imp;

import com.eight.spring.controller.UserSignIn;
import com.eight.spring.dao.UserDao;
import com.eight.spring.util.User;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class UserSignInImp implements UserSignIn {
    @Resource
    private UserDao userDao;

    @Override
    @RequestMapping(value = "/login",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity SignInController(
            @RequestBody ObjectNode requestBody) {
        String phone = requestBody.get("phone").asText();
        String password = requestBody.get("password").asText();
        User user = this.userDao.findUserByPhone(phone);
        if (user == null)
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("the phone is not sign up");
        else {
            if (!user.getPassword().equals(password)) {
                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("password is wrong");
            }
            else {
                ObjectNode response = new ObjectNode(JsonNodeFactory.instance);
                return ResponseEntity
                        .ok(response
                                .put("name", user.getName())
                                .put("result", "succeed"));
            }
        }
    }
}
