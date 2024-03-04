package com.somoim.app.board.qna;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.somoim.app.board.BoardDTO;
import com.somoim.app.board.BoardFileDTO;
import com.somoim.app.board.BoardService;
import com.somoim.app.member.role.MemberRoleDTO;
import com.somoim.app.util.FileManager;
import com.somoim.app.util.Pager;

import oracle.net.aso.q;

@Service
public class QnaService implements BoardService{
@Autowired
private QnaDAO qnaDAO;
@Autowired
private FileManager fileManager;

@Autowired
private ServletContext servletContext;

	//List
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		List<BoardDTO> ar = qnaDAO.getList(pager);
		return ar;
	}
	//List
	public List<QnaDTO> getListQna(Pager pager, QnaDTO qnaDTO)throws Exception{
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("pager", pager);
	map.put("QnaDTO", qnaDTO);
	pager.makeRow();
	pager.makeNum(qnaDAO.getTotalCount(map));
	return qnaDAO.getListqna(map);
	}
	

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return qnaDAO.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO, MultipartFile[] attachs) throws Exception {
		//1. 글을 등록 - 글번호를 알아오기 위해서
		int result = qnaDAO.setAdd(boardDTO);	
		
		//2. 파일을 HDD에 저장
		//2-1 저장할 폴더의 실제 경로 구하기
		String path = servletContext.getRealPath("/resources/upload/qna");
		//2-2 HDD에 저장하고 파일명 받아오기
		
		
		for(MultipartFile f: attachs) {
			System.out.println(f);
			if(f.isEmpty()) {
				continue;
			}
			
			String fileName = fileManager.fileSave(path, f);
		//2-3 DB에 파일 정보 저장하기
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setUserName(boardDTO.getUserName());
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriName(f.getOriginalFilename());
			boardFileDTO.setBoardNum(boardDTO.getBoardNum());
			result = qnaDAO.setFileAdd(boardFileDTO);
		}
		
		return result;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO, MultipartFile[] attachs) throws Exception {
		//1. 글을 등록 - 글번호를 알아오기 위해서
				int result = qnaDAO.setAdd(boardDTO);	
				
				//2. 파일을 HDD에 저장
				//2-1 저장할 폴더의 실제 경로 구하기
				String path = servletContext.getRealPath("/resources/upload/qna");
				//2-2 HDD에 저장하고 파일명 받아오기
				
				
				for(MultipartFile f: attachs) {
					System.out.println(f);
					if(f.isEmpty()) {
						continue;
					}
					
					String fileName = fileManager.fileSave(path, f);
				//2-3 DB에 파일 정보 저장하기
					BoardFileDTO boardFileDTO = new BoardFileDTO();
					boardFileDTO.setUserName(boardDTO.getUserName());
					boardFileDTO.setFileName(fileName);
					boardFileDTO.setOriName(f.getOriginalFilename());
					boardFileDTO.setBoardNum(boardDTO.getBoardNum());
					result = qnaDAO.setFileAdd(boardFileDTO);
				}
				
				return result;
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		List<BoardFileDTO> ar = qnaDAO.getFileList(boardDTO);;;;
		String path = servletContext.getRealPath("/resources/upload/qna");
		for(BoardFileDTO b : ar) {
			fileManager.fileDelete(path, b.getFileName());
		}
		int result = qnaDAO.setDelete(boardDTO);
		return result;
	}


}
