package com.somoim.app;



import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.somoim.app.member.KakaoAPI;

public class KakaoTest extends MyTest {

//	@Autowired
	private KakaoAPI kakaoAPI;
	
//	@Test
	public void test() {
		
	System.out.println(kakaoAPI.getKakaoApiKey()+"왜 여기서만되는거얌");
	
	}

}
