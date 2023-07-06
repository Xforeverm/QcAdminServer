package com.example.qcadminserver.service.impl;

import com.example.qcadminserver.dao.detailDao;
import com.example.qcadminserver.model.crawler;
import com.example.qcadminserver.service.detailService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Xman
 * @version 1.0
 * @date 2023/7/3 19:36
 */

@Service
public class detailServiceimpl implements detailService{

    @Autowired
    detailDao detailDao;


    @Override
    public PageInfo<crawler> getAllData(int pageNum, int pageSize, String starttime, String endtime) {
        return null;
    }

    @Override
    public List<crawler> getAllData(String starttime, String endtime) {
        return null;
    }
}
