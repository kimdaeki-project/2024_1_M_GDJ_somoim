package com.somoim.app.chat;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ChatHandler extends TextWebSocketHandler{

	@Autowired
	private ChatMessageService chatMessageService;
	
	 // group( 정모, 모임, 1:1 )에 따른 Map 나누기 
	private static List<WebSocketSession> sessionList = new ArrayList<>(); 
	
	// 연결후에 실행되는 메서드
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// 세션 아이디를 키로 사용, session을 값으로
		System.out.println("연결");
		System.out.println(session);
		sessionList.add(session);
	}

	//메세지를 다루는 메서드
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println("message");
		ObjectMapper objectMapper = new ObjectMapper();
		ChatMessageDTO chatMessageDTO = objectMapper.readValue(message.getPayload(), ChatMessageDTO.class);
		 
		Long chat = chatMessageDTO.getChatRoomNum();
		if(!chatMessageService.chatHistory(chatMessageDTO).isEmpty()) {
			chat = chatMessageService.chatHistory(chatMessageDTO).get(0).getChatRoomNum();
		}
		//chatMessageDTO.setNickName(chatMessageDTO.getNickName());
		//System.out.println(chatMessageDTO.toString());
		
		int result = chatMessageService.addChat(chatMessageDTO);
		//전송된 메시지를 List의 모든 세션에 전송
		for (WebSocketSession s : sessionList) {
			
			if(chat == chatMessageDTO.getChatRoomNum() && result>0) {
				System.out.println("------------------------");
				System.out.println(message.getPayload());
				
				s.sendMessage(message);
			}			
		}

	}

	// 연결종료후 실행될 메서드
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sessionList.remove(session);
		System.out.println("연결해제");
	}



}
