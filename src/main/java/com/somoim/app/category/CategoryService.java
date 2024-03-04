package com.somoim.app.category;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.somoim.app.files.FileDTO;
import com.somoim.app.member.MemberDTO;
import com.somoim.app.moim.MoimDTO;
import com.somoim.app.moim.MoimFileDTO;
import com.somoim.app.util.FileManager;
import com.somoim.app.util.Pager;

@Service
public class CategoryService {

	
@Autowired
private CategoryDAO categoryDAO;

@Autowired
private FileManager fileManager;
@Autowired
private ServletContext servletContext;

//list
public List<MoimDTO> list(MemberDTO memberDTO) throws Exception {
	return categoryDAO.list(memberDTO);
	
}

public List<MoimDTO> getListCategory(Pager pager, MoimDTO moimDTO, MemberDTO memberDTO)throws Exception{
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("pager", pager);
	map.put("CategoryDTO", moimDTO);
	pager.makeRow();
	pager.makeNum(categoryDAO.getTotalCount(map));
	pager.setPerPage(5L);
	return categoryDAO.getListCategory(map);
}




}
