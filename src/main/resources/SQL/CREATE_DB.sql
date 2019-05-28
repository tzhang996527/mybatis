use db_example;
drop table if exists `db_example`.`T_PLN_STOP`;
drop table if exists `db_example`.`T_ACT_STOP`;
drop table if exists `db_example`.`T_NOTIFICATION`;
drop table if exists `db_example`.`T_EXE_EVENT`;
drop table if exists `db_example`.`T_TOUR_ITEM`;
drop table if exists `db_example`.`T_TOUR`;
drop table if exists `db_example`.`T_DRIVER`;
drop table if exists `db_example`.`T_RESERVATION`;
drop table if exists `db_example`.`T_RESV_ITEM`;
drop table if exists `db_example`.`T_ASSET`;
drop table if exists `db_example`.`T_LOCATION`;
drop table if exists `db_example`.`T_ASSET_TYPE`;
drop table if exists `db_example`.`T_EVENT_CODE`;
drop table if exists `db_example`.`T_PLN_STOP`;
drop table if exists `db_example`.`T_ACT_STOP`;
drop table if exists `db_example`.`T_RESV_TYPE`;
drop table if exists `db_example`.`T_TOUR_TYPE`;
drop table if exists `db_example`.`T_CUSTOMER`;


create table `T_RESV_TYPE`(
	`RESV_TYPE` VARCHAR(10) NOT NULL,
    `TEXT` VARCHAR(30),
    primary key (`RESV_TYPE`)
)engine=InnoDB DEFAULT CHARSET=utf8;

create table `T_TOUR_TYPE`(
	`TOUR_TYPE` VARCHAR(10) NOT NULL,
    `TEXT` VARCHAR(30),
    primary key (`TOUR_TYPE`)
)engine=InnoDB DEFAULT CHARSET=utf8;

create table `T_NOTIFICATION`(
	`ID` INT(10) NOT NULL auto_increment,
    `TEXT` VARCHAR(100),
    primary key (`ID`)
)engine=InnoDB DEFAULT CHARSET=utf8;

create table `T_CUSTOMER`(
	`CUST_ID` varchar(20) not null,
    `TYPE` VARCHAR(10),
    `NAME` VARCHAR(50),
    `ADDRESS` VARCHAR(50),
    `DEL` VARCHAR(1),
    primary key (`CUST_ID`,`TYPE`)
)engine=InnoDB DEFAULT CHARSET=utf8;

