package com.team.sport.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class QnAVO {
	
	private Long qna_seq; //	BIGINT SEQ
	private String qna_id; //	VARCHAR(20) 아이디
	private String qna_title; //	VARCHAR(500) 제목
	private String qna_name; //	VARCHAR(500) 시설이름
	private String qna_text; //	VARCHAR(3000) 문의내용
	private String qna_email; //	VARCHAR(50) 이메일
	
//	private String search_option;
//	private String keyword;


}
