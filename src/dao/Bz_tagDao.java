package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.bz_tag;

//标签模块
public interface Bz_tagDao {
	//分页查
	List<bz_tag> selectPagingAll(@Param("page")int page,@Param("rows")int rows );
	//总条数
	int  sumAll();
	//添加数据
	void insertTag(bz_tag t);
	//根据 K 查询所有标签(学生|班级)
	List<bz_tag> selectTagAll(int tagType);
}
