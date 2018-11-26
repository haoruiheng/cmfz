package controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.Bz_tagService;
import dto.Bz_tagDto;
import entity.bz_tag;

//标签模块
@Controller//声明是控制层
@RequestMapping("bz_tagController")//包名
public class Bz_tagController {
	//DI注入
	@Resource(name="bz_tagService")
	private Bz_tagService tService;
	//分页查询
	@RequestMapping("selectAllBz_tag")//路径
	@ResponseBody
	public Bz_tagDto selectAllBz_tag(int page,int rows){
		return tService.selectAll(page, rows);
	}
	
	//添加数据
	@RequestMapping("insertBz_tag")//路径
	@ResponseBody
	public void insertBz_tag(bz_tag t){
		tService.insertTag(t);
	}
}
