package cn.com.zhirun.ssh0507.model;

import java.util.Objects;

public class TUser {
    private int id;
    private String user;
    private String pwd;
    private String credate;
    private String upddate;
    private Integer deleflg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getCredate() {
        return credate;
    }

    public void setCredate(String credate) {
        this.credate = credate;
    }

    public String getUpddate() {
        return upddate;
    }

    public void setUpddate(String upddate) {
        this.upddate = upddate;
    }

    public Integer getDeleflg() {
        return deleflg;
    }

    public void setDeleflg(Integer deleflg) {
        this.deleflg = deleflg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TUser tUser = (TUser) o;
        return id == tUser.id &&
                Objects.equals(user, tUser.user) &&
                Objects.equals(pwd, tUser.pwd) &&
                Objects.equals(credate, tUser.credate) &&
                Objects.equals(upddate, tUser.upddate) &&
                Objects.equals(deleflg, tUser.deleflg);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, user, pwd, credate, upddate, deleflg);
    }
}
