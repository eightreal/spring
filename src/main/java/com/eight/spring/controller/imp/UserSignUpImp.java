package com.eight.spring.controller.imp;

import com.eight.spring.controller.UserSignUp;
import com.eight.spring.dao.UserDao;
import com.eight.spring.util.User;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;


@Controller
public class UserSignUpImp implements UserSignUp {
    @Resource
    UserDao userDao;
    @Override
    @RequestMapping(
            method =  RequestMethod.POST,
            value = "/sign",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ObjectNode> SignUpController(
            @RequestBody ObjectNode requestBody) {
        String phone = requestBody.get("phone").asText();
        String name = requestBody.get("name").asText();
        String password = requestBody.get("password").asText();
        ObjectNode result = new ObjectNode(JsonNodeFactory.instance);
        result.put("phone", phone);
        result.put("name", name);
        result.put("password", password);

        User checkUser = userDao.findUserByPhone(phone);
        if (checkUser != null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(result.put("result", "phone has been used"));
        }
        User user = new User(phone, name, password);

        try {
            userDao.save(user);
            result.put("result", "succeed");
            return ResponseEntity.ok(result);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(500).
                    body(result.put("result", "failed"));
        }
    }
}
