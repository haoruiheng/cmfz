--标签（id 名称 类型 创建时间）
create table bz_tag(
  tagId number(10) primary key,
  tagName  varchar2(30),
  tagType number(1), --学生标签0  班级标签1
  createTime date
)
--增加序列
create sequence bz_tag_seq;
--查询序列
select bz_tag_seq.NEXTVAL from dual
--查所以
select tagId,tagName,tagType,createTime from bz_tag
--根据 K 查询标签
select tagId,tagName,tagType,createTime from bz_tag where tagType=1

--分页查询
select tb2.*
	from (
		select tb1.*,rownum rn
		from (
			select tagId,tagName,tagType,createTime from bz_tag
			order by tagId desc
		) tb1
		where rownum<= 1*3
	) tb2
where rn>(1-1)*3
--查询总行数
select count(*) from bz_tag	
--添加数据
insert into bz_tag  values(bz_tag_seq.nextval,'倔强一班',1,sysdate);
insert into bz_tag  values(bz_tag_seq.nextval,'秩序二班',1,sysdate);
insert into bz_tag  values(bz_tag_seq.nextval,'荣耀三班',1,sysdate);
insert into bz_tag  values(bz_tag_seq.nextval,'尊贵四班',1,sysdate);
insert into bz_tag  values(bz_tag_seq.nextval,'学霸',0,sysdate);
insert into bz_tag  values(bz_tag_seq.nextval,'学渣',0,sysdate);
insert into bz_tag  values(bz_tag_seq.nextval,'女神',0,sysdate);
insert into bz_tag  values(bz_tag_seq.nextval,'男神',0,sysdate);

--删除
delete  from  bz_tag where tagId=4