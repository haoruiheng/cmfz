package test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.Bz_studentService;
import dao.Bz_studentDao;
import dto.Bz_studentDto;
import entity.bz_city;
import entity.bz_clazz;
import entity.bz_group;
import entity.bz_student;

//学生查询
public class Bz_studentTest {
	//启动工厂
	 ApplicationContext app = new ClassPathXmlApplicationContext("/spring.xml");
	 //Dao
	 Bz_studentDao dao=(Bz_studentDao)this.app.getBean("bz_studentDao");
	 //select
	 Bz_studentService select =(Bz_studentService)this.app.getBean("bz_studentService");

//Test Select
	 //分页查所有
	 @Test
	 public void selectBz_studentS(){
		 Bz_studentDto dto = select.selectStudent(1, 3);
		 System.out.println(dto);
	 }
//TestDao 
	 //增加数据
	 @Test
	 public void insertStu(){
		 bz_student student = new bz_student();
		 student.setStuNname("戴老大");
		 student.setBirthday(new Date());
		 student.setPhone("111-1111111");
		 student.setClazzId(new bz_clazz(8,null,null,null));
		 student.setGroupId(new bz_group(22,null,null,null));
		 student.setCityId(new bz_city(1,null,null));
		 
		 System.out.println(student);
		 dao.insertStudents(student);
	 }
	 //查所有
	 @Test
	 public void selectStudentsAll(){
		 List<bz_student> list = dao.selectStudentsAll();
		 for (bz_student bz_student : list) {
			System.out.println(bz_student);
		}
	 }
	 //分页查所有
	 @Test
	 public void selectBz_student(){
		List<bz_student> list = dao.selectStudent(1,3);
		for (bz_student bz_student : list) {
			System.out.println(bz_student);
		}
	 }
	 //总条数
	 @Test
	 public void sumAll(){
		 int i = dao.sumAll();
		 System.out.println(i);
	 }
}
