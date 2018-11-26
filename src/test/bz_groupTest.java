package test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.Bz_groupService;
import dao.Bz_groupDao;
import dto.Bz_groupDto;
import entity.bz_clazz;
import entity.bz_group;

//测试小组模块
public class bz_groupTest {
	//启动工厂
	 ApplicationContext app = new ClassPathXmlApplicationContext("/spring.xml");
	//生产dao
	 Bz_groupDao dao = (Bz_groupDao)this.app.getBean("bz_groupDao");
	 //生产service
	 Bz_groupService service =(Bz_groupService)this.app.getBean("bz_groupService");

	 
//测试service
	 //测试分页查
	 @Test
	 public void selrvicegroup(){
		 Bz_groupDto dto = service.selectGroup(1, 5);
		 System.out.println(dto);
	 }
//测试Dao
	 //测试--查所有
	 @Test
	 public void selectAll(){
		List<bz_group> list = dao.selectGroupAll(8);
		 for (bz_group bz_group : list) {
			System.out.println(bz_group);
		}
	 }
	//测试-数据总行数
	@Test
	public void selectSum(){
		int i = dao.sumAll();
		System.out.println(i);
	}
	//测试分页查询
	@Test
	 public void selectGroup(){
		List<bz_group> list = dao.selectGroup(1, 5);
		for (bz_group bz_group : list) {
			System.out.println(bz_group);
		}
	}
	//测试添加数据
	@Test
	public void insertGroup(){
		//班级对象
		bz_clazz clazz = new bz_clazz();
		clazz.setClzId(8);
		dao.insertGroup(new bz_group(null,"4组",new Date(),clazz));
	}
}
