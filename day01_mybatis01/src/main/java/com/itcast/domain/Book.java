package com.itcast.domain;

public class Book {
    private Integer id;
    private String bookname;
    private Integer kind_id;
    private String author;
    private String company;
    private Double price;
    private Kind kind;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Integer getKind_id() {
        return kind_id;
    }

    public void setKind_id(Integer kind_id) {
        this.kind_id = kind_id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Kind getKind() {
        return kind;
    }

    public void setKind(Kind kind) {
        this.kind = kind;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookname='" + bookname + '\'' +
                ", kind_id=" + kind_id +
                ", author='" + author + '\'' +
                ", company='" + company + '\'' +
                ", price=" + price +
                '}';
    }
}
