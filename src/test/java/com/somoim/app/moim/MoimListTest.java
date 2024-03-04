package com.somoim.app.moim;

import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.somoim.app.MyTest;
import com.somoim.app.member.MemberDTO;

public class MoimListTest extends MyTest{
//	@Autowired
	private MoimDAO moimDAO;

	//@Test
	public void test() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setUserName("user1");

		List<MoimDTO> ar = moimDAO.getList(memberDTO);
		assertNotEquals(0, ar.size());
	}
}
