package dto;

import java.util.List;

import entity.bz_clazz;

//班级模块  数据传输
public class Bz_clazzDto {
	
	private List<bz_clazz> rows;//所有数据
	private Integer total;//总条数
	
	public Bz_clazzDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bz_clazzDto(List<bz_clazz> rows, Integer total) {
		super();
		this.rows = rows;
		this.total = total;
	}
	public List<bz_clazz> getRows() {
		return rows;
	}
	public void setRows(List<bz_clazz> rows) {
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
		return "Bz_clazzDto [rows=" + rows + ", total=" + total + "]";
	}
	
	
}
