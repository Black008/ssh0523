package cn.com.zhirun.ssh0507.dao;

import cn.com.zhirun.ssh0507.model.TUser;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UserDao {
    SessionFactory sessionFactory;
    /*检查登陆时候用户名是否正确*/
    public int CheckLoginUser(TUser user){
        Session session=sessionFactory.getCurrentSession();

        Query q = session.createQuery("SELECT user from TUser where user = ?");
        String username = user.getUser();
        q.setParameter(0, username);
        List<TUser> userList = q.list();

        if(userList.size()>0){
            return 1;
        }else{
            return 0;
        }
    }
    //调用更新一下当前时间
    public  void updateUser(TUser user){
        Session session=sessionFactory.getCurrentSession();
        Query q1 = session.createQuery("UPDATE TUser SET upddate='"+UserGetCurrTime()+"' where user = '"+user.getUser()+"'");
        q1.executeUpdate();
    }
    /*登陆时检查用户名是否跟密码一致同时更新一下当前时间*/
    public int checkLoginPwd(TUser user){
        Session session=sessionFactory.getCurrentSession();
        Query q = session.createQuery("SELECT user from TUser where user = ? and pwd = ?");
        String username = user.getUser();
        String password = user.getPwd();
        q.setParameter(0, username);
        q.setParameter(1, password);
        List<TUser> userList = q.list();

        if(userList.size()>0){

            return 1;
        }else{
            return 0;
        }

    }

    /*检查注册的时候用户名是否正确*/
    public int CheckregUser(TUser user){
        Session session=sessionFactory.getCurrentSession();

        Query q = session.createQuery("SELECT user from TUser where user = ?");
        String username = user.getUser();
        q.setParameter(0, username);
        List<TUser> userList = q.list();

        if(userList.size()>0){
            return 1;
        }else{
            return 0;
        }
    }

    /*注册 按注册按钮后插入数据库并且跳转页面-->*/
    public int addUser(TUser user){
        Session session=sessionFactory.getCurrentSession();

if(user!=null){
    user.setUpddate(UserGetCurrTime());
    user.setCredate(UserGetCurrTime());
    user.setDeleflg(0);
    session.save(user);
    return 1;
}else{
    return 0;
}


    }




    /*获取当前的创建用户时间插入数据库*/
    public String UserGetCurrTime() {
        /*java获取当前的时间*/
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
        String time =  df.format(new Date());// new Date()为获取当前系统时间
        return time;
    }




    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
