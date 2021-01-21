package kr.green.test.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.test.dao.BoardDao;
import kr.green.test.pagination.Criteria;
import kr.green.test.vo.BoardVo;
import kr.green.test.vo.FileVo;
import kr.green.test.vo.LikeVo;
import kr.green.test.vo.UserVo;

@Service
public class BoardServiceImp implements BoardService {
	
	@Autowired
	BoardDao boardDao;

	@Override
	public ArrayList<BoardVo> getBoardList(Criteria cri) {
		//(수정)다오의 getBoardList()를 getBoardList(cri)로 수정
		return boardDao.getBoardList(cri);
	}

	@Override
	public BoardVo getBoard(Integer num) {
		//검색할 번호가 없기 때문에 게시글을 가져올 수 없으므로 
		//게시글이 없다는 의미로 null를 반환(리턴)
		if(num == null) {
			return null;
		}
		BoardVo board = boardDao.getBoard(num);	
		return board;
	}

	@Override
	public void registerBoard(BoardVo board) {
		boardDao.insertBoard(board);		
	}

	@Override
	public void modifyBoard(BoardVo board, UserVo user) {
		BoardVo oriBoard = boardDao.getBoard(board.getNum());
		if(oriBoard == null || 
				!oriBoard.getWriter().equals(board.getWriter()) || 
				!oriBoard.getWriter().equals(user.getId())) {
			return;
		}
		oriBoard.setTitle(board.getTitle());
		oriBoard.setContent(board.getContent());
		boardDao.updateBoard(oriBoard);
	}

	@Override
	public void deleteBoard(Integer num, UserVo user) {
		if(num == null) {
			return ;
		}
		BoardVo board = boardDao.getBoard(num);
		//없는 게시글이거나 이미 삭제된 게시글이면
		if(board == null) {
			return ;
		}
		if(!board.getWriter().equals(user.getId())) {
			return ;
		}
		board.setIsDel("Y");
		boardDao.updateBoard(board);
	}

	@Override
	public void views(Integer num) {
		if(num == null)
			return;
		boardDao.updateViews(num);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		//페이지네이션 기능 : 다오에게 전체 게시글 수를 요청
		//return boardDao.getTotalCount();
		
		//페이지네이션 + 검색기능 : 다오에게 전체 게시글이 아닌 현재 페이지 정보에
    //(검색타입, 검색어 포함)맞는 게시글을 가져오라고 요청하도록 수정
		return boardDao.getTotalCount(cri);
	}

	@Override
	public void registerFile(int num, String originalFilename, String path) {
		boardDao.insertFile(num, originalFilename, path);
	}

	@Override
	public ArrayList<FileVo> getFileList(Integer num) {
		return boardDao.getFileList(num);
	}

	@Override
	public void deleteFile(int num) {
		boardDao.deleteFile(num);
	}

	@Override
	public void updateLike(LikeVo likeVo) {
		LikeVo tmp = boardDao.getLike(likeVo);
		System.out.println(likeVo);
		if(tmp == null) {
			boardDao.insertLike(likeVo);
		}else {
			boardDao.updateLike(likeVo);
		}
	}
}








