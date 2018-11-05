package com.itcast.domain;

import java.util.Date;

public class Saleinfo {
    private Integer saleid;
    private Integer bookid;
    private Integer cid;
    private Date saletime;
    private Integer nums;
    private Customer customer;
    private Book book;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getSaleid() {
        return saleid;
    }

    public void setSaleid(Integer saleid) {
        this.saleid = saleid;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Date getSaletime() {
        return saletime;
    }

    public void setSaletime(Date saletime) {
        this.saletime = saletime;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    @Override
    public String toString() {
        return "Saleinfo{" +
                "saleid=" + saleid +
                ", bookid=" + bookid +
                ", cid=" + cid +
                ", saletime=" + saletime +
                ", nums=" + nums +
                '}';
    }
}
