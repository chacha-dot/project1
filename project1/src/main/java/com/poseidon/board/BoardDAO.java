package com.poseidon.board;

import java.util.List;

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

	public List<BoardDTO> boardList(PageDTO page) {
		return sqlSession.selectList("board.boardList", page); //list에 받아올 것들
	}

	public BoardDTO detail(BoardDTO dto2) {
		return sqlSession.selectOne("board.detail", dto2); // 앞에는 네임스페이스.아이디, 값
	}//sqlSession id는 spring> database-context.xml에서 지정해주었다.

	public void write(BoardDTO dto) {
		sqlSession.insert("board.write", dto);
	}

	public void delete(BoardDTO dto) {
		sqlSession.delete("board.delete", dto);
	}

	public void edit(BoardDTO dto) {
		sqlSession.update("board.edit", dto);
	}

	public void iLike(BoardDTO dto2) {
		sqlSession.update("board.likeUp", dto2);
	}

	public int totalCount() {
		return sqlSession.selectOne("board.totalCount");
	}

	
	
	
		

}
