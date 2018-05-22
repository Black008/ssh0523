package cn.com.zhirun.ssh0507.controller;

import cn.com.zhirun.ssh0507.model.TUser;
import cn.com.zhirun.ssh0507.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserController extends ActionSupport {
    UserService userService;
    TUser tuser;
    String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public TUser getTuser() {
        return tuser;
    }

    public void setTuser(TUser tuser) {
        this.tuser = tuser;
    }
    /*检查登陆用户名是否存在*/
    public String CheckLoginUser(){

        int num = userService.CheckLoginUser(tuser);
        if(num==1){
            result="1";
        }else {
            result="0";
        }
        return SUCCESS;
    }
    /*检查登陆密码是否存在*/
    public String checkLoginPwd(){

        int num = userService.checkLoginPwd(tuser);
        if(num==1){
            result="1";
            ActionContext.getContext().getSession().put("user2",tuser.getUser());
        }else {
            result="0";
        }
        return SUCCESS;
    }

    /*检查注册用户名是否存在*/
    public String CheckregUser(){

        int num = userService.CheckregUser(tuser);
        if(num==1){
            result="已存在";
        }else {
            result="可以注册";
        }
        return SUCCESS;
    }
    /*注册 按注册按钮后插入数据库并且跳转页面-->*/
     public String addUser(){

         int num = userService.addUser(tuser);
         if(num==1){
             result="注册成功请登录";
         }
         return SUCCESS;
     }


    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
