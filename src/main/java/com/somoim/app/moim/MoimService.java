package com.somoim.app.moim;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.somoim.app.chat.ChatMessageDAO;
import com.somoim.app.chat.ChatMessageDTO;
import com.somoim.app.chat.ChatRoomDTO;
import com.somoim.app.chat.moim.MoimChatDTO;
import com.somoim.app.member.MemberDTO;
import com.somoim.app.moim.member.MoimMemberDTO;
import com.somoim.app.payment.SubsDTO;
import com.somoim.app.util.FileManager;

@Service
public class MoimService {
	@Autowired
	private MoimDAO moimDAO;
	@Autowired
	private FileManager fileManager;
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private ChatMessageDAO chatMessageDAO;

	//list
	public List<MoimDTO> getList(MemberDTO memberDTO) throws Exception {
		return moimDAO.getList(memberDTO);

	}

	//add
	public int add(MoimDTO moimDTO, MultipartFile file, MemberDTO memberDTO) throws Exception {
		int result = moimDAO.add(moimDTO);
		result = moimDAO.moimHeadAdd(moimDTO);

		// chating room, chating, moimchat에 insert
		Map<String, Object> map = new HashMap<>();
		ChatRoomDTO chatRoomDTO = new ChatRoomDTO();
		map.put("chatRoomDTO", chatRoomDTO);
		map.put("memberDTO", memberDTO);
		map.put("moimDTO", moimDTO);
		chatMessageDAO.addChatRoom(chatRoomDTO);
		chatMessageDAO.moimChatAdd(map);
		
		ChatMessageDTO chat = new ChatMessageDTO();
		chat.setChatRoomNum(chatRoomDTO.getChatRoomNum());
		chat.setUserName(memberDTO.getUserName());
		chat.setChatText(memberDTO.getNickName()+"가 들어왔습니다.");
		chatMessageDAO.addChat(chat);
		
		String path = servletContext.getRealPath("/resources/upload/moim");
		if(file.isEmpty()) {
			
			MoimFileDTO moimFileDTO = new MoimFileDTO();
			moimFileDTO.setOriName(file.getOriginalFilename());
			moimFileDTO.setMoimNum(moimDTO.getMoimNum());
			
			result = moimDAO.fileAdd(moimFileDTO);
			
			return result;
		}
		
		String fileName = fileManager.fileSave(path, file);
		
		
		MoimFileDTO moimFileDTO = new MoimFileDTO();
		moimFileDTO.setFileName(fileName);
		moimFileDTO.setOriName(file.getOriginalFilename());
		moimFileDTO.setMoimNum(moimDTO.getMoimNum());

		result = moimDAO.fileAdd(moimFileDTO);

		
		return result;

	}
	
	//delete
	public int delete(MoimDTO moimDTO) throws Exception {
		//모임사진 삭제
		if(moimDAO.file(moimDTO) == null) {
			return moimDAO.delete(moimDTO);
		}
		MoimFileDTO moimFileDTO = moimDAO.file(moimDTO);
		String path = servletContext.getRealPath("/resources/upload/moim");
		fileManager.fileDelete(path, moimFileDTO.getFileName());

		//모임삭제
		return moimDAO.delete(moimDTO);
	}

	//update
	public MoimDTO getInfo(MoimDTO moimDTO) throws Exception {
		return moimDAO.getInfo(moimDTO);
	}

	public int update(MoimDTO moimDTO, MultipartFile file) throws Exception {
		int result = moimDAO.update(moimDTO);
		
		String path = servletContext.getRealPath("/resources/upload/moim");
		
		if(file.isEmpty()) {
			return result;
		}
		
		String fileName = fileManager.fileSave(path, file);

		MoimFileDTO moimFileDTO = new MoimFileDTO();
		moimFileDTO.setFileName(fileName);
		moimFileDTO.setOriName(file.getOriginalFilename());
		moimFileDTO.setMoimNum(moimDTO.getMoimNum());

		result = moimDAO.fileUpdate(moimFileDTO);

		return result;
	}
	//home
	//memInfo
	public List<MoimMemberDTO> memInfo(MoimDTO moimDTO) {
		return moimDAO.memInfo(moimDTO);
	}
	public Long memNum(MoimDTO moimDTO) {
		return moimDAO.memNum(moimDTO);
	}
	
	
	//join
	public int join(MoimMemberDTO moimMemberDTO) {
		
		return moimDAO.join(moimMemberDTO);
	}
	
	//kick
	public int kick(MoimMemberDTO moimMemberDTO) {
		return moimDAO.kick(moimMemberDTO);
	}	
	
}
