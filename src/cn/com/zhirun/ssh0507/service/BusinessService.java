package cn.com.zhirun.ssh0507.service;

import cn.com.zhirun.ssh0507.dao.BusinessDao;
import cn.com.zhirun.ssh0507.dao.UserDao;
import cn.com.zhirun.ssh0507.model.Pages;
import cn.com.zhirun.ssh0507.model.TBusiness;

import java.util.List;

public class BusinessService {
    BusinessDao businessDao;
    /*添加商家*/
    public int addBusiness(TBusiness business){
        System.out.println("uuu");
        int num = businessDao.addBusiness(business);
        return num;
    }
    /*查询商家*/
    public List<TBusiness> selectByBusiness(TBusiness business){
        List<TBusiness> result = businessDao.selectByBusiness(business);
        return result;
    }
    /*其他按钮*/
    public List<TBusiness> ClickSelectByBusiness(TBusiness business,Pages pages){
        List<TBusiness> result = businessDao.ClickSelectByBusiness(business,pages);
        return result;
    }
    /*返回总数*/
    public int ReturntotalByBusinessSelect(TBusiness business){
        int total = businessDao.ReturntotalByBusinessSelect(business);
        return total;
    }
    /*更新商家*/
    public int updateBusiness(TBusiness business){
        int num = businessDao.updateBusiness(business);
        return num;
    }
    /*删除所选更新标志位*/
    public void updateFlgByDeleteBusinessServlet(List<String> dates){
        businessDao.updateFlgByDeleteBusinessServlet(dates);
    }
    /*当输入商家名字失去焦点之后，查询数据库商家名字是否存在，如果存在跳转页面显示用户名以存在*/
    public List<TBusiness> selectByName(TBusiness business){
        List<TBusiness> businessList=businessDao.selectByName(business);
        return businessList;
    }





    public BusinessDao getBusinessDao() {
        return businessDao;
    }

    public void setBusinessDao(BusinessDao businessDao) {
        this.businessDao = businessDao;
    }
}
