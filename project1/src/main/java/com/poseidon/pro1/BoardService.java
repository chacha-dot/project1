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


	public void write(BoardDTO dto) {
		boardDAO.write(dto);//void 로 만든 이유는 실행만 시키고 결과를 받지 않아도 되어서입니다.
		//insert만 시키고 값은 받지 않아도 되기때문입니다. (어떤 새로운 값을 볼것이 아니기때문)
	}//select를 제외한 나머지는 영향받은 행의 수(int)를 받아오기도 합니다.
		
		
		
		
	

}
