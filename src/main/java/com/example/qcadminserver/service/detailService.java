package com.example.qcadminserver.service;

import com.example.qcadminserver.dao.detailDao;
import com.example.qcadminserver.model.crawler;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Xman
 * @version 1.0
 * @date 2023/7/3 19:36
 */
public interface detailService {

    PageInfo<crawler> getAllData(int pageNum, int pageSize, String starttime, String endtime);

    List<crawler> getAllData(String starttime, String endtime);

}
