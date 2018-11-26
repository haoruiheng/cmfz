package entity;
//学生表-标签表--多对多
public class bz_student_tag {
	
	private Integer id;
	private bz_student sid;//学生关系属性
	private bz_tag tid;//标签关系属性
	public bz_student_tag() {
		super();
		// TODO Auto-generated constructor stub
	}
	public bz_student_tag(Integer id, bz_student sid, bz_tag tid) {
		super();
		this.id = id;
		this.sid = sid;
		this.tid = tid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public bz_student getSid() {
		return sid;
	}
	public void setSid(bz_student sid) {
		this.sid = sid;
	}
	public bz_tag getTid() {
		return tid;
	}
	public void setTid(bz_tag tid) {
		this.tid = tid;
	}
	@Override
	public String toString() {
		return "bz_student_tag [id=" + id + ", sid=" + sid + ", tid=" + tid
				+ "]";
	}
	
	
	
}
/*
 *	id  number(10) primary key,
	sid number(10), 
  	tid number(10)  
 * 
 * */
 