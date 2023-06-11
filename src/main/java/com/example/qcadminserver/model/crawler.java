package com.example.qcadminserver.model;

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
    private int id;
    private String fee;
    private String impression;
    private String ctr;
    private String messageUser;
    private String initiativeMessage;
    private String messageConsultCpl;
    private String initiativeMessageCpl;
    private String add_customer;
    private String account;
    private LocalDateTime time;
}
