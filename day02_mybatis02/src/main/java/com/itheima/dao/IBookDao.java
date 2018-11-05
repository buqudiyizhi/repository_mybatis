package com.itheima.dao;

import com.itheima.domain.Book;
import com.itheima.domain.Kind;
import com.itheima.domain.Saleinfo;


import java.util.List;
import java.util.Map;

public interface IBookDao {
    List<Book> find();
    List<Book> find1();
    List<Map<String,String>> find2();
    List<Book> findAll();
    int findCount();
    Book findById();
    List<Map<String,String>> findByBookname();
    List<Map<String,String>> findByKind_id();
    void add(Book book);
    Integer del(Integer id);
    void modify(Book book);
    void testUpdate(Map map);
    List<Book> findByCompany(String str);
    List<Saleinfo> query();
    List<Book>findByCondition(Book book);
    List<Book> findByBookId(List<Integer> list);
    List<Book> findByBookId_one(int[] array);
    List<Book> findByKind_name(Kind kind);
    void updateById(Map<String, Object> map);
    List<Book> findByPrice();





}
