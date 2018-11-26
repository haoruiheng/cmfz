package service;

import dto.Bz_studentDto;
import entity.bz_student;

//学生模块
public interface Bz_studentService {
	//分页查所有
	Bz_studentDto selectStudent(int page,int rows);
	//添加数据
	void insertStudent(bz_student st,Integer[] ids);
}
