package com.example.qcadminserver;

import com.example.qcadminserver.dao.loginDao;
import com.example.qcadminserver.model.user;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class QcAdminServerApplicationTests {

    @Autowired
    loginDao loginDao;

    @Test
    void contextLoads() {
        user user = new user();
        user.setUsername("haha");
        user.setPassword("123456");
        user.setPhone("18511912092");
        user.setCreatedate(LocalDateTime.now());
        System.out.println(loginDao.insertUser(user));


        System.out.println(loginDao.findUser("heihei"));
    }

}
