package com.itcast;

import com.itcast.dao.IBookDao;
import com.itcast.domain.Book;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest9 {
    public static void main(String[] args) throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        SqlSession sqlSession = factory.openSession(true);
        IBookDao mapper = sqlSession.getMapper(IBookDao.class);
        List<Book> books = mapper.findByCompany("%江%");
        for (Book book : books) {
            System.out.println(book);

        }
        sqlSession.close();
        is.close();



    }
}
