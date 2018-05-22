package cn.com.zhirun.ssh0507.model;

import java.util.List;

public class ResultTotal {
    List<TBusiness> result;
    int total;

    public List<TBusiness> getResult() {
        return result;
    }

    public void setResult(List<TBusiness> result) {
        this.result = result;
    }
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
