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
public class UserVO {
	
	private String user_id; // ID
	private String user_pw; // PASSWORD
	private String user_tel; // 전화번호
	private String user_name; // 이름
	private String user_email; // email
	private int user_level; // level
	
}