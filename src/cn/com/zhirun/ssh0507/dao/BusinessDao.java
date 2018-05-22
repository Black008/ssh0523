package cn.com.zhirun.ssh0507.dao;

import cn.com.zhirun.ssh0507.model.Pages;
import cn.com.zhirun.ssh0507.model.TBusiness;
import cn.com.zhirun.ssh0507.model.TUser;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusinessDao {
    SessionFactory sessionFactory;
    /*添加用户*/
    public int addBusiness(TBusiness business){
        if(business!=null){
            Session session=sessionFactory.getCurrentSession();
            business.setBusinessId("GYX"+BusinessGetCurrTime());
            business.setUppda(UserGetCurrTime());
            business.setCred(UserGetCurrTime());
            business.setFlg(0);
            session.save(business);
            return 1;
        }else{
            return 0;
        }

    }
    /*查询商家*/
    public List<TBusiness> selectByBusiness(TBusiness business){
        Session session=sessionFactory.getCurrentSession();
        String hql =
                "from TBusiness where flg=0";

            if(null!=business&&!"".equals(business.getBusinessId())){
                hql =hql+" and businessId like '%"+business.getBusinessId()+"%' ";

            }
            if(null!=business&&!"".equals(business.getBusinessName())){
                hql =hql+" and businessName like '%"+business.getBusinessName()+"%' ";
            }
            if(null!=business&&!"".equals(business.getPhone())){
                hql =hql+" and phone = '"+business.getPhone()+"' ";
            }
            if(!"".equals(business.getBusinessKinds())&&business.getBusinessKinds()!=null){
                hql =hql+" and businessKinds = '"+business.getBusinessKinds()+"' ";
            }
            if(!"".equals(business.getBusinessaddress())&&business.getBusinessKinds()!=null){
                hql =hql+" and businessaddress = '"+business.getBusinessaddress()+"' ";
            }
            if(null!=business&&!"".equals(business.getDetailaddress())){
                hql =hql+" and detailaddress like '%"+business.getDetailaddress()+"%' ";
            }

            hql = hql + " and salary > " +business.getSalaryFrom();

            if(null!=business && business.getSalaryTo()>0){
                hql = hql + " and salary < " +business.getSalaryTo();
            }
        Query q = session.createQuery(hql);
        q.setFirstResult(0);
        q.setMaxResults(5);
        List<TBusiness> result = q.list();


        return result;
    }
    /*其他按钮*/
    public List<TBusiness> ClickSelectByBusiness(TBusiness business,Pages pages){
        Session session=sessionFactory.getCurrentSession();
        String hql =
                "from TBusiness where flg=0";

        if(null!=business&&!"".equals(business.getBusinessId())){
            hql =hql+" and businessId like '%"+business.getBusinessId()+"%' ";

        }
        if(null!=business&&!"".equals(business.getBusinessName())){
            hql =hql+" and businessName like '%"+business.getBusinessName()+"%' ";
        }
        if(null!=business&&!"".equals(business.getPhone())){
            hql =hql+" and phone = '"+business.getPhone()+"' ";
        }
        if(!"".equals(business.getBusinessKinds())&&business.getBusinessKinds()!=null){
            hql =hql+" and businessKinds = '"+business.getBusinessKinds()+"' ";
        }
        if(!"".equals(business.getBusinessaddress())&&business.getBusinessKinds()!=null){
            hql =hql+" and businessaddress = '"+business.getBusinessaddress()+"' ";
        }
        if(null!=business&&!"".equals(business.getDetailaddress())){
            hql =hql+" and detailaddress like '%"+business.getDetailaddress()+"%' ";
        }

        hql = hql + " and salary > " +business.getSalaryFrom();

        if(null!=business && business.getSalaryTo()>0){
            hql = hql + " and salary < " +business.getSalaryTo();
        }
        Query q = session.createQuery(hql);
        int frist = (pages.getNowPage()-1)*pages.getShowPages();
        int second = pages.getShowPages();
        q.setFirstResult(frist);
        q.setMaxResults(second);
        List<TBusiness> result = q.list();
        return result;
    }
    /*返回总数*/
    public int ReturntotalByBusinessSelect(TBusiness business){
        int total=0;
        Session session=sessionFactory.getCurrentSession();
        String hql =
//                "SELECT businessId,businessName,phone,businessKinds,businessaddress,detailaddress,salary " +
                "from TBusiness where flg=0";

        if(null!=business&&!"".equals(business.getBusinessId())){
            hql =hql+" and businessId like '%"+business.getBusinessId()+"%' ";

        }
        if(null!=business&&!"".equals(business.getBusinessName())){
            hql =hql+" and businessName like '%"+business.getBusinessName()+"%' ";
        }
        if(null!=business&&!"".equals(business.getPhone())){
            hql =hql+" and phone = '"+business.getPhone()+"' ";
        }
        if(!"".equals(business.getBusinessKinds())&&business.getBusinessKinds()!=null){
            hql =hql+" and businessKinds = '"+business.getBusinessKinds()+"' ";
        }
        if(!"".equals(business.getBusinessaddress())&&business.getBusinessKinds()!=null){
            hql =hql+" and businessaddress = '"+business.getBusinessaddress()+"' ";
        }
        if(null!=business&&!"".equals(business.getDetailaddress())){
            hql =hql+" and detailaddress like '%"+business.getDetailaddress()+"%' ";
        }

        hql = hql + " and salary > " +business.getSalaryFrom();

        if(null!=business && business.getSalaryTo()>0){
            hql = hql + " and salary < " +business.getSalaryTo();
        }
        Query q = session.createQuery(hql);

        List<TBusiness> arr = q.list();
        total=arr.size();
        return total;

    }
    /*更新商家*/
    public int updateBusiness(TBusiness business){
        Session session=sessionFactory.getCurrentSession();
        int num = 0;
        Query q1 = session.createQuery("UPDATE TBusiness SET uppda='"+UserGetCurrTime()+"'" +
                ", phone='"+business.getPhone()+"'"+
                ", businessKinds='"+business.getBusinessKinds()+"'" +
                ", businessaddress='"+business.getBusinessaddress()+"'" +
                ", detailaddress='"+business.getDetailaddress()+"'" +
                ", salary='"+business.getSalary()+"'" +
                "where businessId = '"+business.getBusinessId()+"'");
        num=q1.executeUpdate();
        return num;
    }
    /*删除所选更新标志位*/
    public void updateFlgByDeleteBusinessServlet(List<String> dates){
        Session session=sessionFactory.getCurrentSession();
        for(int i=0;i<dates.size();i++){
            String s =  dates.get(i);
            Query q1 = session.createQuery("UPDATE TBusiness SET uppda='"+UserGetCurrTime()+"' " + ",flg=1" + " where businessId='"+s+"'");
            q1.executeUpdate();
        }

    }
    /*当输入商家名字失去焦点之后，查询数据库商家名字是否存在，如果存在跳转页面显示用户名以存在*/
    public List<TBusiness> selectByName(TBusiness business){
        Session session=sessionFactory.getCurrentSession();
        String hql =
                "from TBusiness where businessName = ?";
        Query q = session.createQuery(hql);
        String businessName = business.getBusinessName();
        q.setParameter(0, businessName);
        List<TBusiness> businessList = q.list();
        return businessList;

    }













    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /*获取当前的创建用户时间插入数据库*/
    public String UserGetCurrTime() {
        /*java获取当前的时间*/
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String time =  df.format(new Date());// new Date()为获取当前系统时间
        return time;
    }
    /*获取当前的创建用户时间插入数据库*/
    public String BusinessGetCurrTime() {
        /*java获取当前的时间*/
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd HH:mm:ss");//设置日期格式
        String time =  df.format(new Date());// new Date()为获取当前系统时间
        return time;
    }
}
