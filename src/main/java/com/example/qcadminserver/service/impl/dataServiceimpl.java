package com.example.qcadminserver.service.impl;

import com.alibaba.excel.EasyExcel;
import com.example.qcadminserver.dao.dataDao;
import com.example.qcadminserver.model.crawler;
import com.example.qcadminserver.service.dataService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Xman
 * @version 1.0
 * @date 2023/6/11 18:35
 */
@Service
public class dataServiceimpl implements dataService {

    @Autowired
    dataDao dataDao;

    @Override
    public PageInfo<crawler> getAllData(int pageNum, int pageSize, String starttime, String endtime) {
        PageHelper.startPage(pageNum, pageSize);
        List<crawler> allData = dataDao.getAllData(starttime, endtime);
        return new PageInfo<>(allData);
    }

    @Override
    public List<crawler> getAllData(String starttime, String endtime) {
        return dataDao.getAllData(starttime,endtime);
    }
}
