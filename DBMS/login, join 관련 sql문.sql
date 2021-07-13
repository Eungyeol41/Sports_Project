USE db_sports;

INSERT INTO tbl_user(user_id, user_pw, user_tel, user_name, user_email)
VALUES('Nanask', 'nana12345', '010-1234-5678', '나나', 'nana@gmail.com');

-- login
SELECT * FROM tbl_user WHERE user_id = 'Nanask' AND user_pw = 'nana12345';
-- id_dblcheck
SELECT COUNT(*) FROM tbl_user WHERE user_id = 'Nanask';
-- findById
SELECT * FROM tbl_user WHERE user_email = 'nana@gmail.com' AND user_tel = '010-1234-5678';
-- findByPW
SELECT user_pw FROM tbl_user WHERE user_id = 'Nanask' AND user_name = '나나' AND user_tel = '010-1234-5678';

-- INSERT
INSERT INTO tbl_user(user_id, user_pw, user_tel, user_name, user_email)
VALUES('Nanak', 'nana123', '010-1234-5679', '나나z', 'nanas@gmail.com');

SELECT * FROM tbl_user WHERE user_id = 'Nanak';

UPDATE tbl_user SET user_pw = 'nana1234'
WHERE user_id = 'Nanak';

-- DELETE
DELETE FROM tbl_user WHERE user_id = 'Nanak';

INSERT INTO tbl_qna(qna_id, qna_title, qna_name, qna_text, qna_email)
VALUES ('kkk41', '염주 체육관..', '염주 체육관 종합운동장', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.Morbi nec mattis lorem. Pellentesque interdum tellus dignissim aliquam elementum. Mauris bibendum dapibus rutrum. Nulla feugiat nisl lectus, nec vehicula velit pharetra non. Nulla sed magna eget tellus mattis lacinia sed et justo. Nunc dictum malesuada blandit. Integer ac orci id diam consectetur lobortis. Donec a nisi justo. Quisque venenatis ipsum ut ipsum mattis, at pellentesque tortor rhoncus. Cras et porta nulla, sed imperdiet urna. Nunc nec dui quam. Suspendisse elementum aliquam mauris vitae lacinia.', 'nana12@gamilda.com');

SELECT * FROM tbl_qna WHERE qna_id = 'kkk41';