package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.Bz_groupDao;
import dto.Bz_groupDto;
import entity.bz_group;
//小组模块
@Service("bz_groupService")
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)//查询事物
public class Bz_groupServiceImpl implements Bz_groupService {
	
	@Resource(name="bz_groupDao")//DI注入
	private Bz_groupDao groupDao;
	
	//分页查
	@Override
	public Bz_groupDto selectGroup(int page, int rows) {
		// TODO Auto-generated method stub
		return new Bz_groupDto(groupDao.selectGroup(page, rows),groupDao.sumAll());
	}
	//添加数据
	@Override
	@Transactional
	public void insertGroup(bz_group g) {
		// TODO Auto-generated method stub
		groupDao.insertGroup(g);
	}
	//查所有
	@Override
	public List<bz_group> selectGroupAll(int clazzId) {
		// TODO Auto-generated method stub
		return groupDao.selectGroupAll(clazzId);
	}

}
