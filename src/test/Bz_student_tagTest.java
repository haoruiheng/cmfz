package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.Bz_student_tagDao;

//关系表
public class Bz_student_tagTest {
	//启动工厂
	 ApplicationContext app = new ClassPathXmlApplicationContext("/spring.xml");
	//生产dao
	 Bz_student_tagDao dao = (Bz_student_tagDao)this.app.getBean("bz_student_tagDao");
		
	
//dao测试
	//添加数据
	@Test
	public void Bz_student_tagDao(){
		dao.insertstudent_tag(8,6);
	}
}
