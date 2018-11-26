package entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

//标签模块
public class bz_tag {
	private Integer tagId;
	private String tagName;//标签
	private Integer tagType;//0学生/1班级
	@DateTimeFormat(pattern="yyyy-MM-dd")//输入格式
	@JSONField(format="yyyy-MM-dd")//输出格式
	private Date createTime;//创建时间
	public bz_tag() {
		super();
		// TODO Auto-generated constructor stub
	}
	public bz_tag(Integer tagId, String tagName, Integer tagType,
			Date createTime) {
		super();
		this.tagId = tagId;
		this.tagName = tagName;
		this.tagType = tagType;
		this.createTime = createTime;
	}
	public Integer getTagId() {
		return tagId;
	}
	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public Integer getTagType() {
		return tagType;
	}
	public void setTagType(Integer tagType) {
		this.tagType = tagType;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "bz_tag [tagId=" + tagId + ", tagName=" + tagName + ", tagType="
				+ tagType + ", createTime=" + createTime + "]";
	}
	
	
}
/*
 * create table bz_tag(
  tagId number(10) primary key,
  tagName  varchar2(30),
  tagType number(1), --学生标签0  班级标签1
  createTime date
)
 * 
 */