package controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.Bz_cityService;
import dto.Bz_cityDto;
import entity.bz_city;

//就业模块
@Controller//声明是控制层
@RequestMapping("bz_cityController")//包名
public class Bz_cityController {
	//DI注入
	@Resource(name="bz_cityService")
	private Bz_cityService cservice;
	
	//分页查询
	@RequestMapping("selectAll")//路径
	@ResponseBody
	public Bz_cityDto selectAll(int page,int rows){
		return cservice.selectPagingAll(page, rows);
	}
	
	//添加数据
	@RequestMapping("insertBz_city")//路径
	@ResponseBody
	public void insertBz_city(bz_city c){
		c.setCreateTime(new Date());//添加创建时间
		cservice.insertCity(c);
	}
}
