package dto;

import java.util.List;

import entity.bz_city;

//就业城市
public class Bz_cityDto {
	
	private List<bz_city> rows;//所有数据
	private Integer total;//总条数
	
	public Bz_cityDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bz_cityDto(List<bz_city> rows, Integer total) {
		super();
		this.rows = rows;
		this.total = total;
	}
	public List<bz_city> getRows() {
		return rows;
	}
	public void setRows(List<bz_city> rows) {
		this.rows = rows;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Bz_cityDto [rows=" + rows + ", total=" + total + "]";
	}
	
	
}
