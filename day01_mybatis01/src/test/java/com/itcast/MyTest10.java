package com.itcast;


import com.itcast.dao.ISaleinfoDao;

import com.itcast.domain.Saleinfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyTest10 {
    public static void main(String[] args) throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        SqlSession sqlSession = factory.openSession(true);
        ISaleinfoDao mapper = sqlSession.getMapper(ISaleinfoDao.class);
        List<Saleinfo> list = mapper.query();
        for (Saleinfo saleinfo : list) {
            System.out.println(saleinfo.getCustomer().getUsername());
            System.out.println(saleinfo.getSaletime());
            System.out.println(saleinfo.getBook().getBookname());
            System.out.println(saleinfo.getBook().getKind().getKind_name());
            /*System.out.println(saleinfo.getNums());
            System.out.println(saleinfo.getBook().getPrice());*/
            System.out.println(saleinfo.getNums()*saleinfo.getBook().getPrice());
            System.out.println("----------------");
        }
        sqlSession.close();
        is.close();



    }
}
