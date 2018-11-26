package dto;

import java.util.List;

import entity.bz_tag;

//标签模块
public class Bz_tagDto {
	
	private List<bz_tag> rows;//所有数据
	private Integer total;//总条数
	
	
	public Bz_tagDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bz_tagDto(List<bz_tag> rows, Integer total) {
		super();
		this.rows = rows;
		this.total = total;
	}
	public List<bz_tag> getRows() {
		return rows;
	}
	public void setRows(List<bz_tag> rows) {
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
		return "Bz_tagDto [rows=" + rows + ", total=" + total + "]";
	}
	
	
	
}
