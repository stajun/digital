package kr.green.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.BoardDao;
import kr.green.spring.pagination.Criteria;
import kr.green.spring.vo.BoardVo;
import kr.green.spring.vo.FileVo;
import kr.green.spring.vo.LikeVo;
import kr.green.spring.vo.UserVo;

@Service
public class BoardServiceImp implements BoardService {

	@Autowired
	BoardDao boardDao;

	@Override
	public ArrayList<BoardVo> getBoardList(Criteria cri) {
		//ArrayList<BoardVo> list = boardDao.getBoardList();
		//return list;
		System.out.println("페이지당 게시글 갯수 :"+cri.getPerPageNum());
		System.out.println("시작 번지 :"+cri.getPageStart());
		return boardDao.getBoardList(cri);
	}

	@Override
	public BoardVo getBoard(Integer num) {
		BoardVo board = boardDao.getBoard(num);
		return board;
	}

	@Override
	public void registerBoard(BoardVo board) {
		boardDao.insertBoard(board);		
	}

	@Override
	public void modifyBoard(BoardVo board, UserVo user) {
		//게시글 번호로 원본 게시글 정보를 가져옴
		BoardVo oriBoard = boardDao.getBoard(board.getNum());
		//원본 게시글 정보에 수정된 제목과 내용으로 바꿈 
		oriBoard.setTitle(board.getTitle());
		oriBoard.setContent(board.getContent());
		//비회원이거나 작성자와 로그인한 유저가 같지 않으면 수정하지 않음
		if(user == null || !user.getId().equals(oriBoard.getWriter())) {
			return;
		}
		//수정된 게시글을 DB에 업데이트
		boardDao.updateBoard(oriBoard);
		//기존 게시글 첨부파일을 삭제
		boardDao.deleteFile(oriBoard.getNum());
	}

	@Override
	public void deleteBoard(Integer num, UserVo user) {
		BoardVo board = boardDao.getBoard(num);
		board.setIsDel("Y");
		if(user == null || !user.getId().equals(board.getWriter())) {
			return;
		}
		boardDao.updateBoard(board);
	}

	@Override
	public void view(Integer num) {
		if(num == null) {
			return;
		}
		boardDao.updateViews(num);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		return boardDao.getTotalCount(cri);
	}

	@Override
	public void registerFile(int num, String originalFilename, String fileName) {
		boardDao.insertFile(num, originalFilename,fileName);		
	}

	@Override
	public ArrayList<FileVo> getFileList(Integer num) {
		if(num == null) {
			return null;
		}
		return boardDao.getFileList(num);
	}

	@Override
	public void like(LikeVo likeVo) {
		LikeVo tmp = boardDao.getLike(likeVo);
		if(tmp == null)
			boardDao.insertLike(likeVo);
		else{
			boardDao.updateLike(likeVo);
		}
	}

	@Override
	public LikeVo getLike(Integer num, UserVo user) {
		if(user == null || num == null)
			return null;
		LikeVo tmp = new LikeVo(num, user.getId());
		return boardDao.getLike(tmp);
	}
}









