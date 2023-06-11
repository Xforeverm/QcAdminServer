package com.example.qcadminserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Xman
 * @version 1.0
 * @date 2023/6/11 13:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class user {
    // 用户id
    private Integer id;
    // 用户性别
    private Integer gender;
    // 用户角色
    private Integer role;
    // 用户名称
    private String username;
    // 用户密码 默认123456
    private String password;
    // 用户手机号
    private String phone;
    // 创建时间
    private LocalDateTime createdate;

}
