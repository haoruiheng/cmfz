package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.Bz_cityDao;
import dto.Bz_cityDto;
import entity.bz_city;
//就业城市
@Service("bz_cityService")
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)//查询事物
public class Bz_cityServiceImpl implements Bz_cityService {
	//DI注入
	@Resource(name="bz_cityDao")
	private Bz_cityDao cdao;
	
	@Override
	public Bz_cityDto selectPagingAll(int page, int rows) {
		// TODO Auto-generated method stub
		return new Bz_cityDto(cdao.selectPagingAll(page, rows),cdao.sumAll());
	}

	@Override
	@Transactional
	public void insertCity(bz_city c) {
		// TODO Auto-generated method stub
		cdao.insertCity(c);
	}
	//查询所有就业城市
	@Override
	public List<bz_city> selectCityAll() {
		// TODO Auto-generated method stub
		return cdao.selectCityAll();
	}

}
