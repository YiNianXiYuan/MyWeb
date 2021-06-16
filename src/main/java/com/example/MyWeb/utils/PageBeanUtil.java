package com.example.MyWeb.utils;

import java.util.List;

/**
 * @author admin
 *	分页的工具类
 * @param <T>
 */
public class PageBeanUtil<T> {
    //当前页
    private Integer localPage;
    //总页数
    private Integer totalPage;
    //每页显示数量
    private Integer pageSize = 5;
    //总记录量
    private Integer totalNum;
    //首页
    private Integer firstPage = 1;
    //上一页
    private Integer prePage;
    //下一页
    private Integer nextPage;
    //尾页
    private Integer lastPage;
    //显示的数据
    private List<T> list;
    public PageBeanUtil() {
        // TODO Auto-generated constructor stub
    }
    public PageBeanUtil(Integer localPage, Integer totalNum) {
        super();
        this.localPage = localPage;	//当前页
        this.totalNum = totalNum;	//总记录数
        //总页数：如果总记录数对每页记录数能够整除，就取除数，如果不能整除，就取除数加1
        this.totalPage = this.totalNum % this.pageSize == 0 ?
                this.totalNum / this.pageSize : this.totalNum / this.pageSize+1;
        //上一页：如果当前页为第一页，就返回当前页，否则就返回当前页-1
        this.prePage = this.localPage == 1 ? this.localPage : this.localPage - 1;
        //下一页：如果当前页为最后一页，就返回最后一页，否则就返回当前页+1
        this.nextPage = this.localPage == this.totalPage ? this.totalPage : this.localPage + 1;
        //最后一页：就等于总页数
        this.lastPage = this.totalPage;
    }
    public Integer getLocalPage() {
        return localPage;
    }
    public void setLocalPage(Integer localPage) {
        this.localPage = localPage;
    }
    public Integer getTotalPage() {
        return totalPage;
    }
    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
    public Integer getPageSize() {
        return pageSize;
    }
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
    public Integer getTotalNum() {
        return totalNum;
    }
    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }
    public Integer getFirstPage() {
        return firstPage;
    }
    public void setFirstPage(Integer firstPage) {
        this.firstPage = firstPage;
    }
    public Integer getPrePage() {
        return prePage;
    }
    public void setPrePage(Integer prePage) {
        this.prePage = prePage;
    }
    public Integer getNextPage() {
        return nextPage;
    }
    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }
    public Integer getLastPage() {
        return lastPage;
    }
    public void setLastPage(Integer lastPage) {
        this.lastPage = lastPage;
    }
    public List<T> getList() {
        return list;
    }
    public void setList(List<T> list) {
        this.list = list;
    }
}