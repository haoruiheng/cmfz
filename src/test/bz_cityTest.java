package test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.Bz_cityService;
import dao.Bz_cityDao;
import dto.Bz_cityDto;
import entity.bz_city;

//就业城市
public class bz_cityTest {
	//启动工厂
	 ApplicationContext app = new ClassPathXmlApplicationContext("/spring.xml");
	 //Dao
	 Bz_cityDao dao=(Bz_cityDao)this.app.getBean("bz_cityDao");
	 Bz_cityService sercice=(Bz_cityService)this.app.getBean("bz_cityService");
//TestService
	 //分页查询
	 @Test
	 public void services(){
		 Bz_cityDto dto = sercice.selectPagingAll(1,3);
		 System.out.println(dto);
	 }
//TestDao 
	 //查所有
	 @Test
	 public void selectCilyAll(){
		 List<bz_city> list = dao.selectCityAll();
		 for (bz_city bz_city : list) {
			System.out.println(bz_city);
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
		List<bz_city> list = dao.selectPagingAll(1,3);
		
		for (bz_city bz_city : list) {
			System.out.println(bz_city);
		}
		System.out.println();
		for(int i=0;i<2;i++){
			System.out.println(i);

		}
	 }
	 //添加数据
	 @Test
	 public void insertcaty(){
		 dao.insertCity(new bz_city(null,"天津",new Date()));
		
	 }
}
