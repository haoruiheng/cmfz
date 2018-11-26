package service;

import java.util.List;

import dto.Bz_cityDto;
import entity.bz_city;

//就业城市
public interface Bz_cityService {
	//分页查询
	Bz_cityDto selectPagingAll(int page,int rows);
	//添加数据
	void insertCity(bz_city c);
	//查询所有
	List<bz_city> selectCityAll();

}
