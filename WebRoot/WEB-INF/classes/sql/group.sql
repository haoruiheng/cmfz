--小组（id 名称 创建时间 所属班级）
	create table bz_group(
	  groupId number(10) primary key,
	  groupName varchar2(40),
	  createTime Date,
	  bz_clazz number(10)--班级关系
	  --clzId number(10) references bz_clazz(clzId)   --和班级 多对一
	);
--生成序列
	create sequence bz_group_seq;
--查询序列
	select bz_group_seq.NEXTVAL from dual
--查询所有
	select groupId,groupName,createTime,bz_clazz from bz_group
--根据班级id-查询小组
	select groupId,groupName,createTime,bz_clazz from bz_group where bz_clazz=8
--添加数据 8-9-10-12
	insert into bz_group  values(bz_group_seq.nextval,'1组',sysdate,10);
	insert into bz_group  values(bz_group_seq.nextval,'2组',sysdate,10);
	insert into bz_group  values(bz_group_seq.nextval,'3组',sysdate,10);
	insert into bz_group  values(bz_group_seq.nextval,'1组',sysdate,8);
	insert into bz_group  values(bz_group_seq.nextval,'2组',sysdate,8);
	insert into bz_group  values(bz_group_seq.nextval,'3组',sysdate,8);
	insert into bz_group  values(bz_group_seq.nextval,'1组',sysdate,9);
	insert into bz_group  values(bz_group_seq.nextval,'2组',sysdate,9);
	insert into bz_group  values(bz_group_seq.nextval,'3组',sysdate,9);
	insert into bz_group  values(bz_group_seq.nextval,'1组',sysdate,12);
	insert into bz_group  values(bz_group_seq.nextval,'2组',sysdate,12);
	insert into bz_group  values(bz_group_seq.nextval,'3组',sysdate,12);
	
--数据总条数
	select count(*) from bz_group	
--表连接查询(小组-班级-标签)

	select g.groupId,g.groupName,g.createTime,c.clzId,c.clzName,c.tagId,c.tagName,c.tagType from bz_group g
	join (	select n.clzId,n.clzName,n.createTime,y.tagId,y.tagName,y.tagType from bz_clazz n
			join bz_tag y  
			on n.tagId = y.tagId
		 )c 
	on g.bz_clazz = c.clzId order by g.groupId desc

--班级表-标签表 连接
	(select n.clzId,n.clzName,n.createTime,y.tagName,y.tagType from bz_clazz n
	join bz_tag y  
	on n.tagId = y.tagId)c 
