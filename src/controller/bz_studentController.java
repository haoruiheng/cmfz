package controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.Bz_cityService;
import service.Bz_clazzService;
import service.Bz_groupService;
import service.Bz_studentService;
import service.Bz_tagService;
import dto.Bz_studentDto;
import entity.bz_city;
import entity.bz_clazz;
import entity.bz_group;
import entity.bz_student;
import entity.bz_tag;

//学生模块
@Controller
@RequestMapping("bz_studentController")
public class bz_studentController {
	
	//DI注入
	@Resource(name="bz_studentService")//学生业务
	private Bz_studentService studentService;
	@Resource(name="bz_cityService")//就业城市业务
	private Bz_cityService ciservice;
	@Resource(name="bz_clazzService")//班级业务
	private Bz_clazzService clservice;
	@Resource(name="bz_tagService")//标签业务
	private Bz_tagService tagService;
	@Resource(name="bz_groupService")//小组业务
	private Bz_groupService groupService;
	
	//分页查所有
	@RequestMapping("selectService")
	@ResponseBody
	public Bz_studentDto selectService(int page,int rows){
		return studentService.selectStudent(page, rows);
	}
	//添加数据
	@RequestMapping("insertService")
	@ResponseBody
	public void insertService(bz_student st,Integer[] ids){
		studentService.insertStudent(st, ids);
	}
	//查询 所有班级  
	@RequestMapping("selectClazzAll")
	@ResponseBody
	public List<bz_clazz> selectClazzAll(){
		return clservice.selectClazzAll();
	}
	//根据班级查询小组
	@RequestMapping("selectGroupAll")
	@ResponseBody
	List<bz_group> selectGroupAll(int clazzId){
		return groupService.selectGroupAll(clazzId);
	}
	//查询就业城市
	@RequestMapping("selectCityAll")
	@ResponseBody
	public List<bz_city> selectCityAll(){
		return ciservice.selectCityAll();
	}
	//查询所有学生标签
	@RequestMapping("selectTagAll")
	@ResponseBody
	List<bz_tag> selectTagAll(int tagType){
		return tagService.selectTagAll(tagType);
	}
}
