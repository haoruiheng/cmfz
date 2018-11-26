package service;

import java.util.List;

import dto.Bz_tagDto;
import entity.bz_tag;

//标签
public interface Bz_tagService {
	//查所有
	Bz_tagDto selectAll(int page,int rows);
	//添加数据
	void insertTag(bz_tag t);
	//根据 K 查询所有标签(学生|班级)
	List<bz_tag> selectTagAll(int tagType);
}
