create database db_sports;
use db_sports;

create table tbl_sp_search (
sp_money	VARCHAR(4)	NOT NULL,
sp_district	VARCHAR(5)	,
sp_search	VARCHAR(500),	
sp_sport	VARCHAR(10)	

);
create table tbl_all_list (
al_seq bigint PRIMARY KEY,
al_code char(5) not null ,
al_name	VARCHAR(500)	NOT NULL	,
al_tel	VARCHAR(30)		,
al_sport	VARCHAR(100)	NOT NULL	,
al_addr	VARCHAR(500)	NOT NULL	,
al_free	VARCHAR(10)	NOT NULL
);
DROP TABLE tbl_all_list;

create table tbl_detail(
dt_code char(5) not null ,
dt_time	VARCHAR(100)	NOT NULL	,
dt_money	VARCHAR(200)	NOT NULL,	
dt_site	VARCHAR(500)		,
dt_name	VARCHAR(500)		
);
create table tbl_QnA(
qna_seq	BIGINT	AUTO_INCREMENT	PRIMARY KEY,
qna_id	VARCHAR(20)	NOT NULL	,
qna_title	VARCHAR(500)	NOT NULL	,
qna_name	VARCHAR(500)	NOT NULL	,
qna_text	VARCHAR(3000)	NOT NULL	,
qna_email	VARCHAR(50)		
);
create table tbl_user(
user_id	VARCHAR(50)	NOT NULL	PRIMARY KEY,
user_pw	VARCHAR(20)	NOT NULL	,
user_tel	VARCHAR(20)	NOT NULL,	
user_name	VARCHAR(50)	NOT NULL,	
user_email	VARCHAR(50)	NOT NULL	
);

select * from tbl_all_list;

alter table tbl_all_list
add foreign key(al_name)
references tbl_detail(dt_name);

alter table tbl_detail drop foreign key dt_name;

drop table tbl_all_list;
drop table tbl_detail;
drop table tbl_all_list;
drop table tbl_all_list;
drop table tbl_all_list;

ALTER TABLE tbl_all_list
ADD CONSTRAINT fk_detail
FOREIGN KEY(al_code)
REFERENCES tbl_detail(dt_code);

select * from information_schema.table_constraints where table_name = 'tbl_all_list';
select * from information_schema.table_constraints where constraint_schema = 'db_sports';




drop view view_상세페이지;
CREATE VIEW view_상세페이지 AS 
(
	SELECT 
			AL.al_name AS al_name,
            AL.al_tel AS al_tel,
            AL.al_addr AS al_addr,
            AL.al_sport AS al_sport,
            AL.al_free AS al_free,
            DT.dt_time AS dt_time,
            DT.dt_site AS dt_site,
            DT.dt_money AS dt_money
    FROM tbl_detail AS DT
		LEFT JOIN tbl_all_list AS AL
			ON DT.dt_name = AL.al_name
);    
select * from view_상세페이지;