package com.itcast;


import com.itcast.dao.IBookDao;
import com.itcast.domain.Kind;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


public class MyTest_02 {
    public static void main(String[] args) throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        SqlSession sqlSession = factory.openSession(true);
        IBookDao mapper = sqlSession.getMapper(IBookDao.class);
        Kind kind = new Kind();
        kind.setId(7);
        mapper.del(kind);
        sqlSession.close();
        is.close();

        }





    }

