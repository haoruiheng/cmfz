package service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.Bz_studentDao;
import dao.Bz_student_tagDao;
import dto.Bz_studentDto;
import entity.bz_student;
//学生模块
@Service("bz_studentService")
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class Bz_studentServiceImpl implements Bz_studentService {
	//DI注入
	@Resource(name="bz_studentDao")//学生Dao
	private Bz_studentDao studentDao;
	@Resource(name="bz_student_tagDao")//学生关系表Dao
	private Bz_student_tagDao student_tagDao;
	
	//分页查所有
	@Override
	public Bz_studentDto selectStudent(int page, int rows) {
		// TODO Auto-generated method stub
		return new Bz_studentDto(studentDao.selectStudent(page, rows),studentDao.sumAll());
	}
	//添加数据
	@Override
	public void insertStudent(bz_student st, Integer[] ids) {
		// TODO Auto-generated method stub
		studentDao.insertStudents(st);
		//学生ID
		int studentId=st.getStuId();
		for (Integer integer : ids) {
			student_tagDao.insertstudent_tag(studentId, integer);
		}
	}

}
