package com.example.qcadminserver.controller;

import com.example.qcadminserver.model.crawler;
import com.example.qcadminserver.service.dataService;
import com.example.qcadminserver.utils.ApiResult;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Xman
 * @version 1.0
 * @date 2023/6/11 18:32
 */
@RestController
public class dataController {

    @Autowired
    dataService dataService;

    @GetMapping("/datas")
    public ApiResult getAllData(int pageNum, int pageSize, String starttime, String endtime){
        PageInfo<crawler> infoData = dataService.getAllData(pageNum, pageSize, starttime, endtime);
        if (infoData.getList() != null && infoData.getList().size() > 0){
            return ApiResult.success(infoData);
        }
        return ApiResult.fail("not found data");
    }

    @GetMapping("/data/export")
    public ApiResult exportData(String starttime, String endtime){
        dataService.exportData(starttime,endtime);
        return ApiResult.success();
    }

}
