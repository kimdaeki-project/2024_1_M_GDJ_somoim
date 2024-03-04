package com.somoim.app.payment;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class ConvertBankCode {
	
	private static final Map<String, String> bankMap = new HashMap<String, String>();
	
	static {
		bankMap.put("39", "경남은행");
		bankMap.put("34", "광주은행");
		bankMap.put("12", "농협은행");
		bankMap.put("32", "부산은행");
		bankMap.put("45", "새마을금고");
		bankMap.put("88", "신한은행");
		bankMap.put("48", "신협은행");
		bankMap.put("27", "씨티은행");
		bankMap.put("20", "우리은행");
		bankMap.put("71", "우체국예금");
		bankMap.put("50", "저축은행");
		bankMap.put("37", "전북은행");
		bankMap.put("35", "제주은행");
		bankMap.put("90", "카카오뱅크");
		bankMap.put("92", "토스뱅크");
		bankMap.put("39", "경남은행");
		bankMap.put("81", "하나은행");
		bankMap.put("54", "홍콩상하이은행");
		bankMap.put("03", "기업은행");
		bankMap.put("06", "국민은행");
		bankMap.put("31", "대구은행");
		bankMap.put("02", "산업은행");
		bankMap.put("11", "농협은행");
		bankMap.put("23", "SC제일은행");
		bankMap.put("07", "수협은행");
	}
	
	public static String getBankName(String bank) {
		return bankMap.getOrDefault(bank, "오류");
	}
}
