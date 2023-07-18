package com.poseidon.pro1;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

//Inject 사용해보기

@Repository("boardDAO") //이름 붙여주기
public class BoardDAO {
	
	@Inject
	@Named("sqlSession")
	private SqlSession sqlSession; 

	public List<Map<String, Object>> boardList() {
		return sqlSession.selectList("board.boardList"); //list에 받아올 것들
	}

	public BoardDTO detail(String bno) {
		return sqlSession.selectOne("board.detail", bno); // 앞에는 네임스페이스.아이디, 값
	}//sqlSession id는 spring> database-context.xml에서 지정해주었다.
	
	
		

}
