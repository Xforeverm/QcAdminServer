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
import java.util.function.Consumer;

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
        return new PageInfo<>(loadAllData(starttime, endtime));
    }

    @Override
    public List<crawler> getAllData(String starttime, String endtime) {
        return loadAllData(starttime, endtime);
    }

    private List<crawler> loadAllData(String starttime, String endtime){
        List<crawler> allData = dataDao.getAllData(starttime, endtime);

        allData.forEach(crawler -> {
            // 开口数
            double initiativeMessage = Integer.parseInt(crawler.getInitiativeMessage());
            // 咨询人数
            double messageUser = Integer.parseInt(crawler.getMessageUser());
            // 企飞新增人数
            double add_customer = Integer.parseInt(crawler.getAdd_customer());
            // 消费数
            double fee = Double.parseDouble(crawler.getFee());

            // 开口比
            crawler.setInitiativeRatio(messageUser != 0 ?  String.format("%.2f",initiativeMessage / messageUser): "0.0");
            // 添加比
            crawler.setAddRatio(initiativeMessage != 0 ? String.format("%.2f", add_customer / initiativeMessage): "0.0");
            // 添加成本
            crawler.setAddCost(add_customer != 0 ? String.format("%.2f", fee / add_customer) : "0.0");
        });

        return allData;
    }
}
