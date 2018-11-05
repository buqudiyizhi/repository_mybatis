package com.itcast;

import com.itcast.dao.IBookDao;
import com.itcast.domain.Book;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyTest7 {
    public static void main(String[] args) throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        SqlSession sqlSession = factory.openSession(true);
        IBookDao mapper = sqlSession.getMapper(IBookDao.class);
        Book book = new Book();
        book.setBookname("红楼梦");
        book.setKind_id(2);
        book.setAuthor("曹雪芹");
        book.setCompany("人民文学出版社");
        book.setPrice(99.99);
        book.setId(10);
        mapper.modify(book);
        sqlSession.close();
        is.close();



    }
}
