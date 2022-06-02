create table bcard (
EMP_NUM int not null,
EMP_PASSWD varchar(30) not null,
NAME_KOR varchar(10) not null,
NAME_ENG varchar(30) not null,
DEP_NUM int unsigned check(DEP_NUM < 6) not null,
POS_NUM int unsigned check(POS_NUM < 7) not null,  
MOBILE int unique not null,
PHONE int not null,
EMAIL varchar(45) unique not null,
D_ENTRY date not null,
D_RESIGN date,
SOC_NUM int unique not null,
primary key(EMP_NUM)
);
