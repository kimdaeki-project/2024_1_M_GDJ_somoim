package com.somoim.app;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.somoim.app.moim.MoimDAO;

@Service
public class HomeService {
	
	@Autowired
	private MoimDAO moimDAO;

	public Map<String, Object> getCategoryCount ()throws Exception{
		
		List<Map<String, Object>> list = moimDAO.getCategoryCount();
		Map<String, Object> map = new HashMap<String, Object>();
		for(Map<String, Object> count : list) {
			String category = (String)count.get("MOIMCATEGORY");
			BigDecimal counttt = (BigDecimal)count.get("COUNT");
		    int countt = counttt.intValue();
		    map.put(category,countt);
		}
		return map;
	}
	
}
