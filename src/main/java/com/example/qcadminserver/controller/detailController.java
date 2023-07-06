package com.example.qcadminserver.controller;

import com.example.qcadminserver.model.crawler;
import com.example.qcadminserver.service.detailService;
import com.example.qcadminserver.utils.ApiResult;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Xman
 * @version 1.0
 * @date 2023/7/3 19:35
 */
@RestController
public class detailController {
    @Autowired
    detailService detailService;

    @GetMapping("/details")
    public ApiResult getAllDetail(int pageNum, int pageSize, String starttime, String endtime){
        PageInfo<crawler> allData = detailService.getAllData(pageNum, pageSize, starttime, endtime);
        if (allData.getList() != null && allData.getList().size() != 0){
            return ApiResult.success(allData);
        }

        return ApiResult.fail("netword erroe no found data");
    }
}
