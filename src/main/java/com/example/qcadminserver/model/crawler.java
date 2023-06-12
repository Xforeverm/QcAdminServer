package com.example.qcadminserver.model;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * @author Xman
 * @version 1.0
 * @date 2023/6/11 13:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class crawler {
    @ExcelIgnore
    private int id;
    @ExcelProperty("小红书消费数")
    private String fee;
    @ExcelProperty("小红书展现数")
    private String impression;
    @ExcelProperty("小红书点击率")
    private String ctr;
    @ExcelProperty("小红书咨询人数")
    private String messageUser;
    @ExcelProperty("小红书开口数")
    private String initiativeMessage;
    @ExcelProperty("小红书咨询成本")
    private String messageConsultCpl;
    @ExcelProperty("小红书开口成本")
    private String initiativeMessageCpl;
    @ExcelProperty("企飞新增好友")
    private String add_customer;
    @ExcelProperty("账号")
    private String account;
    @ExcelProperty("记录时间")
    private LocalDateTime time;
}
