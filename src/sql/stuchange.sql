--学生转班记录表（id 转出班级 转出时间 转入班级 转入时间 创建时间）
create table bz_stuchange(
  chgId number(10) primary key,
  fromClzId number(10) references bz_clazz(clzId),
  fromTime date,
  toClzId number(10) references bz_clazz(clzId),
  toTime Date,
  createTime Date,
  stuId number(10) references bz_student(stuId)      --和学生 多对一
);
create sequence bz_stuchange_seq;