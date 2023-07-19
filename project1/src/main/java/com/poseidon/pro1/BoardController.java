package com.poseidon.pro1;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardController {
	//흐름정리
	//user -> Controller -> Service -> DAO -> mybatis -> DB
	
	//Autowired말고 Resource로 연결
	@Resource(name="boardService") //boardservice에서 naming한것을 가져온다.
	private BoardService boardService;
	
	
	
	@GetMapping("/board")
	public String board(Model model) {
		//서비스에서 값 가져오기
		model.addAttribute("list", boardService.boardList());
		
		return "board";
	}
	// http://localhost:8080/pro1/detail?bno=119
	// 파라미터로 들어오는 값 잡기
	@GetMapping("/detail") // Model은 jsp 에 값을 붙이기 위해서 넣었습니다.
	public String detail(HttpServletRequest request, Model model) {
		String bno = request.getParameter("bno");
		//bno에 요청하는 값이 있음. 이 값을 db까지 보내자.
		//System.out.println("bno : " + bno);
		BoardDTO dto = boardService.detail(bno);
		model.addAttribute("dto", dto);
		
		return "detail";
	}
	
	@GetMapping("/write")
	public String write() {
		
		return "write";
	}
	
	@PostMapping("/write")
	public String write(HttpServletRequest request) {
				
		//사용자가 입력한 데이터 변수에 담기
		BoardDTO dto = new BoardDTO();
		dto.setBtitle(request.getParameter("title"));
		dto.setBcontent(request.getParameter("content"));
		dto.setBwrite("홍길동2");
		
		//Service -> DAO -> mybatis -> DB로 보내서 저장하기
		boardService.write(dto);
		
		return "redirect:board";//다시 컨트롤러 지나가기 GET 방식으로 갑니다.
	}
	
	//삭제가 들어온다면
	@GetMapping("/delete")
	public String delete(@RequestParam(value = "bno", required = false, defaultValue = "0") int bno) {
		//@RequestParam : HttpServletRequest의 getParameter();
		
		BoardDTO dto = new BoardDTO();
		dto.setBno(bno);
		//dto.setBwrite(null) 사용자의 정보
		//추후 로그인을 하면 사용자의 정보도 담아서 보냅니다.
		boardService.delete(dto);
		
		return "redirect:board";
	}

}
