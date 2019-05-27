T_TOUR
T_DRIVER
T_LOCATION
T_ASSET : VIN / PLATENUMBER / TYPE / MAKE / MODEL / YEAR / HARDWARE /
T_ASSET_TYPE
T_EVENT
T_EVENT_CODE
T_NOTIFICATION
T_POD
T_DELIVERY
T_RESERVATION

create table `T_LOCATION`(
	`LOC_ID` VARCHAR(20) NOT NULL,
    `ADDRESS` VARCHAR(100),
    `LAT` VARCHAR(10),
    `LNG` VARCHAR(10),
    `CITY` VARCHAR(10),
    `PROVINCE` VARCHAR(10),
    `DISTRICT` VARCHAR(20),
    `DEL` VARCHAR(1),
    primary KEY(`LOC_ID`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `T_ASSET_TYPE`(
    `TYPE` VARCHAR(10) NOT NULL,
    `TEXT` VARCHAR(30),
    primary key(`TYPE`)
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
    constraint `fk_asset_type` foreign key(`ASSET_TYPE`) references `T_ASSET_TYPE`(`TYPE`)
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