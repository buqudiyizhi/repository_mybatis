package com.itcast;

import com.itcast.dao.IBookDao;
import com.itcast.domain.Book;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class MyTest5 {
    public static void main(String[] args) throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        SqlSession sqlSession = factory.openSession(true);
        IBookDao mapper = sqlSession.getMapper(IBookDao.class);
        Book book = new Book();
        book.setBookname("三国演义");
        book.setKind_id(2);
        book.setAuthor("罗贯中");
        book.setCompany("人民出版社");
        book.setPrice(32.2);
        mapper.add(book);
        sqlSession.close();
        is.close();



    }
}
