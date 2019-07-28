use db_example;
drop table if exists `db_example`.`t_user`;
drop table if exists `db_example`.`t_role`;
drop table if exists `db_example`.`t_user_role`;

create table `t_user`(
	`ID` INT(10) NOT NULL auto_increment,
    `LOGIN_NAME` varchar(20),
    `NAME` varchar(20),
    `PASSWORD` varchar(100),
    primary key(`ID`)
)engine=InnoDB auto_increment=1 charset = utf8;

create table `t_role`(
	`ID` INT(10) NOT NULL auto_increment,
    `NAME` varchar(20),
    primary key(`ID`)
)engine=InnoDB auto_increment=10 charset = utf8;

create table `t_user_role`(
	`ID` INT(10) NOT NULL auto_increment,
    `USER_ID` INT(10),
    `ROLE_ID` INT(10),
    constraint `FK_USER_ID` foreign key(`USER_ID`) references `t_user`(`ID`)
    ON delete no action ON update no action,
    constraint `FK_ROLE_ID` foreign key(`ROLE_ID`) references `t_role`(`ID`)
    ON delete no action ON update no action,
    primary key(`ID`)
)ENGINE=InnoDB auto_increment=1 charset = utf8;

INSERT INTO `t_user`(`LOGIN_NAME`,`NAME`,`PASSWORD`) VALUES('Admin','Admin','$2a$10$7fJ8Y2A4iksDMMpfdWih/.hNGNHXQ02W4KZDsndCg9eR//uH3Ka/O');
INSERT INTO `t_role`(`NAME`) values('ROLE_ADMIN'),('ROLE_DBA'),('ROLE_USER');
INSERT INTO `t_user_role`(`USER_ID`,`ROLE_ID`) VALUES('1','10'),('1','11'),('1','12');
