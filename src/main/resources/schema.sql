
create table companies
(
   rowid integer not null,
   sectorname varchar(255) ,
   companyname varchar(255) ,
   stockvalue double ,
   generaltrend double ,
   
   primary key(rowid)
);