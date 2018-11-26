package test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.Bz_tagService;
import dao.Bz_tagDao;
import dto.Bz_tagDto;
import entity.bz_tag;

//标签 模块
public class bz_tagTest {
	//启动工厂
	 ApplicationContext app = new ClassPathXmlApplicationContext("/spring.xml");
	 //Dao
	 Bz_tagDao dao=(Bz_tagDao)this.app.getBean("bz_tagDao");
	 Bz_tagService sercice=(Bz_tagService)this.app.getBean("bz_tagService");
//TestService
	 //分页查询
	 @Test
	 public void services(){
		Bz_tagDto dto = sercice.selectAll(1, 3);
		System.out.println(dto);
	 }
//TestDao 
	 //根据 K-查询所有
	 @Test
	 public void selecttagType(){
		 List<bz_tag> list = dao.selectTagAll(0);
		 for (bz_tag bz_tag : list) {
			System.out.println(bz_tag);
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
		List<bz_tag> list = dao.selectPagingAll(1,3);
		for (bz_tag bz_tag : list) {
			System.out.println(bz_tag);
		}
	 }
	 //添加数据
	 @Test
	 public void insertcaty(){
		dao.insertTag(new bz_tag(null,"鬼才",0,new Date()));
	 }
}
