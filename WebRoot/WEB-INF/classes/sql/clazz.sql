--班级（id 名称 创建时间 所属标签）
	create table bz_clazz(
	  clzId number(10) primary key,
	  clzName  varchar2(30),
	  createTime date,
	  tagId number(10)
	  --tagId number(10) references bz_tag(tagId)   --和标签 多对一
	)
--生成序列
	create sequence bz_clazz_seq;
--查询序列
	select bz_clazz_seq.NEXTVAL from dual
	
--查询所有
	select clzId,clzName,createTime,tagId from bz_clazz
--总行数
	select count(*) from bz_clazz	
--添加数据
	insert into bz_clazz  values(bz_clazz_seq.nextval,'1班',sysdate,10)
	insert into bz_clazz  values(bz_clazz_seq.nextval,'2班',sysdate,11)
	insert into bz_clazz  values(bz_clazz_seq.nextval,'3班',sysdate,12)
	insert into bz_clazz  values(bz_clazz_seq.nextval,'4班',sysdate,13)
--删除
	delete from bz_clazz where clzId=21
--分页查询
	select tb2.*
		from (
			select tb1.*,rownum rn
			from (
				select clzId,clzName,createTime,tagId from bz_clazz
				order by clzId desc
			) tb1
		where rownum<= 1*3
	) tb2
--表连接、
	select n.clzId,n.clzName,n.createTime,y.tagName,y.tagType from bz_clazz n
	join bz_tag y  
	on n.tagId = y.tagId order by n.clzId desc

select tb2.*
		from (
			select tb1.*,rownum rn
			from (
				select n.clzId,n.clzName,n.createTime,y.tagName,y.tagType from bz_clazz n
				join bz_tag y  
				on n.tagId = y.tagId order by n.clzId desc
			) tb1
		where rownum<= 1*3
	) tb2