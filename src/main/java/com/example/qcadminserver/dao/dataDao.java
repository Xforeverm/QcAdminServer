package com.example.qcadminserver.dao;

import com.example.qcadminserver.model.crawler;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Xman
 * @version 1.0
 * @date 2023/6/11 18:37
 */
@Mapper
public interface dataDao {

    List<crawler> getAllData(String starttime, String endtime);

}
