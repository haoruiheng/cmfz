package entity;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

//学生模块
public class bz_student {
	
	private Integer stuId;
	private String stuNname;//姓名
	
	@DateTimeFormat(pattern="yyyy-MM-dd")//输入格式
	@JSONField(format="yyyy-MM-dd")//输出格式
	private Date birthday;//生日
	
	private String phone;//电话
	
	@DateTimeFormat(pattern="yyyy-MM-dd")//输入格式
	@JSONField(format="yyyy-MM-dd")//输出格式
	private  Date createTime;//创建时间
	
	private bz_clazz clazzId;//班级 关系属性、
	private bz_group groupId;//小组关系属性
	private bz_city cityId;//就业城市 
	private List<bz_tag> tid;//标签 关系属性
	
	public bz_student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public bz_student(Integer stuId, String stuNname, Date birthday,
			String phone, Date createTime, bz_clazz clazzId, bz_group groupId,
			bz_city cityId, List<bz_tag> tid) {
		super();
		this.stuId = stuId;
		this.stuNname = stuNname;
		this.birthday = birthday;
		this.phone = phone;
		this.createTime = createTime;
		this.clazzId = clazzId;
		this.groupId = groupId;
		this.cityId = cityId;
		this.tid = tid;
	}

	public Integer getStuId() {
		return stuId;
	}

	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}

	public String getStuNname() {
		return stuNname;
	}

	public void setStuNname(String stuNname) {
		this.stuNname = stuNname;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public bz_clazz getClazzId() {
		return clazzId;
	}

	public void setClazzId(bz_clazz clazzId) {
		this.clazzId = clazzId;
	}

	public bz_group getGroupId() {
		return groupId;
	}

	public void setGroupId(bz_group groupId) {
		this.groupId = groupId;
	}

	public bz_city getCityId() {
		return cityId;
	}

	public void setCityId(bz_city cityId) {
		this.cityId = cityId;
	}

	public List<bz_tag> getTid() {
		return tid;
	}

	public void setTid(List<bz_tag> tid) {
		this.tid = tid;
	}

	@Override
	public String toString() {
		return "bz_student [stuId=" + stuId + ", stuNname=" + stuNname
				+ ", birthday=" + birthday + ", phone=" + phone
				+ ", createTime=" + createTime + ", clazzId=" + clazzId
				+ ", groupId=" + groupId + ", cityId=" + cityId + ", tid="
				+ tid + "]";
	}
	
	
}


/*
 *stuId number(10) primary key,
  stuNname varchar2(40),
  birthday date,
  phone varchar2(11),
  createTime Date,
  clazzId number(10),   --和班级 多对一
  groupId number(10),   --和小组 多对一
  cityId number(10)     --就业城市
 * 
 * */
