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

public class MyTest3 {
    public static void main(String[] args) throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        SqlSession sqlSession = factory.openSession();
        IBookDao mapper = sqlSession.getMapper(IBookDao.class);
        List<Map<String, String>> list = mapper.findByBookname();
        for (Map<String, String> map : list) {
            System.out.println(map);
        }
        sqlSession.close();



    }
}