create table `T_LOCATION`(
	`LOC_ID` VARCHAR(20) NOT NULL,
    `ADDRESS` VARCHAR(100),
    `LAT` VARCHAR(10),
    `LNG` VARCHAR(10),
    `CITY` VARCHAR(10),
    `PROVINCE` VARCHAR(10),
    `DISTRICT` VARCHAR(20),
    `POSTAL_CODE` VARCHAR(10),
    `DEL` VARCHAR(1),
    primary KEY(`LOC_ID`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `T_ASSET_TYPE`(
    `ASSET_TYPE` VARCHAR(10) NOT NULL,
    `ASSET_TEXT` VARCHAR(30),
    `DEL` VARCHAR(1),
    primary key(`ASSET_TYPE`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

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
    `DEL` VARCHAR(1),
    primary key(`ASSET_ID`),
    constraint `fk_asset_type` foreign key(`ASSET_TYPE`) references `T_ASSET_TYPE`(`ASSET_TYPE`)
    ON delete no action ON update no action,
    constraint `fk_location` foreign key(`LOCATION`) references `T_LOCATION`(`LOC_ID`)
    ON delete no action ON update no action
)ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `T_DRIVER`(
	`DRIVER_ID` VARCHAR(20) NOT NULL,
    `NAME` VARCHAR(10),
    `TEL`  VARCHAR(15),
    `LOCATION` varchar(20),
    `DEL`  VARCHAR(1),
    primary key(`DRIVER_ID`),
    constraint `fk_driver_loc` foreign key(`LOCATION`) references `T_LOCATION`(`LOC_ID`)
    ON delete no action ON update no action
)ENGINE=INNODB DEFAULT CHARSET=utf8;

create table `T_TOUR` (
	`TOURID` VARCHAR(20) NOT NULL,
    `TOUR_TYPE` VARCHAR(10),
    `SOURCE_LOCID` VARCHAR(20),
    `DEST_LOCID` VARCHAR(20),
    `VEHICLE_ID` VARCHAR(20),
    `DRIVER_ID` VARCHAR(20),
    `SHIP_TO`  VARCHAR(20),
    `PLAN_DEPART` date,
    `PLAN_ARR`   date,
    `ACT_DEPART` date,
    `ACT_ARR`    date,
    `ETA`	     date,
    `EXE_STATUS`  VARCHAR(2),
    `CUST_ID` VARCHAR(20),
    `CREATED_ON` DATE,
    `CREATED_BY` DATE,
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

create table `T_PLN_STOP` (
	`TOURID` VARCHAR(20) NOT NULL,
    `SEQ` INT,
	`LOCID` VARCHAR(20),
    `PLAN_DEPART` date,
    `PLAN_ARR`    DATE,
    `ACT_DEPART`  DATE,
    `ACT_ARR`     DATE,
    `EST_DEPART`  DATE,
    `EST_ARR`     DATE,
    `ETA`	      DATE,
    `STATUS`      VARCHAR(2),
    `DEL` 		 VARCHAR(1),
    primary key(`TOURID`,`SEQ`),
    key `idx_fk_tour_id_pln`(`TOURID`),
    constraint `fk_tour_id_pln` foreign key(`TOURID`) references `T_TOUR`(`TOURID`)
    ON delete no action ON update no action,
    constraint `fk_pln_loc` foreign key(`LOCID`) references `T_LOCATION`(`LOC_ID`)
    ON delete no action ON update no action
) engine=InnoDB default charset = utf8;

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
    primary key(`TOURID`,`SEQ`),
    constraint `fk_tour_id_itm` foreign key(`TOURID`) references `T_TOUR`(`TOURID`)
    ON delete no action ON update no action
) engine=InnoDB default charset = utf8;

create table `T_ACT_STOP` (
	`TOURID` VARCHAR(20) NOT NULL,
    `SEQ` int,
    `LAT`  VARCHAR(10),
    `LNG`  VARCHAR(10),
    `ADDR` VARCHAR(50),
    `REP_TIME`	  Date,
    `TEMPERATURE` DECIMAL(5,2),
    `STATUS` VARCHAR(2),
    `DEL` VARCHAR(1),
    primary key(`TOURID`,`SEQ`),
    key `idx_fk_tour_id_act`(`TOURID`),
    constraint `fk_tour_id_act` foreign key(`TOURID`) references `T_TOUR`(`TOURID`)
    ON delete no action ON update no action
) engine=InnoDB default charset = utf8;

CREATE TABLE `T_EVENT_CODE`(
	`EVENT_CODE` VARCHAR(10) NOT NULL,
    `EVENT_TEXT` VARCHAR(50),
    `DEL` VARCHAR(1),
    primary KEY(`EVENT_CODE`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `T_EXE_EVENT`(
	`TOURID` VARCHAR(20) NOT NULL,
    `SEQ` INT(10) NOT null,
	`EVENT_CODE` VARCHAR(10) NOT NULL,
    `LOCATION` VARCHAR(20),
    `CREATED_ON` Date,
    `STATUS` VARCHAR(2),
    `DEL` VARCHAR(1),
    primary KEY(`TOURID`,`SEQ`),
    constraint `fk_evt_tour_id` foreign key(`TOURID`) references `T_TOUR`(`TOURID`)
     ON delete no action ON update no action,
    constraint `fk_evt_loc` foreign key(`LOCATION`) references `T_LOCATION`(`LOC_ID`)
     ON delete no action ON update no action
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table `T_RESERVATION`(
	`RESV_ID` VARCHAR(20) NOT NULL,
    `RESV_TYPE` VARCHAR(10),
	`SOURCE_LOCID` VARCHAR(20),
    `DEST_LOCID` VARCHAR(20),
    `VEHICLE_ID` VARCHAR(20),
    `DRIVER_ID` VARCHAR(20),
    `SHIP_TO`  VARCHAR(20),
    `PLAN_DEPART` date,
    `PLAN_ARR`   date,
    `ACT_DEPART` date,
    `ACT_ARR`    date,
    `STATUS`  VARCHAR(2),
    `CUST_ID` VARCHAR(20),
    `CREATED_ON` DATE,
    `CREATED_BY` DATE,
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

create table `T_RESV_ITEM` (
	`RESV_ID` VARCHAR(20) NOT NULL,
    `SEQ` INT,
    `CONTAINER` VARCHAR(20),
    `QUAN` 		decimal(5,2),
    `QUAN_UOM`    VARCHAR(6),
    `COMMODITY`  VARCHAR(20),
    `LOCATION`   VARCHAR(20),
    `STATUS`      VARCHAR(2),
    `DEL` 		 VARCHAR(1),
    primary key(`RESV_ID`,`SEQ`),
    constraint `fk_resv_id_itm` foreign key(`RESV_ID`) references `T_RESERVATION`(`RESV_ID`)
    ON delete no action ON update no action
) engine=InnoDB default charset = utf8;