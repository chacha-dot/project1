package com.poseidon.pro1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	//첫화면 로딩 : index.jsp 호출
	@GetMapping(value = {"/", "/index", "/home"})//여러개의 주소를 만들수 있다 (여러개 주소가와도 모두 index.jsp로 간다)
	public String index() {
		return "index"; //데이터 붙임 없이 index.jsp 페이지만 보여줍니다.
	}
	
	
}
