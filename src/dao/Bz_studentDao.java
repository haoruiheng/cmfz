package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.bz_student;

//学生模块
public interface Bz_studentDao {
	//分页查所有
	List<bz_student> selectStudent(@Param("page")int page,@Param("rows")int rows);
	//总条数
	int  sumAll();
	//查所有
	List<bz_student> selectStudentsAll();
	//添加数据
	void insertStudents(bz_student st);
}
