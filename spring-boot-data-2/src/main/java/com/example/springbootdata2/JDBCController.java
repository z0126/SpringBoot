package com.example.springbootdata2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author 20424
 * @Date 2020/9/2 17:31
 * @Version 1.0
 */
@RestController
public class JDBCController {
    @Autowired
    JdbcTemplate jdbcTemplate;//spring中集成好的可以拿来就用

    //查询数据库中的所有数据
    //没有实体类如何查询信息 Map类，可以查询所有的信息
    @RequestMapping("/userlist")
    public List<Map<String,Object>> userlist(){
        String sql="select * from user";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }
    @RequestMapping("/adduser")
    public String Adduser(){
        String sql="insert into user VALUES(\"12443\",\"113213\",\"str\")";
        jdbcTemplate.update(sql);
        return "update-ok";
    }
}
