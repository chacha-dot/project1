package com.poseidon.pro1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;

@Service("boardService") //BoardService타입이기도 하고 boardService라고 이름지어준다.
public class BoardService {
	
	@Inject
	@Named("boardDAO")
	private BoardDAO boardDAO;
	
	
	//이 서비스의 기능
	//보드 리스트 불러오는 메소드
	
	public List<Map<String, Object>> boardList() {
		return boardDAO.boardList();
	}


	public BoardDTO detail(String bno) {
		return boardDAO.detail(bno);
	}
		
		
		
		
	

}
