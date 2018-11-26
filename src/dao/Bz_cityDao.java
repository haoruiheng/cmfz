package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.bz_city;

//就业城市
public interface Bz_cityDao {
	//总行数
	int  sumAll();
	//分页查询所有
	List<bz_city> selectPagingAll(@Param("page")int page,@Param("rows")int rows );
	//添加数据
	void insertCity(bz_city c);
	//查所有
	List<bz_city> selectCityAll();
}
