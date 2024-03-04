package com.somoim.app.moim.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.somoim.app.moim.MoimDTO;
import com.somoim.app.moim.MoimFileDTO;
import com.somoim.app.util.FileManager;
import com.somoim.app.util.Pager;


@Service
public class MoimBoardService {
	@Autowired
	private MoimBoardDAO moimBoardDAO;
	@Autowired
	private FileManager fileManager;
	@Autowired
	private ServletContext servletContext;
	
	//list
	public List<Object> list(Pager pager, MoimBoardDTO boardDTO) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pager", pager);
		map.put("dto", boardDTO);
		Long total = moimBoardDAO.getTotalCount(map);
		pager.makeRow();
		pager.makeNum(total);

		return moimBoardDAO.list(map);
	}
	
	//add
	public int add(MoimBoardDTO boardDTO, MultipartFile[] file) throws Exception{
		//글 등록
		int result = moimBoardDAO.add(boardDTO);
		//파일 저장
		String path = servletContext.getRealPath("/resources/upload/moimBoard");
		
		for(MultipartFile f: file) {
			
			if(f.isEmpty()) {
				continue;
			}
			
			String fileName = fileManager.fileSave(path, f);
			
			MoimBoardFileDTO boardFileDTO = new MoimBoardFileDTO();
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriName(f.getOriginalFilename());
			boardFileDTO.setBoardNum(boardDTO.getBoardNum());
			result = moimBoardDAO.fileAdd(boardFileDTO);
		}
		
		return result;
	}
	
	//detail
	public MoimBoardDTO detail(MoimBoardDTO boardDTO) throws Exception {
		return moimBoardDAO.detail(boardDTO);
		
	}
	
	//update
	public int update(MoimBoardDTO boardDTO, MultipartFile[] file) throws Exception {
		int result = moimBoardDAO.update(boardDTO);
		
		String path = servletContext.getRealPath("/resources/upload/moimBoard");
		//파일삭제
		List<MoimBoardFileDTO> ar = moimBoardDAO.file(boardDTO);
		for(MoimBoardFileDTO f : ar) {
			fileManager.fileDelete(path, f.getFileName());
		}
		//파일추가
		for(MultipartFile f: file) {
			
			if(f.isEmpty()) {
				continue;
			}
			
			String fileName = fileManager.fileSave(path, f);
			
			MoimBoardFileDTO boardFileDTO = new MoimBoardFileDTO();
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriName(f.getOriginalFilename());
			boardFileDTO.setBoardNum(boardDTO.getBoardNum());
			result = moimBoardDAO.fileAdd(boardFileDTO);
		}
		
		return result;
	}
	
	
	//delete
	public int delete(MoimBoardDTO boardDTO) throws Exception {
		//게시글 사진 삭제
		List<MoimBoardFileDTO> ar = moimBoardDAO.file(boardDTO);
		String path = servletContext.getRealPath("/resources/upload/moimBoard");
		for(MoimBoardFileDTO f : ar) {
			fileManager.fileDelete(path, f.getFileName());
		}
		//게시글 삭제
		return moimBoardDAO.delete(boardDTO);
	}
	
	//click
	public int click(MoimBoardDTO boardDTO) {
		return moimBoardDAO.click(boardDTO);
	}

	
	

}
