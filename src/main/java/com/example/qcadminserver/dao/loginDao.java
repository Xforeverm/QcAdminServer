package com.example.qcadminserver.dao;

import com.example.qcadminserver.model.user;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Xman
 * @version 1.0
 * @date 2023/6/11 13:43
 */
@Mapper
public interface loginDao {

    user findUser(String usernmae);

    int insertUser(user user);

}
