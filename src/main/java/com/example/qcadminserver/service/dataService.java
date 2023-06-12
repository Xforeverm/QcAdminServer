package com.example.qcadminserver.service;

import com.example.qcadminserver.model.crawler;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author Xman
 * @version 1.0
 * @date 2023/6/11 18:34
 */
public interface dataService {

    PageInfo<crawler> getAllData(int pageNum, int pageSize, String starttime, String endtime);

    List<crawler> getAllData(String starttime, String endtime);
}
