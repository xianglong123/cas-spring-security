# cas-spring-security

springboot 和 spring-security的整合


### 新增数据库用户
```sql
create user 'css'@'localhost' identified by 'css123';
create database css;
grant usage on css.* to 'css'@'localhost' with grant option;
grant select,insert,update,delete,create,drop on css.* to 'css'@'localhost' with grant option;
flush privileges;
```

### 新增表
```sql
create table sys_user
(
	id bigint auto_increment comment '主键',
	user_name varchar(64) null comment '用户名',
	nick_name varchar(64) null comment '昵称',
	password varchar(64) null comment '密码',
	status char null comment '账号状态（0正常，1停用）',
	email varchar(64) null comment '邮箱',
	phonenumber varchar(32) null comment '手机号',
	sex char null comment '用户性别（0男，1女，2未知）',
	avatar varchar(128) null comment '头像',
	user_type char null comment '用户类型（0管理员， 1普通用户）',
	create_by bigint null comment '创建人的用户id',
	create_time datetime null comment '创建时间',
	update_by bigint null comment '更新人',
	update_time datetime null comment '更新时间',
	del_flag int default 0 null comment '删除标示（0未删除，1已删除）',
	constraint sys_user_pk
		primary key (id)
)
comment '系统用户表';
```




