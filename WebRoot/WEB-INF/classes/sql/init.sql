--学生（id 名称 出生日期 电话号码 创建时间 所属班 所属组 就业城市）
	create table bz_student(
	  stuId number(10) primary key,
	  stuNname varchar2(40),
	  birthday date,
	  phone varchar2(11),
	  createTime Date, 		--创建时间
	  clazzId number(10),   --和班级 多对一
	  groupId number(10),   --和小组 多对一
	  cityId number(10)     --和就业城市 多对一
	  --clazzId number(10) references bz_clazz(clzId),      --和班级 多对一
	  --groupId number(10) references bz_group(groupId),    --和小组 多对一
	  --cityId number(10) references bz_city(cityId)        --和就业城市 多对一
	);
	create sequence bz_student_seq;
--查所有
	select * from bz_student
--取出序列
		select bz_student_seq.NEXTVAL from dual
--总条数
	select count(*) from bz_student	
--添加数据
	insert into bz_student values(bz_student_seq.NEXTVAL,'王山而',sysdate,'90876543211',sysdate,8,22,1)
	insert into bz_student values(bz_student_seq.NEXTVAL,'戴少',null,null,null,null,null,null)
	
--表连接查询  学生-班级-小组-就业城市
	
		select s.stuId,s.stuNname,s.birthday,s.phone,s.createTime,
				cl.clzName,gr.groupName,ci.cityName,t.tagName,t.tagType
		from bz_student s  left 
		join bz_clazz cl on s.clazzId = cl.clzId left
		join bz_group gr on s.groupId = gr.groupId left
		join bz_city ci  on s.cityId = ci.cityId left
		join bz_student_tag st on s.stuId = st.sid left	
		join bz_tag t on st.tid = t.tagId
		order by s.stuId desc
		
	
--关联 查所有 标签  学生--- 5张表
		select tb2.*
			from (
				select tb1.*
				from (
					select  rn,s.stuId,s.stuNname,s.birthday,s.phone,s.createTime,
						cl.clzName,gr.groupName,ci.cityName,st.tid,t.tagName,t.tagType
					from (select ss.*,rownum rn  from  bz_student ss)s left 
					join bz_clazz cl on s.clazzId = cl.clzId 
					join bz_group gr on s.groupId = gr.groupId 
					join bz_city ci  on s.cityId = ci.cityId 
					join bz_student_tag st on s.stuId = st.sid 	
					join bz_tag t on st.tid = t.tagId
					order by s.stuId desc
				) tb1
				where rn<= 1*3
			) tb2
		where rn>(1-1)*3
	
--查所有
		select tb1.*
		from (
			select  rn,s.stuId,s.stuNname,s.birthday,s.phone,s.createTime,
				cl.clzName,cl.clzId,
				gr.groupName,gr.groupId,
				ci.cityName,ci.cityId,
				st.tid,
				t.tagId,t.tagName,t.tagType
			from (select ss.*,rownum rn  from  bz_student ss)s left 
			join bz_clazz cl on s.clazzId = cl.clzId 
			join bz_group gr on s.groupId = gr.groupId 
			join bz_city ci  on s.cityId = ci.cityId 
			join bz_student_tag st on s.stuId = st.sid 	
			join bz_tag t on st.tid = t.tagId
			order by s.stuId desc
		) tb1 
--学生标签关系表(学生和标签 多对多)
	create table bz_student_tag(
		id  number(10) primary key,
		sid number(10), 
	  	tid number(10) 
	  	--sid number(10) references bz_student(stuId),   
	  	--tid number(10) references bz_tag(tagId),
	  	--primary key (sid,tid)
	);
	
--添加序列
	create sequence bz_student_tag_seq;
--查所有
	select * from bz_student_tag order by sid desc
--获得序列
	select bz_student_tag_seq.NEXTVAL from dual
--添加数据
	insert into bz_student_tag values(bz_student_tag_seq.NEXTVAL,5,19)
--删除表
	drop  table bz_student_tag 
	
	
	
	
	
	
	
--用户表（id 帐号 密码 类型 注册时间）
	create table bz_user(
	  id number(10) primary key,
	  userName  varchar2(30) unique,
	  password varchar2(30),
	  type number(1),  --普通用户0   管理员1
	  regTime date
	)
	create sequence bz_user_seq;
	insert into bz_user values(bz_user_seq.nextval, 'admin', '123456', 1, sysdate);
	insert into bz_user values(bz_user_seq.nextval, 'tom', '123456', 0, sysdate);
	commit;
	
	
	
	
	
	
	
	
	
