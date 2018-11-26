package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.bz_clazz;

//班级模块
public interface Bz_clazzDao {
	//分页查所有
	List<bz_clazz> selectClazz(@Param("page")int page,@Param("rows")int rows );
	//添加数据
	void incertClazz(bz_clazz c);
	//总条数
	int  sumAll();
	//查询所有
	List<bz_clazz> selectClazzAll();
}
