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
CREATE TABLE `resources` (
                             `id` int(11) NOT NULL AUTO_INCREMENT,
                             `pattern` varchar(255) DEFAULT NULL,
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `role` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `name` varchar(32) DEFAULT NULL,
                        `description` varchar(255) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


CREATE TABLE `role_resource` (
                                 `id` int(11) NOT NULL AUTO_INCREMENT,
                                 `role_id` int(11) DEFAULT NULL,
                                 `resource_id` int(11) DEFAULT NULL,
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `user` (
                        `id` int(64) NOT NULL AUTO_INCREMENT,
                        `user_name` varchar(32) DEFAULT NULL,
                        `password` varchar(255) DEFAULT NULL,
                        `enable` tinyint(4) DEFAULT NULL,
                        `locked` tinyint(4) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `user_role` (
                             `id` int(11) NOT NULL AUTO_INCREMENT,
                             `user_id` int(11) DEFAULT NULL,
                             `role_id` int(11) DEFAULT NULL,
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
```


