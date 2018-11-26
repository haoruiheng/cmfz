package controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.Bz_clazzService;
import service.Bz_groupService;
import dto.Bz_groupDto;
import entity.bz_clazz;
import entity.bz_group;

//小组模块
@Controller
@RequestMapping("bz_groupController")
public class Bz_groupController {
	//DI注入
	@Resource(name="bz_groupService")
	private Bz_groupService groupService;
	@Resource(name="bz_clazzService")
	private Bz_clazzService cservice;
	
	//分页查
	@RequestMapping("selectGroup")
	@ResponseBody
	public Bz_groupDto selectGroup(int page,int rows){
		return groupService.selectGroup(page, rows);
	}
	//添加数据
	@RequestMapping("insertGroup")
	@ResponseBody
	public void insertGroup(bz_group g,int clzId){
		bz_clazz clazz = new bz_clazz();
		clazz.setClzId(clzId);
		g.setBz_clazz(clazz);
		groupService.insertGroup(g);
	}
	//查所有班级
	@RequestMapping("selectClassAll")
	@ResponseBody
	public List<bz_clazz> selectClassAll(){
		return cservice.selectClazzAll();
	}
	
}
