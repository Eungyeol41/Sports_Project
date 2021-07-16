use db_sports;

SELECT * FROM tbl_qna;


INSERT INTO tbl_qna(qna_id,qna_title,qna_name,qna_text,qna_email)
VALUES ('Nanask','동호회 관련문의입니다','염주체육관','2030년 7월 26일 대관 문의드립니다','nana@gmail.com');

INSERT INTO tbl_qna(qna_id,qna_title,qna_name,qna_text,qna_email)
VALUES ('Nanask','사람없는 시간대 문의합니다','염주체육관','2030년 7월 26일 배드민턴 치려고 하는데 사람 제일 없는 시간대는 언제죠?','nana@gmail.com');

SELECT * FROM tbl_qna;

   SELECT * FROM tbl_qna
    WHERE qna_seq = 1;
    
    INSERT INTO tbl_qna(qna_id,qna_title,qna_name,qna_text,qna_email)
    VALUES ('Nanask','사람없는 시간대 문의합니다','염주체육관','2030년 7월 26일 배드민턴 치려고 하는데 사람 제일 없는 시간대는 언제죠?','nana@gmail.com');    
    
UPDATE tbl_qna
SET qna_title = '사람없는 시간대 알려주세요' 
WHERE qna_seq = 2;

 DELETE FROM tbl_qna WHERE qna_seq =4;
 
 DROP table tbl_qna;
 
 CREATE TABLE `tbl_qna` (
  qna_seq bigint NOT NULL AUTO_INCREMENT,
  qna_id varchar(20) NOT NULL,
  qna_title varchar(500) NOT NULL,
  qna_name varchar(500) NOT NULL,
  qna_text varchar(3000) NOT NULL,
  qna_email varchar(50) NOT NULL,
  qna_date varchar(30) NOT NULL,
  qna_count int DEFAULT '0',
  PRIMARY KEY (`qna_seq`)
);
 
 use db_sports;
	UPDATE tbl_qna
    SET qna_count = qna_count + 1
    WHERE qna_seq = 1;
 
