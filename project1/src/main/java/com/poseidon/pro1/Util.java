package com.poseidon.pro1;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class Util {
	//문자열이 들어오면 숫자로 변경하기
	public int strToInt(String str) {
		
		/* 내 방법
		 str = str.replaceAll("[^\\d]", ""); 
		 int number = Integer.parseInt(str);
		 */
		//선생님 방법
		int result;
		try {
			result = Integer.parseInt(str);
		} catch (Exception e){
			String re = ""; // 숫자인것만 모을 배열
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < str.length(); i++) {
				if (Character.isDigit(str.charAt(i))) {//숫자인지 물어봄
					//re += str.charAt(i);//숫자만 모아서
					sb.append(str.charAt(i));
				}
			}
			result = Integer.parseInt(sb.toString());//숫자로 만들어서
		}
		
		return result; //되돌려줍니다.
	}
	
	public String exchange(String str) {
		str = str.replace("<", "&lt");
		str = str.replace(">", "&gt");
		return str;
	}
	public String getIp() {
		HttpServletRequest request 
		= (
				(ServletRequestAttributes)
				RequestContextHolder.currentRequestAttributes()
				).getRequest();
		//상대방 ip가져오기 2023-07-19
		String ip = null; // 192.168.0.0 이런형식이므로 String
		//사용하려면 HttpServletRequest가 있어야 합니다.
		ip = request.getHeader("X-Forwarded-For");

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("X-Real-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("X-RealIP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("REMOTE_ADDR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}	
		return ip;
	}
	

}
