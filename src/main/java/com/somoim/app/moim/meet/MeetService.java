package com.somoim.app.moim.meet;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.somoim.app.member.MemberDTO;
import com.somoim.app.util.FileManager;

@Service
public class MeetService {
	@Autowired
	private MeetDAO meetDAO;
	@Autowired
	private FileManager fileManager;
	@Autowired
	private ServletContext servletContext;
	
	//list
	public List<MeetDTO> getList(MeetDTO meetDTO) throws Exception {
		return meetDAO.getList(meetDTO);
		
	}
	public List<Integer> partiNum(List<MeetDTO> ar) throws Exception {
		return meetDAO.partiNum(ar);
	}
	
	
	//add
	public int add(MeetDTO meetDTO, MultipartFile file) throws Exception {
		int result = meetDAO.add(meetDTO);
		
		String path = servletContext.getRealPath("/resources/upload/meet");
		
		String fileName = fileManager.fileSave(path, file);
		
		MeetFileDTO meetFileDTO = new MeetFileDTO();
		meetFileDTO.setFileName(fileName);
		meetFileDTO.setOriName(file.getOriginalFilename());
		meetFileDTO.setMeetNum(meetDTO.getMeetNum());
		
		result = meetDAO.fileAdd(meetFileDTO);
		

		return result;
	}
	
	//delete
	public int delete(MeetDTO meetDTO) throws Exception {
		//정모 사진 삭제
		MeetFileDTO meetFileDTO = meetDAO.file(meetDTO);
		String path = servletContext.getRealPath("/resources/upload/meet");
		fileManager.fileDelete(path, meetFileDTO.getFileName());
		
		//정모 삭제
		return meetDAO.delete(meetDTO);
	}

	
	
}