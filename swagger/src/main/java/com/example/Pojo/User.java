package com.example.Pojo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
//@Api("模块注释"):一般不用
@ApiModel("用户实体")//实体类的文档注释，可有可无，视情况而定
public class User {
    @ApiModelProperty("用户名")//实体类的文档注释，可有可无，视情况而定
    public String username;
    @ApiModelProperty("密码")//实体类的文档注释，可有可无，视情况而定
    public String password;
}
