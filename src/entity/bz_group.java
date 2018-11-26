package entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

//小组模块
public class bz_group {
	
	private Integer groupId;
	private String groupName;//小组名称
	@DateTimeFormat(pattern="yyyy-MM-dd")//输入格式
	@JSONField(format="yyyy-MM-dd")//输出格式
	private Date createTime;//创建时间
	private bz_clazz bz_clazz;//班级关系属性
	public bz_group() {
		super();
		// TODO Auto-generated constructor stub
	}
	public bz_group(Integer groupId, String groupName, Date createTime,
			entity.bz_clazz bz_clazz) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		this.createTime = createTime;
		this.bz_clazz = bz_clazz;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public bz_clazz getBz_clazz() {
		return bz_clazz;
	}
	public void setBz_clazz(bz_clazz bz_clazz) {
		this.bz_clazz = bz_clazz;
	}
	@Override
	public String toString() {
		return "bz_group [groupId=" + groupId + ", groupName=" + groupName
				+ ", createTime=" + createTime + ", bz_clazz=" + bz_clazz + "]";
	}
	
	
}
/*
 *create table bz_group(
	  groupId number(10) primary key,
	  groupName varchar2(40),
	  createTime Date,
	  bz_clazz number(10)--班级关系
	  --clzId number(10) references bz_clazz(clzId)   --和班级 多对一
	); 
 * 
 * */
