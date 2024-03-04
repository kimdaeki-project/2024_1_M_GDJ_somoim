package com.somoim.app.chat;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.somoim.app.chat.moim.MoimChatDTO;
import com.somoim.app.member.MemberDTO;
import com.somoim.app.moim.MoimDTO;
import com.somoim.app.moim.member.MoimMemberDTO;

@Repository
public class ChatMessageDAO {

	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE = "com.somoim.app.chat.ChatMessageDAO.";
	
	// room
	// chating 치기전 방 생성 
	public int addChatRoom(ChatRoomDTO chatRoomDTO) {
		return sqlSession.insert(NAMESPACE+"addChatRoom",chatRoomDTO);
	}
	
	// 특정 user의 참여중인 채팅방번호
	public List<Long> chatRoomList(MemberDTO memberDTO){
		return sqlSession.selectList(NAMESPACE+"chatRoomList", memberDTO);
	}
	// 방에있는 유저
	public List<MemberDTO> chatUserList(ChatMessageDTO chatMessageDTO){
		return sqlSession.selectList(NAMESPACE+"chatUserList", chatMessageDTO);
	}

	// chatMessage 테이블의 방번호와 chatRoom 테이블의 번호를 비교하기위해
	public List<Long> chatRoomCh() {
		return sqlSession.selectList(NAMESPACE+"chatRoomCh");
	}
	
	// chat
	// chating 칠때 마다 insert
	public int addChat(ChatMessageDTO chatMessageDTO) {
		return sqlSession.insert(NAMESPACE+"addChat",chatMessageDTO);
	}
	
	public List<ChatMessageDTO> chatHistory(ChatMessageDTO chatMessageDTO){
		return sqlSession.selectList(NAMESPACE+"chatHistory", chatMessageDTO);
	}
	
	// moim chat
	public List<MoimDTO> moimChatInfo(MemberDTO memberDTO){
		return sqlSession.selectList(NAMESPACE+"moimChatInfo",memberDTO);
	}
	
	public int moimChatAdd(Map<String,Object> map) {
		return sqlSession.insert(NAMESPACE+"moimChatAdd", map);
	}
	
	public ChatMessageDTO getLastChat(List<Long> chatMessageDTO) {
		return sqlSession.selectOne(NAMESPACE+"getLastChat", chatMessageDTO);
	}
	
	// moim
	public MoimChatDTO getMoimRoom(MoimMemberDTO moimMemberDTO) {
		return sqlSession.selectOne(NAMESPACE+"getMoimRoom",moimMemberDTO);
	}
}
