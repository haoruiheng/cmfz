package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.Bz_tagDao;
import dto.Bz_tagDto;
import entity.bz_tag;
//标签模块
@Service("bz_tagService")
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class Bz_tagServiceImpl implements Bz_tagService {
	//DI注入
	@Resource(name="bz_tagDao")
	private Bz_tagDao dao;
	
	//分页查询
	@Override
	public Bz_tagDto selectAll(int page, int rows) {
		// TODO Auto-generated method stub
		return new Bz_tagDto(dao.selectPagingAll(page, rows),dao.sumAll());
	}
	//添加数据
	@Override
	@Transactional
	public void insertTag(bz_tag t) {
		// TODO Auto-generated method stub
		dao.insertTag(t);
	}
	//根据 K 查询所有标签(学生|班级)
	@Override
	public List<bz_tag> selectTagAll(int tagType) {
		// TODO Auto-generated method stub
		return dao.selectTagAll(tagType);
	}

}
