use db_example;
drop table if exists `db_example`.`T_PLN_STOP`;
drop table if exists `db_example`.`T_ACT_STOP`;
drop table if exists `db_example`.`T_TOUR`;
drop table if exists `db_example`.`T_CUSTOMER`;

create table T_CUSTOMER(
	`ID` int(20) NOT NULL auto_increment,
    `NAME` VARCHAR(50),
    primary key (`ID`)
)engine=InnoDB auto_increment=0 DEFAULT CHARSET=utf8;

create table `T_TOUR` (
	`TOURID` INT(10) NOT NULL auto_increment,
    `SOURCE_LOCID` VARCHAR(20),
    `SOURCE_LAT` VARCHAR(10),
    `SOURCE_LNG` VARCHAR(10),
    `SOURCE_ADDR` VARCHAR(50),
    `DEST_LOCID` VARCHAR(20),
    `DEST_LAT` VARCHAR(10),
    `DEST_LNG` VARCHAR(10),
    `DEST_ADDR` VARCHAR(50),
    `PLATENUMBER` VARCHAR(10),
    `VEHICLE_ID` VARCHAR(20),
    `DRIVER_ID` VARCHAR(20),
    `DRIVER_NAME` VARCHAR(10),
    `SHIP_TO`  VARCHAR(20),
    `PLAN_DEPART` TIMESTAMP,
    `PLAN_ARR`    TIMESTAMP,
    `ETA`	        TIMESTAMP,
    `EXE_STATUS`  VARCHAR(2),
    `CUST_ID` VARCHAR(20),
    primary key(`TOURID`)
) engine=InnoDB auto_increment=2 charset = utf8;

create table `T_PLN_STOP` (
	`TOURID` INT(10) NOT NULL,
    `SEQ` tinyint,
    `LOCID` VARCHAR(20),
    `LAT`  VARCHAR(10),
    `LNG`  VARCHAR(10),
    `ADDR` VARCHAR(50),
    `PLAN_DEPART` TIMESTAMP,
    `PLAN_ARR`    TIMESTAMP,
    `ACT_DEPART`  TIMESTAMP,
    `ACT_ARR`     TIMESTAMP,
    `EST_DEPART`  TIMESTAMP,
    `EST_ARR`     TIMESTAMP,
    `ETA`	        TIMESTAMP,
    `STATUS`      VARCHAR(2),
    primary key(`TOURID`,`SEQ`),
    key `idx_fk_tour_id_pln`(`TOURID`),
    constraint `fk_tour_id_pln` foreign key(`TOURID`) references `T_TOUR`(`TOURID`)
    ON delete no action ON update no action
) engine=InnoDB default charset = utf8;

create table `T_ACT_STOP` (
	`TOURID` INT(10) NOT NULL,
    `SEQ` int,
    `LAT`  VARCHAR(10),
    `LNG`  VARCHAR(10),
    `ADDR` VARCHAR(50),
    `REP_TIME`	  TIMESTAMP,
    `TEMPERATURE` DECIMAL(5,2),
    `STATUS` VARCHAR(2),
    primary key(`TOURID`,`SEQ`),
    key `idx_fk_tour_id_act`(`TOURID`),
    constraint `fk_tour_id_act` foreign key(`TOURID`) references `T_TOUR`(`TOURID`)
    ON delete no action ON update no action
) engine=InnoDB default charset = utf8;