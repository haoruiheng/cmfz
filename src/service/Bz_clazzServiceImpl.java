package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.Bz_clazzDao;
import dto.Bz_clazzDto;
import entity.bz_clazz;
//班级模块
@Service("bz_clazzService")
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)//有事物也不执行|只读
public class Bz_clazzServiceImpl implements Bz_clazzService {
	//DI注入
	@Resource(name="bz_clazzDao")
	private Bz_clazzDao dao;
	//分页查询
	@Override
	public Bz_clazzDto selectBz_clazz(int page, int rows) {
		// TODO Auto-generated method stub
		return new Bz_clazzDto(dao.selectClazz(page, rows),dao.sumAll());
	}
	//添加数据
	@Override
	@Transactional
	public void insertClazz(bz_clazz c) {
		// TODO Auto-generated method stub
		dao.incertClazz(c);
	}
	//查询所有
	@Override
	public List<bz_clazz> selectClazzAll() {
		// TODO Auto-generated method stub
		return dao.selectClazzAll();
	}

}
