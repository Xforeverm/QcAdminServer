package com.example.qcadminserver.controller;

import com.example.qcadminserver.model.user;
import com.example.qcadminserver.service.loginService;
import com.example.utils.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

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
    public ApiResult userLogin(@RequestBody user user) {
        String token = UUID.randomUUID().toString().replace("-", "");
        Map<String, Object> result = new HashMap<>();
        result.put("token", token);
        if (loginService.loginverify(user.getUsername(), user.getPassword())) {
            return ApiResult.success(result);
        }
        return ApiResult.fail("username or password is wrong");
    }

    @GetMapping("/user/info")
    public ApiResult getUserInfo() {
        Map<String, Object> result = new HashMap<>();
        result.put("name", "heihei");
        result.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        return ApiResult.success(result);
    }

    @PostMapping("/user/logout")
    public ApiResult userLogout() {
        // if save token must remove token
        return ApiResult.success();
    }
}
