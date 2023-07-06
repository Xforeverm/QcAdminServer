package com.example.qcadminserver.service.impl;

import com.example.qcadminserver.dao.dataDao;
import com.example.qcadminserver.model.crawler;
import com.example.qcadminserver.service.detailService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Xman
 * @version 1.0
 * @date 2023/7/3 19:36
 */

@Service
public class detailServiceimpl implements detailService {

    @Autowired
    private dataDao dataDao;


    @Override
    public PageInfo<crawler> getAllData(int pageNum, int pageSize, String starttime, String endtime) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(loadAllData(starttime, endtime));
    }

    @Override
    public List<crawler> getAllData(String starttime, String endtime) {
        return loadAllData(starttime, endtime);
    }

    private List<crawler> loadAllData(String starttime, String endtime) {
        List<crawler> allData = dataDao.getAllData(starttime, endtime);
        allData.add(0, allData.get(0).clone());

        for (int i = 0; i < allData.size(); i++) {
            // 上一个时间段
            crawler crawler = allData.get(i);

            if (i < allData.size() - 1 && i != 0) {
                // 当前时间段
                crawler last  = allData.get(i + 1);
                // 分时消费数
                crawler.setFee(String.format("%.2f",Double.parseDouble(crawler.getFee()) - Double.parseDouble(last.getFee())));
                // 分时展现数
                crawler.setImpression(String.valueOf(Integer.parseInt(crawler.getImpression()) - Integer.parseInt(last.getImpression())));
                // 分时咨询人数
                crawler.setMessageUser(String.valueOf(Integer.parseInt(crawler.getMessageUser()) - Integer.parseInt(last.getMessageUser())));
                // 分时开口数
                crawler.setInitiativeMessage(String.valueOf(Integer.parseInt(crawler.getInitiativeMessage()) - Integer.parseInt(last.getInitiativeMessage())));
                // 分时新增好友
                crawler.setAdd_customer(String.valueOf(Integer.parseInt(crawler.getAdd_customer()) - Integer.parseInt(last.getAdd_customer())));
            }

            // 开口数
            double initiativeMessage = Integer.parseInt(crawler.getInitiativeMessage());
            // 咨询人数
            double messageUser = Integer.parseInt(crawler.getMessageUser());
            // 企飞新增人数
            double add_customer = Integer.parseInt(crawler.getAdd_customer());
            // 消费数
            double fee = Double.parseDouble(crawler.getFee());

            // 开口比
            crawler.setInitiativeRatio(messageUser != 0 ? String.format("%.2f", initiativeMessage / messageUser) : "0.0");
            // 添加比
            crawler.setAddRatio(initiativeMessage != 0 ? String.format("%.2f", add_customer / initiativeMessage) : "0.0");
            // 添加成本
            crawler.setAddCost(add_customer != 0 ? String.format("%.2f", fee / add_customer) : "0.0");
        }

        return allData;
    }
}
