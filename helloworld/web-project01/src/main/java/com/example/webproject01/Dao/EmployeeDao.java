package com.example.webproject01.Dao;

import com.example.webproject01.PrJo.Deparent;
import com.example.webproject01.PrJo.Employ;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author 20424
 * @Date 2020/9/1 17:08
 * @Version 1.0
 */
public class EmployeeDao {
    //模拟数据库中的数据
    private static Map<Integer, Employ> employMap=null;
    @Autowired
    private DeparentDao deparentDao;//每个员工有自己的部门,sataic 优先加载，所以类初始化后才自动装配，因此无法使用相应的方法
    static {
        //静态内部类，类加载的时候会加载，只加载一次
        employMap=new HashMap<Integer, Employ>();
        employMap.put(1001,new Employ(1001,"AA","W2042438311@qq.com",1,new Deparent(101,"教学部")));//静态内部类
        employMap.put(1002,new Employ(1002,"AB","R2042438311@qq.com",0,new Deparent(102,"后勤部")));
        employMap.put(1003,new Employ(1003,"AC","T2042438311@qq.com",1,new Deparent(103,"学工部")));
        employMap.put(1004,new Employ(1004,"AD","Y2042438311@qq.com",0,new Deparent(104,"财务部")));
        employMap.put(1005,new Employ(1005,"AE","U2042438311@qq.com",1,new Deparent(105,"职工部")));
    }
    //组件自增id
    public static Integer idlid=1006;//静态变量全局都可以修改
    //添加员工
    public void save(Employ employ){
        if(employ.getId()==null){
            employ.setId(idlid);
        }
        employ.setDeparent(deparentDao.getDepaentById(employ.getDeparent().getId()));
        employMap.put(employ.getId(),employ);
    }
    //查询全部员工
    public Collection<Employ> getAll(){
        return employMap.values();
    }
    //根据id
    public Employ getById(Integer id){
        return employMap.get(id);
    }
    //删除
    public void delByid(Integer id){
        employMap.remove(id);
    }
}
