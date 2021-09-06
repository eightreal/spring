package com.eight.spring.service.imp;

import com.eight.spring.dao.UserDao;
import com.eight.spring.service.UserSignService;
import com.eight.spring.util.User;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@NoArgsConstructor
@Service
public class UserSignServiceImp implements UserSignService {
    @Resource
    UserDao userDao;
    @Override
    public ResponseEntity userSignUp(ObjectNode requestBody) {
        String phone = requestBody.get("phone").asText();
        String name = requestBody.get("name").asText();
        String password = requestBody.get("password").asText();
        ObjectNode result = new ObjectNode(JsonNodeFactory.instance);
        result.put("phone", phone);
        result.put("name", name);
        result.put("password", password);

        User checkUser = this.userDao.findUserByPhone(phone);
        if (checkUser != null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(result.put("result", "phone has been used"));
        }
        User user = new User(phone, name, password);

        try {
            this.userDao.save(user);
            result.put("result", "succeed");
            return ResponseEntity.ok(result);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(500).
                    body(result.put("result", "failed"));
        }
    }

    @Override
    public ResponseEntity userLogIn(ObjectNode requestBody) {
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
