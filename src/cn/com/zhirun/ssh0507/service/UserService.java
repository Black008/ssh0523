package cn.com.zhirun.ssh0507.service;

import cn.com.zhirun.ssh0507.dao.UserDao;
import cn.com.zhirun.ssh0507.model.TUser;

public class UserService {
    UserDao userDao;

    /*检查登陆用户名是否存在*/
    public int CheckLoginUser(TUser user) {
        int num = userDao.CheckLoginUser(user);
        return num;
    }

    /*检查密码是否正确*/
    public int checkLoginPwd(TUser user) {
        int num = userDao.checkLoginPwd(user);
        if (num > 0) {
            userDao.updateUser(user);
        }
        return num;
    }

    /*检查注册用户名是否存在*/
    public int CheckregUser(TUser user) {
        int num = userDao.CheckregUser(user);
        return num;
    }

    /*注册 按注册按钮后插入数据库并且跳转页面-->*/
    public int addUser(TUser user) {

        int num = userDao.addUser(user);

        return num;

    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
