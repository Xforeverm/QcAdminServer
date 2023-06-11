package com.example.qcadminserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com/example/qcadminserver/dao")
public class QcAdminServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(QcAdminServerApplication.class, args);
    }

}
