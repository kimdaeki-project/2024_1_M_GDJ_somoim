package com.somoim.app.member;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.somoim.app.member.role.MemberRoleDTO;
import com.somoim.app.util.FileManager;

@Service
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private FileManager fileManager;
	
	public int accountDel(MemberDTO memberDTO)throws Exception{
		int result = 0;
		result = memberDAO.accountDel(memberDTO);
		return result;
	}
	
	public int checkId(MemberDTO memberDTO)throws Exception{
		int result = 0;
		result = memberDAO.checkId(memberDTO);
		return result;
	}
	
	public int checkPw(MemberDTO memberDTO)throws Exception{
		int result = 0;
		result = memberDAO.checkPw(memberDTO);
		
		return result;
	}

	public int setPasswordUpdate(MemberDTO memberDTO)throws Exception{
		int result = 0;
		result = memberDAO.setPasswordUpdate(memberDTO);
		return result;
	}

	public int setUpdate(MemberDTO memberDTO,MultipartFile attachs)throws Exception{
		int result = 0;
		MemberDTO dto = memberDAO.getDetail(memberDTO);		
		result = memberDAO.setUpdate(memberDTO);

		if(attachs.isEmpty()) {
			return result;
		}
		
		String path = servletContext.getRealPath("/resources/upload/member");
		
		String fileName = fileManager.fileSave(path, attachs);
		
		if(dto.getProfile().getFileName() != fileName) {
			fileManager.fileDelete(path, dto.getProfile().getFileName());
		}
		
		ProfileDTO profileDTO = new ProfileDTO();
		profileDTO.setFileName(fileName);
		profileDTO.setOriName(attachs.getOriginalFilename());
		profileDTO.setUserName(memberDTO.getUserName());
		
		result = memberDAO.setProfileJoin(profileDTO);

		return result;
	}

	public int setjoin(MemberDTO memberDTO,MultipartFile attachs)throws Exception {
		int result = 0 ;
		String Key = memberDTO.creatCustomerKey();
		memberDTO.setCustomerKey(Key);
		result = memberDAO.setJoin(memberDTO);
		result = memberDAO.setMemberRole(memberDTO);
		if(attachs.isEmpty()) {
			return result;
		}
		String path = servletContext.getRealPath("/resources/upload/member");
		System.out.println(path);
		String fileName = fileManager.fileSave(path, attachs);
		ProfileDTO profileDTO = new ProfileDTO();
		profileDTO.setFileName(fileName);
		profileDTO.setOriName(attachs.getOriginalFilename());
		profileDTO.setUserName(memberDTO.getUserName());

		result = memberDAO.setProfileJoin(profileDTO);

		return result;
	}
	public MemberDTO getLogin(MemberDTO memberDTO)throws Exception{
		MemberDTO dto = memberDAO.getDetail(memberDTO);

		
		if(dto!=null) {
			if(dto.getPassword().equals(memberDTO.getPassword())) {

				MemberRoleDTO role = dto.getRoleDTO();
				
				memberDTO.setNickName(dto.getNickName());
				memberDTO.setProfile(dto.getProfile());
				memberDTO.setLoginNum(dto.getLoginNum());
				memberDTO.setEmail(dto.getEmail());
				memberDTO.setAddress(dto.getAddress());
				memberDTO.setRoleDTO(role);
				
				return memberDTO;
				
			}else {
				dto=null;
			}
		}
		return dto;
	}
	

	public MemberDTO getMypage(MemberDTO memberDTO)throws Exception{
		return memberDAO.getDetail(memberDTO);
	}
	
	public MemberDTO submitJoinApp(MemberDTO memberDTO)throws Exception{		
		MemberDTO dto = memberDAO.getDetail(memberDTO);
		if(dto !=null) {
			
			memberDTO.setNickName(dto.getNickName());
			memberDTO.setPassword(dto.getPassword());
			memberDTO.setProfile(dto.getProfile());
			memberDTO.setLoginNum(dto.getLoginNum());
			memberDTO.setRoleDTO(dto.getRoleDTO());
			return memberDTO;
		}
		return dto;
		
	}
	
}
