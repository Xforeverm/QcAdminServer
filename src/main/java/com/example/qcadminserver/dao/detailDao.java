package com.example.qcadminserver.dao;

import com.example.qcadminserver.model.crawler;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Xman
 * @version 1.0
 * @date 2023/7/3 19:36
 */
@Mapper
public interface detailDao {

    List<crawler> getAllDetial(String strattime, String endtime);

}
