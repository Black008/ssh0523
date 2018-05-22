package cn.com.zhirun.ssh0507.controller;

import cn.com.zhirun.ssh0507.model.Pages;
import cn.com.zhirun.ssh0507.model.ResultTotal;
import cn.com.zhirun.ssh0507.model.TBusiness;
import cn.com.zhirun.ssh0507.model.TUser;
import cn.com.zhirun.ssh0507.service.BusinessService;
import cn.com.zhirun.ssh0507.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class BusinessController extends ActionSupport {
    BusinessService businessService;
    TBusiness tbusiness;
    String result;
    ResultTotal resultTotal;
    List<String> dates;
    Pages pages;

    /*添加商家*/
    public String addBusiness(){
        int num = businessService.addBusiness(tbusiness);
        if(num==1){
            result="添加成功跳转";
        }
        return SUCCESS;
    }
    /*查询商家*/
    public String selectByBusiness(){
        List<TBusiness> result = businessService.selectByBusiness(tbusiness);
        int total = businessService.ReturntotalByBusinessSelect(tbusiness);
        resultTotal.setResult(result);
        resultTotal.setTotal(total);
        ActionContext.getContext().getSession().put("business",tbusiness);
        return SUCCESS;
    }
    /*其他按钮*/
    public String ClickSelectByBusiness(){
        tbusiness = (TBusiness) ActionContext.getContext().getSession().get("business");
        List<TBusiness> result = businessService.ClickSelectByBusiness(tbusiness,pages);
        resultTotal.setResult(result);
        return SUCCESS;
    }
    /*更新商家*/
    public String updateBusiness(){
        int num = businessService.updateBusiness(tbusiness);
        if(num>0){
            ActionContext.getContext().getSession().put("business1",tbusiness);
            result="更新成功";
        }
        return SUCCESS;
    }
    /*删除所选更新标志位*/
    public String updateFlgByDeleteBusinessServlet(){
        businessService.updateFlgByDeleteBusinessServlet(dates);
        List<TBusiness> result = businessService.selectByBusiness(tbusiness);
        resultTotal.setResult(result);
        return SUCCESS;
    }
    /*退出登录*/
    public String quitUserLogin(){
        ActionContext.getContext().getSession().remove("user2");
        return SUCCESS;
    }
    /*当输入商家名字失去焦点之后，查询数据库商家名字是否存在，如果存在跳转页面显示用户名以存在*/
    public String selectByName(){
        List<TBusiness> businessList=businessService.selectByName(tbusiness);
        if(businessList.size()!=0){
             result="1";
        }
        return SUCCESS;
    }










    public Pages getPages() {
        return pages;
    }

    public void setPages(Pages pages) {
        this.pages = pages;
    }
    public List<String> getDates() {
        return dates;
    }

    public void setDates(List<String> dates) {
        this.dates = dates;
    }

    public ResultTotal getResultTotal() {
        return resultTotal;
    }

    public void setResultTotal(ResultTotal resultTotal) {
        this.resultTotal = resultTotal;
    }

    public BusinessService getBusinessService() {
        return businessService;
    }

    public void setBusinessService(BusinessService businessService) {
        this.businessService = businessService;
    }

    public TBusiness getTbusiness() {
        return tbusiness;
    }

    public void setTbusiness(TBusiness tbusiness) {
        this.tbusiness = tbusiness;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
