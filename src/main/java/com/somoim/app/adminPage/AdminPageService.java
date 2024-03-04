package com.somoim.app.adminPage;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.somoim.app.board.BoardDTO;
import com.somoim.app.board.BoardFileDTO;
import com.somoim.app.member.MemberDTO;
import com.somoim.app.moim.MoimDTO;
import com.somoim.app.util.FileManager;
import com.somoim.app.util.Pager;

@Service
public class AdminPageService {

	@Autowired
	private AdminPageDAO adminPageDAO;

	@Autowired
	private FileManager fileManager;

	@Autowired
	private ServletContext servletContext;

	public List<MemberDTO> list(Pager pager) throws Exception {
		pager.makeRow();
		Long totalCount = adminPageDAO.getTotalCount(pager);
		pager.makeNum(totalCount);
		List<MemberDTO> ar = adminPageDAO.list(pager);
		return ar;
	}

	public int add(AdminPageDTO adminPageDTO) throws Exception {
		return adminPageDAO.add(adminPageDTO);
	}

	public List<AdminPageDTO> placeList(AdminPageDTO adminPageDTO) throws Exception {
		return adminPageDAO.placeList(adminPageDTO);
	}
	public int update(AdminPageDTO adminPageDTO)throws Exception {
		return adminPageDAO.update(adminPageDTO);
	}
	public List<AdminPageDTO> adminList(AdminPageDTO adminPageDTO) throws Exception {
		return adminPageDAO.adminList(adminPageDTO);
	}
	public AdminPageDTO detail(AdminPageDTO adminPageDTO)throws Exception{
		return adminPageDAO.detail(adminPageDTO);
	}
	public int delete(AdminPageDTO adminPageDTO)throws Exception{
		return adminPageDAO.delete(adminPageDTO);
	}

}
