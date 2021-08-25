package com.eight.spring.controller.imp;

import com.eight.spring.controller.UserSignIn;
import com.eight.spring.dao.UserDao;
import com.eight.spring.util.User;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserSignInImp implements UserSignIn {
    @Resource
    private JdbcTemplate jdbcTemplete;
    @Resource
    private UserDao userDao;

    @Override
    @RequestMapping(value = "/login",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> SignInController() {
//        String sql = "select * from user";
//        List list = jdbcTemplete.queryForList(sql);
        Long  a = 1L;
        User user = this.userDao.findUserById(a);
        if (user == null) return ResponseEntity.ok("null");
        try {
            return ResponseEntity.ok("bahao");
        }catch (Exception e){
            System.out.println(e.toString());
            return ResponseEntity.ok("fasle");
        }
    }
}
