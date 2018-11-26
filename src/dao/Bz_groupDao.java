package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.bz_group;

//小组模块
public interface Bz_groupDao {
	//数据总条数
	int sumAll();
	//分页查询
	List<bz_group> selectGroup(@Param("page")int page,@Param("rows")int rows);
	//添加数据
	void insertGroup(bz_group g);
	////根据班级-查所有
	List<bz_group> selectGroupAll(int clazzId);
	
}
