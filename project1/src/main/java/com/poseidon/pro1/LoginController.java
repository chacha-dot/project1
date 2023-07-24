package com.poseidon.pro1;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(HttpServletRequest request) {
		
		LoginDTO dto = new LoginDTO();
		//System.out.println(request.getParameter("id"));
		//System.out.println(request.getParameter("pw"));
		dto.setM_id(request.getParameter("id"));
		dto.setM_pw(request.getParameter("pw"));
		
		//id/pw를 보냈을때 무엇이 오면 좋을까 ?
		//name, 로그인성공했을때 1행이 변경되었다, 아니면 0 의 그 값을 가져오기위해
		//count(*)값을 가져올것이다. 그걸 가져오기위해 
		dto = loginService.login(dto);
		
		//System.out.println(result.getM_name());
		//System.out.println(result.getCount());
		
		if (dto.getCount() == 1) {
			//세션을 만들어서 로그인을 지정 시간동안 유지시킵니다.
			HttpSession session = request.getSession();
			session.setAttribute("mname", dto.getM_name());
			//세션은 브라우저당 하나씩 서버에 저장된다.
			//세션 : 서버에 저장됨. 쿠키 : 클라이언트(브라우저)에 저장됨.
			session.setAttribute("mid", request.getParameter("id"));
			return "redirect:index";
		} else {
			return "login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		if (session.getAttribute("mname") != null) {
			//session.invalidate(); //세션 삭제하기
			session.removeAttribute("mname");
		}
		if (session.getAttribute("mid") != null) {
			//session.invalidate(); //세션 삭제하기
			session.removeAttribute("mid");
		}
		
		session.setMaxInactiveInterval(0);
		//세션 유지시간을 0으로 만든다. = 종료시키기
		
		session.invalidate(); //세션 초기화 = 종료 = 세션의 모든 속성 값을 제거
			
	
		return "redirect:index";
	}

}
