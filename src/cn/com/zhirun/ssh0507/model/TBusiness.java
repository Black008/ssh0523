package cn.com.zhirun.ssh0507.model;

import java.util.Objects;

public class TBusiness {
    private String businessId;
    private String businessName;
    private String phone;
    private String businessKinds;
    private String businessaddress;
    private String detailaddress;
    private Integer salary;
    int salaryFrom;
    int salaryTo;
    private String cred;
    private String uppda;
    private Integer flg;
    private String comment;
    public int getSalaryFrom() {
        return salaryFrom;
    }

    public void setSalaryFrom(int salaryFrom) {
        this.salaryFrom = salaryFrom;
    }

    public int getSalaryTo() {
        return salaryTo;
    }

    public void setSalaryTo(int salaryTo) {
        this.salaryTo = salaryTo;
    }



    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBusinessKinds() {
        return businessKinds;
    }

    public void setBusinessKinds(String businessKinds) {
        this.businessKinds = businessKinds;
    }

    public String getBusinessaddress() {
        return businessaddress;
    }

    public void setBusinessaddress(String businessaddress) {
        this.businessaddress = businessaddress;
    }

    public String getDetailaddress() {
        return detailaddress;
    }

    public void setDetailaddress(String detailaddress) {
        this.detailaddress = detailaddress;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getCred() {
        return cred;
    }

    public void setCred(String cred) {
        this.cred = cred;
    }

    public String getUppda() {
        return uppda;
    }

    public void setUppda(String uppda) {
        this.uppda = uppda;
    }

    public Integer getFlg() {
        return flg;
    }

    public void setFlg(Integer flg) {
        this.flg = flg;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TBusiness tBusiness = (TBusiness) o;
        return Objects.equals(businessId, tBusiness.businessId) &&
                Objects.equals(businessName, tBusiness.businessName) &&
                Objects.equals(phone, tBusiness.phone) &&
                Objects.equals(businessKinds, tBusiness.businessKinds) &&
                Objects.equals(businessaddress, tBusiness.businessaddress) &&
                Objects.equals(detailaddress, tBusiness.detailaddress) &&
                Objects.equals(salary, tBusiness.salary) &&
                Objects.equals(cred, tBusiness.cred) &&
                Objects.equals(uppda, tBusiness.uppda) &&
                Objects.equals(flg, tBusiness.flg) &&
                Objects.equals(comment, tBusiness.comment);
    }

    @Override
    public int hashCode() {

        return Objects.hash(businessId, businessName, phone, businessKinds, businessaddress, detailaddress, salary, cred, uppda, flg, comment);
    }
}
