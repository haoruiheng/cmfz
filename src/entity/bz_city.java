package entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

//就业城市
public class bz_city {
	
	private Integer cityId;
	private String cityName;
	@DateTimeFormat(pattern="yyyy-MM-dd")//输入格式
	@JSONField(format="yyyy-MM-dd")//输出格式
	private Date createTime;//创建时间 
	public bz_city() {
		super();
		// TODO Auto-generated constructor stub
	}
	public bz_city(Integer cityId, String cityName, Date createTime) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
		this.createTime = createTime;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "bz_city [cityId=" + cityId + ", cityName=" + cityName
				+ ", createTime=" + createTime + "]";
	}
	
	
}
/*
 *  	cityId number(10) primary key,
		cityName  varchar2(30),
		createTime date
 * 
 * */