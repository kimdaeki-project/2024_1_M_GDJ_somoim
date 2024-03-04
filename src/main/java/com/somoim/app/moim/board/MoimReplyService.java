package com.somoim.app.moim.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.somoim.app.member.MemberDTO;
import com.somoim.app.util.Pager;

@Service
public class MoimReplyService {
	@Autowired
	private MoimReplyDAO replyDAO;
	
	//add
	public int add(ReplyDTO replyDTO) throws Exception {
		return replyDAO.add(replyDTO);
	}
	
	//list
	public List<ReplyDTO> getList(ReplyDTO replyDTO, Pager pager) throws Exception {
		pager.makeRow();
		pager.makeNum(replyDAO.getTotalCount(replyDTO));
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pager", pager);
		map.put("replyDTO", replyDTO);
		
		return replyDAO.getList(map);
	}
	
	//delete
	public int delete(ReplyDTO replyDTO) throws Exception{
		return replyDAO.delete(replyDTO);
	}
	
	//update
	public int update(ReplyDTO replyDTO) throws Exception{
		return replyDAO.update(replyDTO);
	}

	
	//reply
	public int info(ReplyDTO replyDTO, HttpSession session) throws Exception{
		ReplyDTO parent = replyDAO.info(replyDTO);
		
		replyDTO.setReplyRef(parent.getReplyRef());
		replyDTO.setReplyStep(parent.getReplyStep()+1);
		replyDTO.setReplyDepth(parent.getReplyDepth()+1);
		
		int result = replyDAO.replyUpdate(parent);
		
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		replyDTO.setUserName(memberDTO.getUserName());
		replyDTO.setReplyWriter(memberDTO.getNickName());
	
		if(memberDTO.getProfile() != null) {
			replyDTO.setReplyProfile(memberDTO.getProfile().getFileName());
		}
		replyDTO.setParent(parent.getReplyWriter());
		
		result = replyDAO.reply(replyDTO);
		
		return result;
	}
	
}
