use db_example;
drop table if exists `db_example`.`T_PLN_STOP`;
drop table if exists `db_example`.`T_ACT_STOP`;
drop table if exists `db_example`.`T_NOTIFICATION`;
drop table if exists `db_example`.`T_EXE_EVENT`;
drop table if exists `db_example`.`T_TOUR_ITEM`;
drop table if exists `db_example`.`T_TOUR`;
drop table if exists `db_example`.`T_SCH_STOP`;
drop table if exists `db_example`.`T_SCHEDULE`;
drop table if exists `db_example`.`T_RESV_ITEM`;
drop table if exists `db_example`.`T_RESERVATION`;
drop table if exists `db_example`.`T_DRIVER`;
drop table if exists `db_example`.`T_ASSET`;
drop table if exists `db_example`.`T_LOCATION`;
drop table if exists `db_example`.`T_ASSET_TYPE`;
drop table if exists `db_example`.`T_EVENT_CODE`;
drop table if exists `db_example`.`T_RESV_TYPE`;
drop table if exists `db_example`.`T_TOUR_TYPE`;
drop table if exists `db_example`.`T_CUSTOMER`;
DROP TABLE if exists `db_example`.`T_SCH_TYPE`;

create table `T_SCH_TYPE`(
	`SCH_TYPE` VARCHAR(10) NOT NULL,
    `TEXT` VARCHAR(30),
	`CREATED_BY` VARCHAR(20),
    `CREATED_ON` datetime,
    primary key (`SCH_TYPE`)
)engine=InnoDB DEFAULT CHARSET=utf8;

create table `T_RESV_TYPE`(
	`RESV_TYPE` VARCHAR(10) NOT NULL,
    `TEXT` VARCHAR(30),
	`CREATED_BY` VARCHAR(20),
    `CREATED_ON` datetime,
    primary key (`RESV_TYPE`)
)engine=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `T_RESV_TYPE` VALUES('NORM','普通预留','Admin',now());
INSERT INTO `T_RESV_TYPE` VALUES('ADV1','客户预留','Admin',now());

create table `T_TOUR_TYPE`(
	`TOUR_TYPE` VARCHAR(10) NOT NULL,
    `TEXT` VARCHAR(30),
	`CREATED_BY` VARCHAR(20),
    `CREATED_ON` datetime,
    primary key (`TOUR_TYPE`)
)engine=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `T_TOUR_TYPE` VALUES('LONG','短途','Admin',now());
INSERT INTO `T_TOUR_TYPE` VALUES('SHORT','长途','Admin',now());

create table `T_CUSTOMER`(
	`CUST_ID` varchar(20) not null,
    `TYPE` VARCHAR(10),
    `NAME` VARCHAR(50),
    `ADDRESS` VARCHAR(50),
	`CREATED_BY` VARCHAR(20),
    `CREATED_ON` datetime,
    `DEL` VARCHAR(1),
    primary key (`CUST_ID`,`TYPE`)
)engine=InnoDB DEFAULT CHARSET=utf8;

insert into `T_CUSTOMER`(`CUST_ID`,`TYPE`,`NAME`,`ADDRESS`) VALUES('CUST1','GROUP1','中国移动上海分公司','上海市北京西路1000号');
insert into `T_CUSTOMER`(`CUST_ID`,`TYPE`,`NAME`,`ADDRESS`) VALUES('CUST2','GROUP1','中国联通上海分公司','上海市南京东路2000号');

