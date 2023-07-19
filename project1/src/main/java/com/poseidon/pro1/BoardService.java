package com.poseidon.pro1;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService") //BoardService타입이기도 하고 boardService라고 이름지어준다.
public class BoardService {
	
	@Inject
	@Named("boardDAO")
	private BoardDAO boardDAO;
	
	@Autowired
	private Util util; 
	
	
	//이 서비스의 기능
	//보드 리스트 불러오는 메소드
	
	public List<Map<String, Object>> boardList() {
		return boardDAO.boardList();
	}


	public BoardDTO detail(String bno) {
		BoardDTO dto = boardDAO.detail(bno);
		//여기서 ip 뽑아오기
		//ip 중간에 하트 넣기
		if (dto.getBip() != null && dto.getBip().indexOf(".") != -1) {
			String ip = dto.getBip();
			String[] str = ip.split("\\.");
			str[1] = "♡";
			dto.setBip(String.join(".", str));
		} 
		//그거 다시 ip에 저장하기
		return dto;
	}

	//부가적인 작업을 한다. write-post
	public void write(BoardDTO dto) {
		//btitle을 꺼내줍니다.
		
		//값을 변경하겠습니다. replace() '<' -> &lt; '>' -> &gt;
		String btitle = util.exchange(dto.getBtitle());
		dto.setBtitle(btitle);
		//다시 저장해주세요.
		
		dto.setBip(util.getIp());//얻어온 ip도 저장해서 데이터베이스로 보내겠습니다.

		
		boardDAO.write(dto);//void 로 만든 이유는 실행만 시키고 결과를 받지 않아도 되어서입니다.
		//insert만 시키고 값은 받지 않아도 되기때문입니다. (어떤 새로운 값을 볼것이 아니기때문)
	}//select를 제외한 나머지는 영향받은 행의 수(int)를 받아오기도 합니다.


	public void delete(BoardDTO dto) {
		boardDAO.delete(dto);
	}




		
		
	
		
		
	

}
