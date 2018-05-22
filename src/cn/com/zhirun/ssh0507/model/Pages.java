package cn.com.zhirun.ssh0507.model;

public class Pages {
    int totalPage;
    int nowPage;
    int ShowPages;

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getNowPage() {
        return nowPage;
    }

    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }

    public int getShowPages() {
        return ShowPages;
    }

    public void setShowPages(int showPages) {
        ShowPages = showPages;
    }
}
