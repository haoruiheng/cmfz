package controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.Bz_clazzService;
import dto.Bz_clazzDto;
import entity.bz_clazz;

//班级模块
@Controller//声明是控制层
@RequestMapping("bz_clazzController")//包名
public class Bz_clazzController {
	//DI注入
	@Resource(name="bz_clazzService")
	private Bz_clazzService cservice;
	
	//分页查询
	@RequestMapping("selectAllBz_clazz")//路径
	@ResponseBody
	public Bz_clazzDto selectAll(int page,int rows){
		return cservice.selectBz_clazz(page, rows);
	}
	
	//添加数据
	@RequestMapping("insertBz_clazz")//路径
	@ResponseBody
	public void insertBz_city(bz_clazz c){
		cservice.insertClazz(c);
	}
}
