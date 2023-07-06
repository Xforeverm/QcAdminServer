package com.example.qcadminserver.controller;

import com.example.qcadminserver.service.detailService;
import org.springframework.beans.factory.annotation.Autowired;
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

}
