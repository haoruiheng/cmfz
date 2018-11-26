--就业城市（id 名称 创建时间）
create table bz_city(
  cityId number(10) primary key,
  cityName  varchar2(30),
  createTime date
)
create sequence bz_city_seq;
--查所有
select cityId,cityName,createTime from bz_city
--增加数据
insert into bz_city values(bz_city_seq.NEXTVAL,'北京',sysdate);
insert into bz_city values(bz_city_seq.NEXTVAL,'上海',sysdate);
insert into bz_city values(bz_city_seq.NEXTVAL,'广州',sysdate);
insert into bz_city values(bz_city_seq.NEXTVAL,'深圳',sysdate);
insert into bz_city values(bz_city_seq.NEXTVAL,'杭州',sysdate);
insert into bz_city values(bz_city_seq.NEXTVAL,'南京',sysdate);
--总行数
select count(*) from bz_city	
--分页查询
select tb2.*
	from (
		select tb1.*,rownum rn
		from (
			select cityId,cityName,createTime from bz_city
			order by cityId desc
		) tb1
		where rownum<= 1*3
	) tb2
where rn>(1-1)*3

--序列
select bz_city_seq.NEXTVAL from dual
