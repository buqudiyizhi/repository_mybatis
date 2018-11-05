package com.itcast;


import com.itcast.dao.IBookDao;
import com.itcast.dao.ISaleinfoDao;
import com.itcast.domain.Book;
import com.itcast.domain.Saleinfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyTest_01 {
    public static void main(String[] args) throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        SqlSession sqlSession = factory.openSession(true);
        IBookDao mapper = sqlSession.getMapper(IBookDao.class);
        List<Book> books = mapper.queryBook();
        for (Book book : books) {
            System.out.println(book);
        }

        sqlSession.close();
        is.close();



    }
}
