create database db_sports;
use db_sports;

create table tbl_sp_search (
sp_seq	BIGINT	AUTO_INCREMENT	PRIMARY KEY,
sp_money	VARCHAR(10)		,
sp_district	VARCHAR(20)	NOT NULL	,
sp_search	VARCHAR(500)		,
sp_sport	VARCHAR(100)		
);
create table tbl_all_list (
al_seq	BIGINT		PRIMARY KEY,
al_code	CHAR(4)	NOT NULL	,
al_name	VARCHAR(500)	NOT NULL	,
al_tel	VARCHAR(40)		,
al_sport	VARCHAR(50)	NOT NULL	,
al_addr	VARCHAR(500)	NOT NULL	,
al_free	VARCHAR(20)		
);
DROP TABLE tbl_sp_search;
DROP TABLE tbl_all_list;
DROP TABLE tbl_detail;
DROP TABLE tbl_qna;
DROP TABLE tbl_user;

create table tbl_detail(
dt_code	CHAR(4)		PRIMARY KEY,
dt_time	VARCHAR(10)		,
dt_money	VARCHAR(2000)	,	
dt_site	VARCHAR(2000)		
);
create table tbl_QnA(
qna_seq	BIGINT	AUTO_INCREMENT	PRIMARY KEY,
qna_id	VARCHAR(20)	NOT NULL	,
qna_title	VARCHAR(500)	NOT NULL	,
qna_name	VARCHAR(500)	NOT NULL	,
qna_text	VARCHAR(3000)	NOT NULL	,
qna_email	VARCHAR(50)	NOT NULL	
);
create table tbl_user(
user_seq	BIGINT	auto_increment	PRIMARY KEY,
user_id	VARCHAR(50)	NOT NULL	,
user_pw	VARCHAR(20)	NOT NULL	,
user_tel	VARCHAR(20)	NOT NULL,	
user_name	VARCHAR(50)	NOT NULL,	
user_email	VARCHAR(50)	NOT NULL	
);

insert into tbl_all_list(
select * from tbl_all_list;

alter table tbl_all_list
add foreign key(al_name)
references tbl_detail(dt_name);

alter table tbl_all_list drop foreign key al_code;

drop table tbl_all_list;
drop table tbl_detail;
drop table tbl_all_list;
drop table tbl_all_list;
drop table tbl_all_list;

ALTER TABLE tbl_all_list
ADD CONSTRAINT fk_detail
FOREIGN KEY(al_code)
REFERENCES tbl_detail(dt_code);

ALTER TABLE tbl_detail
add FOREIGN KEY(dt_code)
REFERENCES tbl_all_list(al_code);

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