create table `T_LOCATION`(
	`LOC_ID` VARCHAR(20) NOT NULL,
    `ADDRESS` VARCHAR(100),
    `LAT` VARCHAR(10),
    `LNG` VARCHAR(10),
    `CITY` VARCHAR(10),
    `PROVINCE` VARCHAR(10),
    `DISTRICT` VARCHAR(20),
    `POSTAL_CODE` VARCHAR(10),
    `CREATED_BY` VARCHAR(20),
    `CREATED_ON` datetime,
    `DEL` VARCHAR(1),
    primary KEY(`LOC_ID`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `db_example`.`t_location`
(`LOC_ID`,
`ADDRESS`,
`LAT`,
`LNG`,
`CITY`,
`PROVINCE`,
`DISTRICT`,
`POSTAL_CODE`,
`DEL`)
VALUES
('LOC1',
'上海市人民广场',
'31.228477',
'121.475476',
'上海',
'上海',
'黄浦区',
'200000',
''),('LOC2',
'上海西站',
'31.262966',
'121.403979',
'上海',
'上海',
'普陀区',
'200000',
'');

CREATE TABLE `T_ASSET_TYPE`(
    `ASSET_TYPE` VARCHAR(10) NOT NULL,
    `ASSET_TEXT` VARCHAR(30),
    `CREATED_BY` VARCHAR(20),
    `CREATED_ON` datetime,
    `DEL` VARCHAR(1),
    primary key(`ASSET_TYPE`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO `db_example`.`t_asset_type`
(`ASSET_TYPE`,
`ASSET_TEXT`,
`DEL`)
VALUES
('10T',
'卡车10吨',
''),('20T',
'卡车20吨',
'');

CREATE TABLE `T_ASSET`(
	`ASSET_ID` VARCHAR(20) not NULL,
    `ASSET_TYPE` VARCHAR(10),
    `PLATENUMBER` VARCHAR(10),
    `MAKE` VARCHAR(20),
    `MODEL` varchar(20),
    `VIN`  VARCHAR(50),
    `YEAR` year,
    `HARDWARE` VARCHAR(50),
    `LOCATION` varchar(20),
    `CREATED_BY` VARCHAR(20),
    `CREATED_ON` datetime,
    `DEL` VARCHAR(1),
    primary key(`ASSET_ID`),
    constraint `fk_asset_type` foreign key(`ASSET_TYPE`) references `T_ASSET_TYPE`(`ASSET_TYPE`)
    ON delete no action ON update no action,
    constraint `fk_location` foreign key(`LOCATION`) references `T_LOCATION`(`LOC_ID`)
    ON delete no action ON update no action
)ENGINE=INNODB DEFAULT CHARSET=utf8;
INSERT INTO `db_example`.`t_asset`
(`ASSET_ID`,
`ASSET_TYPE`,
`PLATENUMBER`,
`MAKE`,
`MODEL`,
`VIN`,
`YEAR`,
`HARDWARE`,
`LOCATION`,
`DEL`)
VALUES
('TRUCK01',
'10T',
'沪A 87659',
'奔驰',
'Actros重卡',
'VIN1234567890',
'2019',
'OBD1',
'LOC1',
''),('TRUCK02',
'10T',
'沪A 66688',
'奔驰',
'Actros重卡',
'VIN1234567891',
'2017',
'OBD2',
'LOC1',
'');

CREATE TABLE `T_DRIVER`(
	`DRIVER_ID` VARCHAR(20) NOT NULL,
    `NAME` VARCHAR(10),
    `TEL`  VARCHAR(15),
    `LOCATION` varchar(20),
    `CREATED_BY` VARCHAR(20),
    `CREATED_ON` datetime,
    `DEL`  VARCHAR(1),
    primary key(`DRIVER_ID`),
    constraint `fk_driver_loc` foreign key(`LOCATION`) references `T_LOCATION`(`LOC_ID`)
    ON delete no action ON update no action
)ENGINE=INNODB DEFAULT CHARSET=utf8;
INSERT INTO `db_example`.`t_driver`
(`DRIVER_ID`,
`NAME`,
`TEL`,
`LOCATION`,
`DEL`)
VALUES
('DRIVER1',
'小明',
'188 8888 8888',
'LOC1',
''),('DRIVER2',
'小李',
'188 8888 8898',
'LOC1',
'');

create table `T_TOUR` (
	`TOURID` VARCHAR(20) NOT NULL,
    `TOUR_TYPE` VARCHAR(10),
    `SOURCE_LOCID` VARCHAR(20),
    `DEST_LOCID` VARCHAR(20),
    `VEHICLE_ID` VARCHAR(20),
    `DRIVER_ID` VARCHAR(20),
    `SHIP_TO`  VARCHAR(20),
    `PLAN_DEPART` datetime,
    `PLAN_ARR`   datetime,
    `ACT_DEPART` datetime,
    `ACT_ARR`    datetime,
    `ETA`	     datetime,
    `EXE_STATUS`  VARCHAR(2),
    `CUST_ID` VARCHAR(20),
    `CREATED_ON` datetime,
    `CREATED_BY` VARCHAR(20),
    `DEL` VARCHAR(1),
    primary key(`TOURID`),
    constraint `fk_tour_type` foreign key(`TOUR_TYPE`) references `T_TOUR_TYPE`(`TOUR_TYPE`)
    ON delete no action ON update no action,
    constraint `fk_src_loc` foreign key(`SOURCE_LOCID`) references `T_LOCATION`(`LOC_ID`)
    ON delete no action ON update no action,
    constraint `fk_dest_loc` foreign key(`DEST_LOCID`) references `T_LOCATION`(`LOC_ID`)
    ON delete no action ON update no action,
    constraint `fk_veh_id` foreign key(`VEHICLE_ID`) references `T_ASSET`(`ASSET_ID`)
    ON delete no action ON update no action,
    constraint `fk_driver` foreign key(`DRIVER_ID`) references `T_DRIVER`(`DRIVER_ID`)
    ON delete no action ON update no action,
    constraint `fk_ship_to` foreign key(`SHIP_TO`) references `T_CUSTOMER`(`CUST_ID`)
    ON delete no action ON update no action,
    constraint `fk_customer` foreign key(`CUST_ID`) references `T_CUSTOMER`(`CUST_ID`)
    ON delete no action ON update no action
) engine=InnoDB auto_increment=2 charset = utf8;

INSERT INTO `db_example`.`t_tour`
(`TOURID`,
`TOUR_TYPE`,
`SOURCE_LOCID`,
`DEST_LOCID`,
`VEHICLE_ID`,
`DRIVER_ID`,
`SHIP_TO`,
`PLAN_DEPART`,
`PLAN_ARR`,
`ACT_DEPART`,
`ACT_ARR`,
`ETA`,
`EXE_STATUS`,
`CUST_ID`,
`CREATED_ON`,
`CREATED_BY`,
`DEL`)
VALUES
('2100000001',
'LONG',
'LOC1',
'LOC2',
'TRUCK01',
'DRIVER1',
'CUST1',
NOW(),
NOW(),
DATE_ADD(NOW(),INTERVAL 2 HOUR),
DATE_ADD(NOW(),INTERVAL 2 HOUR),
DATE_ADD(NOW(),INTERVAL 2 HOUR),
'01',
'CUST1',
NOW(),
'ADMIN',
''),('2100000002',
'LONG',
'LOC1',
'LOC2',
'TRUCK01',
'DRIVER1',
'CUST1',
NOW(),
NOW(),
DATE_ADD(NOW(),INTERVAL 2 HOUR),
DATE_ADD(NOW(),INTERVAL 2 HOUR),
DATE_ADD(NOW(),INTERVAL 2 HOUR),
'01',
'CUST2',
NOW(),
'ADMIN',
''),('2100000003',
'LONG',
'LOC1',
'LOC2',
'TRUCK02',
'DRIVER2',
'CUST2',
NOW(),
NOW(),
DATE_ADD(NOW(),INTERVAL 2 HOUR),
DATE_ADD(NOW(),INTERVAL 2 HOUR),
DATE_ADD(NOW(),INTERVAL 2 HOUR),
'01',
'CUST2',
NOW(),
'ADMIN',
'');

create table `T_NOTIFICATION`(
	`TOURID` VARCHAR(20) NOT NULL,
	`SEQ` INT(10),
    `TEXT` VARCHAR(100),
	`CREATED_BY` VARCHAR(20),
    `CREATED_ON` datetime,
     primary KEY(`TOURID`,`SEQ`),
    constraint `fk_no_tour_id` foreign key(`TOURID`) references `T_TOUR`(`TOURID`)
     ON delete no action ON update no action
)engine=InnoDB DEFAULT CHARSET=utf8;

insert into `T_NOTIFICATION`(`TOURID`,`SEQ`,`TEXT`) VALUES('2100000002',1,'前方道路1拥堵');
insert into `T_NOTIFICATION`(`TOURID`,`SEQ`,`TEXT`) VALUES('2100000002',2,'前方道路2拥堵');
insert into `T_NOTIFICATION`(`TOURID`,`SEQ`,`TEXT`) VALUES('2100000002',3,'前方道路3拥堵');

create table `T_PLN_STOP` (
	`TOURID` VARCHAR(20) NOT NULL,
    `SEQ` INT,
	`LOCID` VARCHAR(20),
    `PLAN_DEPART` datetime,
    `PLAN_ARR`    datetime,
    `ACT_DEPART`  datetime,
    `ACT_ARR`     datetime,
    `EST_DEPART`  datetime,
    `EST_ARR`     datetime,
    `ETA`	      datetime,
    `STATUS`      VARCHAR(2),
    `DEL` 		 VARCHAR(1),
    primary key(`TOURID`,`SEQ`),
    key `idx_fk_tour_id_pln`(`TOURID`),
    constraint `fk_tour_id_pln` foreign key(`TOURID`) references `T_TOUR`(`TOURID`)
    ON delete no action ON update no action,
    constraint `fk_pln_loc` foreign key(`LOCID`) references `T_LOCATION`(`LOC_ID`)
    ON delete no action ON update no action
) engine=InnoDB default charset = utf8;
INSERT INTO `db_example`.`t_pln_stop`
(`TOURID`,
`SEQ`,
`LOCID`,
`PLAN_DEPART`,
`PLAN_ARR`,
`ACT_DEPART`,
`ACT_ARR`,
`EST_DEPART`,
`EST_ARR`,
`ETA`,
`STATUS`,
`DEL`)
VALUES
('2100000003',1,'LOC1',NOW(),DATE_ADD(NOW(),INTERVAL 2 HOUR),NOW(),DATE_ADD(NOW(),INTERVAL 2 HOUR),NOW(),DATE_ADD(NOW(),
INTERVAL 2 HOUR),NOW(),'P',''),
('2100000003',2,'LOC2',NOW(),DATE_ADD(NOW(),INTERVAL 2 HOUR),NOW(),DATE_ADD(NOW(),INTERVAL 2 HOUR),NOW(),DATE_ADD(NOW(),
INTERVAL 2 HOUR),NOW(),'P',''),
('2100000001',1,'LOC1',NOW(),DATE_ADD(NOW(),INTERVAL 2 HOUR),NOW(),DATE_ADD(NOW(),INTERVAL 2 HOUR),NOW(),DATE_ADD(NOW(),
INTERVAL 2 HOUR),NOW(),'P',''),
('2100000001',2,'LOC2',NOW(),DATE_ADD(NOW(),INTERVAL 2 HOUR),NOW(),DATE_ADD(NOW(),INTERVAL 2 HOUR),NOW(),DATE_ADD(NOW(),
INTERVAL 2 HOUR),NOW(),'P',''),
('2100000002',1,'LOC1',NOW(),DATE_ADD(NOW(),INTERVAL 2 HOUR),NOW(),DATE_ADD(NOW(),INTERVAL 2 HOUR),NOW(),DATE_ADD(NOW(),
INTERVAL 2 HOUR),NOW(),'P',''),
('2100000002',2,'LOC2',NOW(),DATE_ADD(NOW(),INTERVAL 2 HOUR),NOW(),DATE_ADD(NOW(),INTERVAL 2 HOUR),NOW(),DATE_ADD(NOW(),
INTERVAL 2 HOUR),NOW(),'P','');

create table `T_TOUR_ITEM` (
	`TOURID` VARCHAR(20) NOT NULL,
    `SEQ` INT,
    `CONTAINER` VARCHAR(20),
    `QUAN` decimal(5,2),
    `QUAN_UOM`    VARCHAR(6),
    `COMMODITY`  VARCHAR(20),
    `LOCATION`   VARCHAR(20),
    `STATUS`      VARCHAR(2),
    `DEL` 		 VARCHAR(1),
    `CREATED_BY` VARCHAR(20),
    `CREATED_ON` datetime,
    primary key(`TOURID`,`SEQ`),
    constraint `fk_tour_id_itm` foreign key(`TOURID`) references `T_TOUR`(`TOURID`)
    ON delete no action ON update no action
) engine=InnoDB default charset = utf8;
INSERT INTO `db_example`.`t_tour_item`
(`TOURID`,
`SEQ`,
`CONTAINER`,
`QUAN`,
`QUAN_UOM`,
`COMMODITY`,
`LOCATION`,
`STATUS`,
`DEL`)
VALUES
('2100000002',
'1',
'CONTAINER1',
1,
'PC',
'PRODUCT01',
'LOC2',
'01',
''),('2100000001',
'1',
'CONTAINER2',
1,
'PC',
'PRODUCT01',
'LOC2',
'01',
''),('2100000003',
'1',
'CONTAINER3',
1,
'PC',
'PRODUCT01',
'LOC2',
'01',
'');

create table `T_ACT_STOP` (
	`TOURID` VARCHAR(20) NOT NULL,
    `SEQ` int,
    `LAT`  VARCHAR(10),
    `LNG`  VARCHAR(10),
    `ADDR` VARCHAR(50),
    `REP_TIME`	  datetime,
    `TEMPERATURE` DECIMAL(5,2),
    `STATUS` VARCHAR(2),
    `DEL` VARCHAR(1),
    primary key(`TOURID`,`SEQ`),
    key `idx_fk_tour_id_act`(`TOURID`),
    constraint `fk_tour_id_act` foreign key(`TOURID`) references `T_TOUR`(`TOURID`)
    ON delete no action ON update no action
) engine=InnoDB default charset = utf8;


INSERT INTO `db_example`.`t_act_stop`
(`TOURID`,
`SEQ`,
`LNG`,
`LAT`,
`ADDR`,
`REP_TIME`,
`TEMPERATURE`,
`STATUS`,
`DEL`)
VALUES
('2100000001',3,121.47533,31.229375,'',NOW(),1,'E',''),
('2100000001',4,121.47474,31.230074,'',NOW(),1,'E',''),
('2100000001',5,121.475885,31.23082,'',NOW(),1,'E',''),
('2100000001',6,121.476319,31.231107,'',NOW(),1,'E',''),
('2100000001',7,121.476445,31.231263,'',NOW(),1,'E',''),
('2100000001',8,121.477196,31.23026,'',NOW(),1,'E',''),
('2100000001',9,121.477808,31.229397,'',NOW(),1,'E',''),
('2100000001',10,121.47822,31.228741,'',NOW(),1,'E',''),
('2100000001',11,121.477986,31.228624,'',NOW(),1,'E',''),
('2100000001',12,121.477786,31.228581,'',NOW(),1,'E',''),
('2100000001',13,121.477261,31.228299,'',NOW(),1,'E',''),
('2100000001',14,121.477122,31.228207,'',NOW(),1,'E',''),
('2100000001',15,121.475829,31.227331,'',NOW(),1,'E',''),
('2100000001',16,121.475677,31.227144,'',NOW(),1,'E',''),
('2100000001',17,121.475582,31.227057,'',NOW(),1,'E',''),
('2100000001',18,121.474666,31.226662,'',NOW(),1,'E',''),
('2100000001',19,121.473737,31.22628,'',NOW(),1,'E',''),
('2100000001',20,121.472517,31.225751,'',NOW(),1,'E',''),
('2100000001',21,121.471966,31.225521,'',NOW(),1,'E',''),
('2100000001',22,121.471602,31.225365,'',NOW(),1,'E',''),
('2100000001',23,121.468767,31.224214,'',NOW(),1,'E','');
CREATE TABLE `T_EVENT_CODE`(
	`EVENT_CODE` VARCHAR(10) NOT NULL,
    `EVENT_TEXT` VARCHAR(50),
    `CREATED_BY` VARCHAR(20),
    `CREATED_ON` datetime,
    `DEL` VARCHAR(1),
    primary KEY(`EVENT_CODE`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `db_example`.`t_event_code`
(`EVENT_CODE`,
`EVENT_TEXT`,
`DEL`)
VALUES
('DEPART',
'出发',
''),('ARRV',
'到达',
''),('LOAD',
'装载',
''),('UNLOAD',
'卸载',
'');

CREATE TABLE `T_EXE_EVENT`(
	`TOURID` VARCHAR(20) NOT NULL,
    `SEQ` INT(10) NOT null,
	`EVENT_CODE` VARCHAR(10) NOT NULL,
    `LOCATION` VARCHAR(20),
    `CREATED_ON` datetime,
    `STATUS` VARCHAR(2),
    `CREATED_BY` VARCHAR(20),
    `DEL` VARCHAR(1),
    primary KEY(`TOURID`,`SEQ`),
    constraint `fk_evt_tour_id` foreign key(`TOURID`) references `T_TOUR`(`TOURID`)
     ON delete no action ON update no action,
    constraint `fk_evt_loc` foreign key(`LOCATION`) references `T_LOCATION`(`LOC_ID`)
     ON delete no action ON update no action
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `db_example`.`t_exe_event`
(`TOURID`,
`SEQ`,
`EVENT_CODE`,
`LOCATION`,
`CREATED_ON`,
`STATUS`,
`DEL`)
VALUES
('2100000001',
1,
'DEPART',
'LOC1',
NOW(),
'E',
''),('2100000001',
2,
'LOAD',
'LOC1',
NOW(),
'E',
''),
('2100000001',
3,
'ARRV',
'LOC2',
NOW(),
'E',
''),('2100000001',
'4',
'UNLOAD',
'LOC1',
NOW(),
'E',
''),('2100000002',
1,
'DEPART',
'LOC1',
NOW(),
'E',
''),('2100000002',
2,
'LOAD',
'LOC1',
NOW(),
'E',
''),
('2100000002',
3,
'ARRV',
'LOC2',
NOW(),
'E',
''),('2100000002',
'4',
'UNLOAD',
'LOC1',
NOW(),
'E',
'');

create table `T_RESERVATION`(
	`RESV_ID` VARCHAR(20) NOT NULL,
    `RESV_TYPE` VARCHAR(10),
	`SOURCE_LOCID` VARCHAR(20),
    `DEST_LOCID` VARCHAR(20),
    `VEHICLE_ID` VARCHAR(20),
    `DRIVER_ID` VARCHAR(20),
    `SHIP_TO`  VARCHAR(20),
    `PLAN_DEPART` datetime,
    `PLAN_ARR`   datetime,
    `ACT_DEPART` datetime,
    `ACT_ARR`    datetime,
    `STATUS`  VARCHAR(2),
    `CUST_ID` VARCHAR(20),
    `TOURID` VARCHAR(20),
    `CREATED_ON` datetime,
    `CREATED_BY` VARCHAR(20),
	`TEXT` VARCHAR(100),
    `DEL` VARCHAR(1),
	primary key (`RESV_ID`),
    constraint `fk_resv_type` foreign key(`RESV_TYPE`) references `T_RESV_TYPE`(`RESV_TYPE`)
    ON delete no action ON update no action,
    constraint `fk_resv_src_loc` foreign key(`SOURCE_LOCID`) references `T_LOCATION`(`LOC_ID`)
    ON delete no action ON update no action,
    constraint `fk_resv_dest_loc` foreign key(`DEST_LOCID`) references `T_LOCATION`(`LOC_ID`)
    ON delete no action ON update no action,
    constraint `fk_resv_veh_id` foreign key(`VEHICLE_ID`) references `T_ASSET`(`ASSET_ID`)
    ON delete no action ON update no action,
    constraint `fk_resv_driver` foreign key(`DRIVER_ID`) references `T_DRIVER`(`DRIVER_ID`)
    ON delete no action ON update no action,
    constraint `fk_resv_ship_to` foreign key(`SHIP_TO`) references `T_CUSTOMER`(`CUST_ID`)
    ON delete no action ON update no action,
    constraint `fk_resv_customer` foreign key(`CUST_ID`) references `T_CUSTOMER`(`CUST_ID`)
    ON delete no action ON update no action
)engine=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `db_example`.`t_reservation`
(`RESV_ID`,
`RESV_TYPE`,
`SOURCE_LOCID`,
`DEST_LOCID`,
`VEHICLE_ID`,
`DRIVER_ID`,
`SHIP_TO`,
`PLAN_DEPART`,
`PLAN_ARR`,
`ACT_DEPART`,
`ACT_ARR`,
`STATUS`,
`CUST_ID`,
`CREATED_ON`,
`CREATED_BY`,
`TEXT`,
`DEL`,
`TOURID`)
VALUES
('5100000001',
'NORM',
'LOC1',
'LOC2',
'TRUCK01',
'DRIVER1',
'CUST1',
NOW(),
DATE_ADD(NOW(),INTERVAL 2 HOUR),
NOW(),
NOW(),
'P',
'CUST1',
NOW(),
'ADMIN',
'测试预留',
'',
'2100000001'),
('5100000002',
'NORM',
'LOC2',
'LOC1',
'TRUCK01',
'DRIVER1',
'CUST1',
NOW(),
DATE_ADD(NOW(),INTERVAL 2 HOUR),
NOW(),
NOW(),
'P',
'CUST1',
NOW(),
'ADMIN',
'测试预留',
'',
'2100000002'),
('5100000003',
'NORM',
'LOC2',
'LOC1',
'TRUCK01',
'DRIVER1',
'CUST1',
NOW(),
DATE_ADD(NOW(),INTERVAL 2 HOUR),
NOW(),
NOW(),
'P',
'CUST1',
NOW(),
'ADMIN',
'测试预留',
'',
'2100000003');

create table `T_RESV_ITEM` (
	`RESV_ID` VARCHAR(20) NOT NULL,
    `SEQ` INT,
    `CONTAINER` VARCHAR(20),
    `QUAN` 		decimal(5,2),
    `QUAN_UOM`    VARCHAR(6),
    `COMMODITY`  VARCHAR(20),
    `LOCATION`   VARCHAR(20),
    `STATUS`      VARCHAR(2),
    `CREATED_BY` VARCHAR(20),
    `CREATED_ON` datetime,
    `DEL` 		 VARCHAR(1),
    primary key(`RESV_ID`,`SEQ`),
    constraint `fk_resv_id_itm` foreign key(`RESV_ID`) references `T_RESERVATION`(`RESV_ID`)
    ON delete no action ON update no action
) engine=InnoDB default charset = utf8;
INSERT INTO `db_example`.`t_resv_item`
(`RESV_ID`,
`SEQ`,
`CONTAINER`,
`QUAN`,
`QUAN_UOM`,
`COMMODITY`,
`LOCATION`,
`STATUS`,
`DEL`)
VALUES
('5100000003',
1,
'CONTAINER1',
1,
'PC',
'货物1',
'LOC2',
'P',
''),
('5100000003',
2,
'CONTAINER1',
1,
'PC',
'货物1',
'LOC2',
'P',
''),('5100000001',
1,
'CONTAINER1',
1,
'PC',
'货物1',
'LOC2',
'P',
''),
('5100000001',
2,
'CONTAINER1',
1,
'PC',
'货物1',
'LOC2',
'P',
''),
('5100000002',
1,
'CONTAINER1',
1,
'PC',
'货物1',
'LOC2',
'P',
''),
('5100000002',
2,
'CONTAINER1',
1,
'PC',
'货物1',
'LOC2',
'P',
'');

DROP TABLE IF EXISTS t_sequence;
DROP FUNCTION IF EXISTS currval;
DROP FUNCTION IF EXISTS setval;
DROP FUNCTION IF EXISTS nextval;
CREATE TABLE t_sequence (
name VARCHAR(50) NOT NULL,
current_value BIGINT NOT NULL,
increment INT NOT NULL DEFAULT 1,
PRIMARY KEY (name)
) ENGINE=InnoDB;

DELIMITER $
CREATE FUNCTION currval (seq_name VARCHAR(50))
RETURNS BIGINT
LANGUAGE SQL
DETERMINISTIC
CONTAINS SQL
SQL SECURITY DEFINER
COMMENT ''
BEGIN
DECLARE value BIGINT;
SET value = 0;
SELECT current_value INTO value
FROM t_sequence
WHERE name = seq_name;
RETURN value;
END
$


DELIMITER $
CREATE FUNCTION nextval (seq_name VARCHAR(50))
RETURNS BIGINT
LANGUAGE SQL
DETERMINISTIC
CONTAINS SQL
SQL SECURITY DEFINER
COMMENT ''
BEGIN
UPDATE t_sequence
SET current_value = current_value + increment
WHERE name = seq_name;
RETURN currval(seq_name);
END
$


DELIMITER $
CREATE FUNCTION setval (seq_name VARCHAR(50), value bigint)
RETURNS BIGINT
LANGUAGE SQL
DETERMINISTIC
CONTAINS SQL
SQL SECURITY DEFINER
COMMENT ''
BEGIN
UPDATE t_sequence
SET current_value = value
WHERE name = seq_name;
RETURN currval(seq_name);
END
$

INSERT INTO t_sequence VALUES ('TOUR', 6100000000, 1);
INSERT INTO t_sequence VALUES('RESV',3200000000,1);
INSERT INTO t_sequence VALUES('SCH',2100000000,1);
-- ----添加一个sequence名称和初始值，以及自增幅度  添加一个名为TestSeq 的自增序列

-- SELECT SETVAL('TOUR', 10);
-- ---设置指定sequence的初始值    这里设置TestSeq 的初始值为10

SELECT CURRVAL('TOUR');
-- --查询指定sequence的当前值   这里是获取TestSeq当前值--

SELECT NEXTVAL('TOUR');
-- --查询指定sequence的下一个值  这里是获取TestSeq下一个值

create table `T_SCHEDULE` (
	`SCH_ID` VARCHAR(20) NOT NULL,
    `SCH_TYPE` VARCHAR(10),
    `SOURCE_LOCID` VARCHAR(20),
    `DEST_LOCID` VARCHAR(20),
    `VEHICLE_ID` VARCHAR(20),
    `DRIVER_ID` VARCHAR(20),
    `SHIP_TO`  VARCHAR(20),
    `START_DT` datetime,
    `END_DT`   datetime,
    `STATUS`  VARCHAR(2),
    `CUST_ID` VARCHAR(20),
    `CREATED_ON` datetime,
    `CREATED_BY` VARCHAR(20),
    `DEL` VARCHAR(1),
    primary key(`SCH_ID`),
    constraint `fk_sch_type` foreign key(`SCH_TYPE`) references `T_SCH_TYPE`(`SCH_TYPE`)
    ON delete no action ON update no action,
    constraint `fk_sch_src_loc` foreign key(`SOURCE_LOCID`) references `T_LOCATION`(`LOC_ID`)
    ON delete no action ON update no action,
    constraint `fk_sch_dest_loc` foreign key(`DEST_LOCID`) references `T_LOCATION`(`LOC_ID`)
    ON delete no action ON update no action,
    constraint `fk_sch_veh_id` foreign key(`VEHICLE_ID`) references `T_ASSET`(`ASSET_ID`)
    ON delete no action ON update no action,
    constraint `fk_sch_driver` foreign key(`DRIVER_ID`) references `T_DRIVER`(`DRIVER_ID`)
    ON delete no action ON update no action,
    constraint `fk_sch_ship_to` foreign key(`SHIP_TO`) references `T_CUSTOMER`(`CUST_ID`)
    ON delete no action ON update no action,
    constraint `fk_sch_customer` foreign key(`CUST_ID`) references `T_CUSTOMER`(`CUST_ID`)
    ON delete no action ON update no action
) engine=InnoDB default charset = utf8;

create table `T_SCH_STOP` (
	`SCH_ID` VARCHAR(20) NOT NULL,
    `SEQ` INT,
	`LOCID` VARCHAR(20),
    `PLAN_DEPART` datetime,
    `PLAN_ARR`    datetime,
    `STATUS`      VARCHAR(2),
    primary key(`SCH_ID`,`SEQ`),
    key `idx_fk_sch_id`(`SCH_ID`),
    constraint `fk_sch_id_pln` foreign key(`SCH_ID`) references `T_SCHEDULE`(`SCH_ID`)
    ON delete no action ON update no action,
    constraint `fk_sch_pln_loc` foreign key(`LOCID`) references `T_LOCATION`(`LOC_ID`)
    ON delete no action ON update no action
) engine=InnoDB default charset = utf8;
