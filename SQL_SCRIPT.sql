CREATE TABLE `spring_security_demo`.`students` (
 `STUDENT_ID` BIGINT(20) NOT NULL,
 `FIRST_NAME` VARCHAR(45) NOT NULL,
 `LAST_NAME` VARCHAR(45) NULL,
 `EMAIL` VARCHAR(45) NULL,
 `MOBILE_NO` VARCHAR(45) NULL,
 PRIMARY KEY (`STUDENT_ID`));

create table USERS (
USER_NAME varchar (100) not null primary key,
PASSWORD varchar (100) not null,
IS_ACTIVE boolean not null);

create table USER_ROLES(USER_NAME varchar (100) not null,
ROLE varchar (100) not null,
constraint FK_USER_ROLES_USERS foreign key (USER_NAME) references USERS(USER_NAME));

create unique index IX_USER_ROLES_USER_NAME on USER_ROLES (USER_NAME, role);

INSERT INTO USERS (USER_NAME, PASSWORD, IS_ACTIVE)values ('user','$2a$10$3OcLqfJXrxSbXLEx0/BV7.xwCv/yMIdbfpoiNWWIrKHgyb2FuATsK', true);
INSERT INTO USERS (USER_NAME, PASSWORD, IS_ACTIVE)values ('root','$2a$10$h5CUEDJgZ6w/WqZ/7.1AKOuenq7r9Go751G2/gCL5geoEaO1bmTsW', true);
INSERT INTO USER_ROLES (USER_NAME, ROLE) values ('root','ROLE_ADMIN');
INSERT INTO USER_ROLES (USER_NAME, ROLE) values ('user','ROLE_USER');

INSERT INTO `spring_security_demo`.`students`(`STUDENT_ID`,`FIRST_NAME`,`LAST_NAME`,`EMAIL`,`MOBILE_NO`) VALUES(1,'Zahid Hussain'	,'Indher','zahid.indher@gmail.com','923333335366');
INSERT INTO `spring_security_demo`.`students`(`STUDENT_ID`,`FIRST_NAME`,`LAST_NAME`,`EMAIL`,`MOBILE_NO`) VALUES(2,'Zafar Ali'	,'Indher','zafar.indher@yahoo.com','923333335366');
INSERT INTO `spring_security_demo`.`students`(`STUDENT_ID`,`FIRST_NAME`,`LAST_NAME`,`EMAIL`,`MOBILE_NO`) VALUES(3,'Zohaib Hassan'	,'Mangi',	 'zohaib.mangi@sngpl.com',		  '923333335366');
INSERT INTO `spring_security_demo`.`students`(`STUDENT_ID`,`FIRST_NAME`,`LAST_NAME`,`EMAIL`,`MOBILE_NO`) VALUES(4,'Imran Ali'			,'Khokhar','imran.khokhar@royalcyber.com','923333335366');
INSERT INTO `spring_security_demo`.`students`(`STUDENT_ID`,`FIRST_NAME`,`LAST_NAME`,`EMAIL`,`MOBILE_NO`) VALUES(5,'Atif Fayaz'			,'Malah',	 'atif.malah@royalcyber.com',		  '923333335366');
INSERT INTO `spring_security_demo`.`students`(`STUDENT_ID`,`FIRST_NAME`,`LAST_NAME`,`EMAIL`,`MOBILE_NO`) VALUES(6,'Nizaqat Ali'		,'Shah',	 'nizaqat.shah@wavetech.com',	  '923333335366');
INSERT INTO `spring_security_demo`.`students`(`STUDENT_ID`,`FIRST_NAME`,`LAST_NAME`,`EMAIL`,`MOBILE_NO`) VALUES(7,'Amjad Ali'			,'Bhellar',	 'amjad.bhellar@meezan.com',	  '923333335366');
INSERT INTO `spring_security_demo`.`students`(`STUDENT_ID`,`FIRST_NAME`,`LAST_NAME`,`EMAIL`,`MOBILE_NO`) VALUES(8,'Murtaza'			,'Korai',	 'murtaza.korai@primatics.com',	  '923333335366');
INSERT INTO `spring_security_demo`.`students`(`STUDENT_ID`,`FIRST_NAME`,`LAST_NAME`,`EMAIL`,`MOBILE_NO`) VALUES(9,'Asif Ali'				,'Soomro', 'zahid.indher@caa.com',			  '923333335366');
INSERT INTO `spring_security_demo`.`students`(`STUDENT_ID`,`FIRST_NAME`,`LAST_NAME`,`EMAIL`,`MOBILE_NO`) VALUES(10,'Iftikhar Ahmed'	,'Indher',	 'zahid.indher@geditech.com',	  '923333335366');

