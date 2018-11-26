package test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//测试连接
public class SqlSessionTest {
	 ApplicationContext app = new ClassPathXmlApplicationContext("/spring.xml");

	@Test
	public void  factory(){
	    SqlSessionFactory factory = (SqlSessionFactory)this.app.getBean("factory");
	    SqlSession session = factory.openSession();
	    session.getConnection();
	    System.out.println(session.getConnection());

	}
}
