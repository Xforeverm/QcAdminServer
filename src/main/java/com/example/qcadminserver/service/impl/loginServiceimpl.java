package com.example.qcadminserver.service.impl;

import com.example.qcadminserver.dao.loginDao;
import com.example.qcadminserver.model.user;
import com.example.qcadminserver.service.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Xman
 * @version 1.0
 * @date 2023/6/11 14:35
 */
@Service
public class loginServiceimpl implements loginService {

    @Autowired
    loginDao logindao;

    @Override
    public boolean loginverify(String username, String password) {
        user user = logindao.findUser(username);
        if (user != null && user.getPassword().equals(password)){
            return true;
        }

        return false;
    }
}
