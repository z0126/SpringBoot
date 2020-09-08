package com.example.webproject01.PrJo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 部门表
 * @Author 20424
 * @Date 2020/8/31 20:29
 * @Version 1.0
 */
@Data//相当于@setter+@getter+@toString
@AllArgsConstructor//有参构造
@NoArgsConstructor//无参构造
public class Deparent {
    private Integer id;
    private String Name;
}
