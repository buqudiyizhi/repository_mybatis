
import com.itheima.dao.IBookDao;
import com.itheima.domain.Book;
import com.itheima.domain.Kind;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class MybatisTest {
    private InputStream is = null;
    private SqlSession sqlSession =null;
    IBookDao mapper =null;
    SqlSessionFactory factory =null;
    @Before
    public  void init() {

        try {
            is = Resources.getResourceAsStream("SqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(is);
        sqlSession = factory.openSession(true);
        mapper = sqlSession.getMapper(IBookDao.class);

    }
    @Test
    public void testFindCount(){
        int count = mapper.findCount();
        System.out.println(count);
    }
    @Test
    public void testFind(){
        List<Book> books = mapper.find();
        for (Book book : books) {
            System.out.println(book.getBookname());
            System.out.println(book.getAuthor());
            System.out.println(book.getKind().getKind_name());
            System.out.println("-------------");

        }
    }
    @Test
    public void testFind1(){
        List<Book> books = mapper.find();
        for (Book book : books) {
            System.out.println(book.getBookname());
            System.out.println(book.getAuthor());
            System.out.println(book.getKind().getKind_name());
            System.out.println("-------------");

        }
    }
    @Test
    public void testFind2(){
        SqlSession sqlSession1 = factory.openSession(true);
        IBookDao mapper1 = sqlSession1.getMapper(IBookDao.class);
        List<Map<String, String>> list = mapper1.find2();
        sqlSession1.close();
        System.out.println("============");
        SqlSession sqlSession2 = factory.openSession(true);
        IBookDao mapper2= sqlSession2.getMapper(IBookDao.class);
        List<Map<String, String>> list1 = mapper2.find2();
        sqlSession2.close();
        System.out.println(list1.equals(list));
        /*for (Map<String, String> map : list) {
            System.out.println(map.get("bookname"));
            System.out.println(map.get("author"));
            System.out.println(map.get("kind_name"));
            System.out.println("----------------");

        }*/
    }
    @Test
    public void testFindByCondition(){
        Book b = new Book();
        b.setCompany("%江%");
        List<Book> list = mapper.findByCondition(b);
        for (Book book : list) {
            System.out.println(book.getBookname());
            System.out.println(book.getCompany());

        }
    }
    @Test
    public void testFindByBookId(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(5);
        list.add(8);
        List<Book> list1 = mapper.findByBookId(list);
        for (Book book : list1) {
            System.out.println(book.getBookname()+":"+book.getCompany());

        }
    }
    @Test
    public void testFindByBookId_one(){
        int[] array={2,5,8};

            List<Book> b = mapper.findByBookId_one(array);
            System.out.println(b);

        }
    @Test
    public void testFindByKind_name(){
        Kind kind = new Kind();
        kind.setKind_name("网络文学类");
        List<Book> books = mapper.findByKind_name(kind);
        for (Book book : books) {
            System.out.println(book.getBookname());
            System.out.println(book.getKind().getKind_name());
            System.out.println("------------------");
        }
    }
    @Test
    public void testUpdateById(){
        List<Integer> list = new ArrayList<Integer>();
        HashMap<String,Object> map = new HashMap<String,Object>();
        Collections.addAll(list, 3, 6, 9);
        map.put("price",999.999);
        map.put("list",list);
        mapper.updateById(map);


    }
    @Test
    public void testFindByPrice(){
        List<Book> list = mapper.findByPrice();
        for (Book book:list) {
            System.out.println(book);

        }
    }


    @After
    public void destroy(){
        sqlSession.close();
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
