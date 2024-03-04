package com.somoim.app;

import static org.junit.Assert.assertNotEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.somoim.app.board.BoardDTO;
import com.somoim.app.board.notice.NoticeDAO;
import com.somoim.app.util.Pager;




public class Noticetest extends MyTest{


//	@Autowired
	private NoticeDAO noticeDAO;

//	@Test
	public void test() throws Exception {
		this.getListTest();
	}


	public void getListTest()throws Exception{
		Map<String, Object> map = new HashMap<>();
		Pager pager = new Pager();
		pager.makeRow();
		BoardDTO boardDTO = new BoardDTO();
		pager.setSearchFind("searchFind2");
		pager.setCategorySelect("category2");
		pager.setSearch("user1");
		System.out.println(pager.getSearch());

		map.put("pager", pager);
		map.put("BoardDTO", boardDTO);
		List<BoardDTO> ar= noticeDAO.getListJson(map);

		System.out.println(ar.get(0).getBoardCategory());

		assertNotEquals(0, ar.size());

	}


}
