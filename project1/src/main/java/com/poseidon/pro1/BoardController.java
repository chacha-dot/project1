package com.poseidon.pro1;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
	

}
