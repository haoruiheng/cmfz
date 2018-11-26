package dto;

import java.util.List;

import entity.bz_student;

//学生模块
public class Bz_studentDto {
	
	private List<bz_student> rows;//所有数据
	private Integer total;//总条数
	
	public Bz_studentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bz_studentDto(List<bz_student> rows, Integer total) {
		super();
		this.rows = rows;
		this.total = total;
	}
	public List<bz_student> getRows() {
		return rows;
	}
	public void setRows(List<bz_student> rows) {
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
		return "bz_studentDto [rows=" + rows + ", total=" + total + "]";
	}
	
	
	
}
