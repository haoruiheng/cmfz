package service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import dto.Bz_groupDto;
import entity.bz_group;

//小组模块
public interface Bz_groupService {
	//分页查
	Bz_groupDto selectGroup(@Param("page")int page,@Param("rows")int rows);
	//添加数据
	void insertGroup(bz_group g);
	//根据id查所有
	List<bz_group> selectGroupAll(int clazzId);
}
