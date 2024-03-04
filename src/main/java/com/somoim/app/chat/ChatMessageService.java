package com.somoim.app.chat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.somoim.app.chat.moim.MoimChatDTO;
import com.somoim.app.member.MemberDTO;
import com.somoim.app.moim.MoimDTO;
import com.somoim.app.moim.member.MoimMemberDTO;

@Service
public class ChatMessageService {

	@Autowired
	private ChatMessageDAO chatMessageDAO;
	
	public int addChat(ChatMessageDTO chatMessageDTO) {
		return chatMessageDAO.addChat(chatMessageDTO);
	}
	
	// 특정방의 이전 채팅 기록
	public List<ChatMessageDTO> chatHistory(ChatMessageDTO chatMessageDTO){
		return chatMessageDAO.chatHistory(chatMessageDTO);
	}
	
	public List<Long> chatRoomList(MemberDTO memberDTO){
		return chatMessageDAO.chatRoomList(memberDTO);
	}
	
	public List<MemberDTO> chatUserList(ChatMessageDTO chatMessageDTO){
		return chatMessageDAO.chatUserList(chatMessageDTO);
	}
	
	public List<MoimDTO> moimChatInfo(MemberDTO memberDTO){
		return chatMessageDAO.moimChatInfo(memberDTO);
	}
	
	public ChatMessageDTO getLastChat(List<Long> chatMessageDTO) {
		return chatMessageDAO.getLastChat(chatMessageDTO);
	}
	
	public MoimChatDTO getMoimRoom(MoimMemberDTO moimMemberDTO) {
		return chatMessageDAO.getMoimRoom(moimMemberDTO);
	}
}
