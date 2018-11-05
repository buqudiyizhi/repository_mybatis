package com.itcast.dao;

import com.itcast.domain.Book;
import com.itcast.domain.Kind;
import com.itcast.domain.Saleinfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

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
    void updateById(Map<String,Object> map);
    //注解查询
    @Select(value = "select *from book")
    List<Book> queryBook();
    //注解删除
    @Delete("delete from kind where id=#{id}")
    void del(Kind kind);
    //注解添加
    @Insert("insert into kind values(null,#{kind_name})")
    void add(String kind_name);
    @Select("SELECT * FROM book WHERE price<100")
    List<Book> findByPrice();




}
