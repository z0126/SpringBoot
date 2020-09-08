package com.example.webproject01.Dao;

import com.example.webproject01.PrJo.Deparent;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//部门dao
@Repository
public class DeparentDao {
    //模拟数据库中的数据
    private static Map<Integer, Deparent> deparentMap=null;
    static {
        //静态内部类，类加载的时候会加载，只加载一次
        deparentMap=new HashMap<Integer, Deparent>();
        deparentMap.put(101,new Deparent(101,"教学部"));//静态内部类
        deparentMap.put(102,new Deparent(102,"后勤部"));
        deparentMap.put(103,new Deparent(103,"学工部"));
        deparentMap.put(104,new Deparent(104,"财务部"));
        deparentMap.put(105,new Deparent(105,"职工部"));
    }
    //获取所有部门信息
    public Collection<Deparent> getDparent(){
        return deparentMap.values();
    }
    //通过id得到部门信息
    public Deparent getDepaentById(Integer id){
        return deparentMap.get(id);
    }
}
