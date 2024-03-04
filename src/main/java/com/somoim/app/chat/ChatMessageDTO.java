package com.somoim.app.chat;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import com.somoim.app.member.MemberDTO;
import com.somoim.app.member.ProfileDTO;

public class ChatMessageDTO extends MemberDTO{

	private Long messageNum;
	private Long chatRoomNum;
	private String userName;
	private String chatText;
	private String chatTimeStamp;
	
	private MemberDTO memberDTO;
	
	private String search;
	
	public MemberDTO getMemberDTO() {
		return memberDTO;
	}
	public void setMemberDTO(MemberDTO memberDTO) {
		this.memberDTO = memberDTO;
	}

	public Long getMessageNum() {
		return messageNum;
	}
	public void setMessageNum(Long messageNum) {
		this.messageNum = messageNum;
	}
	public Long getChatRoomNum() {
		return chatRoomNum;
	}
	public void setChatRoomNum(Long chatRoomNum) {
		this.chatRoomNum = chatRoomNum;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getChatText() {
		return chatText;
	}
	public void setChatText(String chatText) {
		this.chatText = chatText;
	}
	public String getChatTimeStamp() {
		return chatTimeStamp;
	}
	public void setChatTimeStamp(Date chatTimeStamp) {
		SimpleDateFormat format = new SimpleDateFormat("hh:mm a E", Locale.US);
		Calendar c = Calendar.getInstance();
		c.setTime(chatTimeStamp);
		c.add(Calendar.HOUR, 9);
		
		this.chatTimeStamp = format.format(c.getTime());
	}
	
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	
	@Override
	public String toString() {
		return "ChatMessageDTO [chatRoomNum=" + chatRoomNum + ", chatText=" + chatText + ", chatTimeStamp="
				+ chatTimeStamp + ", memberDTO=" + memberDTO + ", messageNum=" + messageNum + ", userName=" + userName
				+ "]";
	}
}
