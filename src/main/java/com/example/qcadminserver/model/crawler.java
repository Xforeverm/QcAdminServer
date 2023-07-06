package com.example.qcadminserver.model;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.TreeSet;

/**
 * @author Xman
 * @version 1.0
 * @date 2023/6/11 13:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class crawler implements Cloneable {
    @ExcelIgnore
    private int id;
    @ExcelProperty("记录时间")
    private LocalDateTime time;
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
    @ExcelProperty("开口比")
    private String initiativeRatio;
    @ExcelProperty("添加比")
    private String addRatio;
    @ExcelProperty("添加成本")
    private String addCost;
    @ExcelProperty("账号")
    private String account;

    @Override
    public crawler clone(){
        try {
            return (crawler) super.clone();
        }catch (CloneNotSupportedException e){
            // 不保存数据库
            return new crawler(this.id, this.time, this.fee, this.impression, this.ctr, this.messageUser, this.initiativeMessage, this.messageConsultCpl, this.initiativeMessageCpl, this.add_customer, this.initiativeRatio, this.addRatio, this.addCost, this.account);
        }

    }

}
