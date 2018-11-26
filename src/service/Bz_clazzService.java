package service;

import java.util.List;

import dto.Bz_clazzDto;
import entity.bz_clazz;

//班级模块
public interface Bz_clazzService {
	//分页查询
	Bz_clazzDto selectBz_clazz(int page,int rows);
	//添加数据
	void insertClazz(bz_clazz c);
	//查询所有
	List<bz_clazz> selectClazzAll();

}
