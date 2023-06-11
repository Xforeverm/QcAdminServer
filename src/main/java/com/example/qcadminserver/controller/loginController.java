package com.example.qcadminserver.controller;

import com.example.qcadminserver.model.user;
import com.example.qcadminserver.service.loginService;
import com.example.utils.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Xman
 * @version 1.0
 * @date 2023/6/11 14:41
 */
@RestController
public class loginController {

    @Autowired
    loginService loginService;


    @PostMapping("/login")
    public ApiResult userLogin(@RequestBody user user){
        System.out.println(user);
        if (loginService.loginverify(user.getUsername(), user.getPassword())){
            return ApiResult.success();
        }
        return ApiResult.fail();
    }
}
