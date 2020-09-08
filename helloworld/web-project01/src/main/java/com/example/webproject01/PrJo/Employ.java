package com.example.webproject01.PrJo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author 20424
 * @Date 2020/8/31 23:24
 * @Version 1.0
 */
@Data
@NoArgsConstructor
public class Employ {
    private  Integer id;
    private  String lastname;
    private  String email;
    private  Integer sex;//0:男 1：女
    private  Deparent deparent;
    private  Date date;

    public Employ(Integer id, String lastname, String email, Integer sex, Deparent deparent) {
        this.id = id;
        this.lastname = lastname;
        this.email = email;
        this.sex = sex;
        this.deparent = deparent;
        this.date = new Date();
    }
}
