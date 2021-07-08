package com.team.sport.service.impl;

public class ReplaceBr {

	public static String enterToBr(String str) {
		
		str = str.replace("\n", "<br>");
		str = str.replace("\n\r", "<br>");
		return str.replace("\r\n", "<br>");
		
	}
}
