package dto;

import java.util.List;

import entity.bz_group;

//小组 数据传输
public class Bz_groupDto {
	
	private List<bz_group> rows;//所有数据
	private Integer total;//总条数
	
	public Bz_groupDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bz_groupDto(List<bz_group> rows, Integer total) {
		super();
		this.rows = rows;
		this.total = total;
	}
	public List<bz_group> getRows() {
		return rows;
	}
	public void setRows(List<bz_group> rows) {
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
		return "Bz_groupDto [rows=" + rows + ", total=" + total + "]";
	}
	
	
}
