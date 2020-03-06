-- creating Database
create database MLP192;

-- using the Database
use MLP192;

-- Creating Customer Table
--create table CUSTOMERS

create table CUSTOMER(CUS_ID int auto_increment not null primary key,CUS_PWD varchar(20),CUS_NAME varchar(30),CUS_DOB date,CUS_PH varchar(20),CUS_MAILADD varchar(30),CUS_WALLET float,CUS_STATUS varchar(30));
--  create table VENDOR

create table VENDOR(VEN_ID int auto_increment primary key,CUS_ID int,VEN_NAME varchar(20),VEN_PWD varchar(20),VEN_FSTATUS varchar(20),VEN_NO varchar(20) ,VEN_WALLET float , foreign key(CUS_ID) references CUSTOMER(CUS_ID) on delete cascade);
--  create table ORDERS

create table ORDERS(CUS_ID int(20),ORD_ID int primary key auto_increment not null,ORD_DATE datetime,ORD_ITEMSEL varchar(20),foreign key(CUS_ID) references CUSTOMER(CUS_ID) on delete cascade);
--  create table WALLET

create table WALLET(CUS_ID int,WAL_BAL float,WAL_PAYID varchar(20),WAL_TOTAMT float,WAL_PAYDATE datetime,WAL_PAYTIME datetime,foreign key(CUS_ID) references CUSTOMER(CUS_ID) on delete cascade);
-- create table MENU

create table MENU(FOOD_ID int(20) primary key,FOOD_ITEMNAME varchar(20),FOOD_ITEMAMT float,CUS_ID int,foreign key(CUS_ID) references CUSTOMER(CUS_ID) on delete cascade);
