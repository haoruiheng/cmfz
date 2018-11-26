package entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

//班级模块
public class bz_clazz {
	
	private Integer  clzId;
	private String clzName;//班级
	@DateTimeFormat(pattern="yyyy-MM-dd")//输入格式
	@JSONField(format="yyyy-MM-dd")//输出格式
	private Date createTime;
	private bz_tag tagId;//标签  关系属性
	public bz_clazz() {
		super();
		// TODO Auto-generated constructor stub
	}
	public bz_clazz(Integer clzId, String clzName, Date createTime, bz_tag tagId) {
		super();
		this.clzId = clzId;
		this.clzName = clzName;
		this.createTime = createTime;
		this.tagId = tagId;
	}
	public Integer getClzId() {
		return clzId;
	}
	public void setClzId(Integer clzId) {
		this.clzId = clzId;
	}
	public String getClzName() {
		return clzName;
	}
	public void setClzName(String clzName) {
		this.clzName = clzName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public bz_tag getTagId() {
		return tagId;
	}
	public void setTagId(bz_tag tagId) {
		this.tagId = tagId;
	}
	@Override
	public String toString() {
		return "bz_clazz [clzId=" + clzId + ", clzName=" + clzName
				+ ", createTime=" + createTime + ", tagId=" + tagId + "]";
	}
	
	
}
/*
 * create table bz_clazz(
  clzId number(10) primary key,
  clzName  varchar2(30),
  createTime date,
  tagId number(10)
  --tagId number(10) references bz_tag(tagId)   --和标签 多对一
)
 * 
 * 
 * */
