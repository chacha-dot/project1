package com.poseidon.pro1;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	//흐름정리
	//user -> Controller -> Service -> DAO -> mybatis -> DB
	
	@Autowired
	private Util util;
	
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
		//String bno = request.getParameter("bno");
		int bno = util.strToInt(request.getParameter("bno"));
		
		//bno에 요청하는 값이 있음. 이 값을 db까지 보내자.
		//System.out.println("bno : " + bno);
		
		//DTO로 변경합니다.
		BoardDTO dto = new BoardDTO();
		dto.setBno(bno);
		//dto.setM_id(null) 글 상세보기에서는 mid가 없어도 됩니다.
		
		BoardDTO result = boardService.detail(dto);
		model.addAttribute("dto", result);
		
		return "detail";
	}
	
	@GetMapping("/write")
	public String write(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("mname") != null) {
			return "write";
		} else {
			return "redirect:/login";
		}
		
	}
	
	@PostMapping("/write")
	public String write2(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("mid") != null) {
			//로그인 했습니다. 아래 로직을 여기로 가져오세요.
			//사용자가 입력한 데이터 변수에 담기
			BoardDTO dto = new BoardDTO();
			dto.setBtitle(request.getParameter("title"));
			dto.setBcontent(request.getParameter("content"));
			dto.setM_id((String)session.getAttribute("mid"));//세션에서 가져옴
			dto.setM_name((String)session.getAttribute("mname"));//세션에서 가져옴
			
			//Service -> DAO -> mybatis -> DB로 보내서 저장하기
			boardService.write(dto);
			
			return "redirect:/board";//다시 컨트롤러 지나가기 GET 방식으로 갑니다.
			
		} else {
			//로그인 안했어요. 로그인하세요.
			return "redirect:/login";
		}

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

	@GetMapping("/edit")
	public ModelAndView edit(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		ModelAndView mv = new ModelAndView("edit"); //edit.jsp 열거야
				
		//dto를 하나 만들어서 거기에 담겠습니다. = bno, mid
		BoardDTO dto = new BoardDTO();
		dto.setBno(util.strToInt(request.getParameter("bno")));
		
		
		//내글만 수정할수있도록 세션에 있는 mid도 보냅니다.
		dto.setM_id((String)session.getAttribute("mid"));
		
		//데이터베이스에 bno를 보내서 dto를 얻어옵니다.
		BoardDTO result = boardService.detail(dto);
		
		//mv에 실어 보냅니다.
		mv.addObject("dto", result);
		return mv;
	}
	
	@PostMapping("/edit")
	public String edit(BoardDTO dto) {
		//System.out.println(dto.getBtitle());
		//System.out.println(dto.getBcontent());
		//System.out.println(dto.getBno());
		boardService.edit(dto);
		return "redirect:detail?bno="+dto.getBno();
	}
	
	
}
