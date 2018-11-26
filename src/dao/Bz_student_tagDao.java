package dao;

import org.apache.ibatis.annotations.Param;
//关系表
//学生查所有
public interface Bz_student_tagDao{
	//学生添加标签
	void insertstudent_tag(@Param("studentId")int studentId,@Param("tagId")int tagId);
}
