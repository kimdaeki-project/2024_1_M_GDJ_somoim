package com.somoim.app.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	//파일삭제
	public boolean fileDelete(String path,String fileName)throws Exception{
		
		File file = new File(path,fileName);
		
		if(file.exists()) {
			file.delete();
			}
		
		return file.delete();
	}
	
	

	//파일 저장 하는 메소드
	public String fileSave(String path, MultipartFile file)throws Exception{
		File files = new File(path);
		System.out.println("filesave : "+files);
		// 경로에 파일이 있는지 없는지 비교
		if(files.isFile()) {
			// 강제로 예외처리 시키기
			throw new Exception();
		}

		if(!files.exists()) {
			files.mkdirs();
		}

		Calendar ca = Calendar.getInstance();
		String fileName = ca.getTimeInMillis()+"_"+file.getOriginalFilename();

		fileName=UUID.randomUUID().toString()+"_"+file.getOriginalFilename();
		System.out.println(fileName);
		files= new File(files,fileName);

		file.transferTo(files);
		System.out.println(file);
		return fileName;
	}
}
