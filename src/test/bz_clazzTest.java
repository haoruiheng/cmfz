package test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.Bz_clazzService;
import dao.Bz_clazzDao;
import dto.Bz_clazzDto;
import entity.bz_clazz;
import entity.bz_tag;

//小组
public class bz_clazzTest {
	//启动工厂
	 ApplicationContext app = new ClassPathXmlApplicationContext("/spring.xml");
	 //Dao
	 Bz_clazzDao dao=(Bz_clazzDao)this.app.getBean("bz_clazzDao");
	 Bz_clazzService sercice=(Bz_clazzService)this.app.getBean("bz_clazzService");
//TestService
	 //分页查询
	 @Test
	 public void services(){
		 Bz_clazzDto dto = sercice.selectBz_clazz(1, 3);
		 System.out.println(dto);
	 }
//TestDao
	 //查询所有
	 @Test
	 public void selectclazzAll(){
		 List<bz_clazz> list = dao.selectClazzAll();
		 for (bz_clazz bz_clazz : list) {
			System.out.println(bz_clazz);
		}
	 }
	 //总条数
	 @Test
	 public void sumAll(){
		int i = dao.sumAll();
		System.out.println(i);
	 }
	 //分页查寻
	 @Test
	 public void selectAll(){
		List<bz_clazz> list = dao.selectClazz(1, 3);
		for (bz_clazz bz_clazz : list) {
			System.out.println(bz_clazz);
		}
		
	 }
	 //添加数据
	 @Test
	 public void insertcaty(){
		 bz_tag tag = new bz_tag();
		 tag.setTagType(1);
		 dao.incertClazz(new bz_clazz(null,"3班",new Date(),tag));
	 }
}
