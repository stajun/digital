package kr.green.test.service;

import java.util.ArrayList;

import kr.green.test.pagination.Criteria;
import kr.green.test.vo.BoardVo;
import kr.green.test.vo.FileVo;
import kr.green.test.vo.LikeVo;
import kr.green.test.vo.UserVo;

public interface BoardService {

	ArrayList<BoardVo> getBoardList(Criteria cri);

	BoardVo getBoard(Integer num);

	void registerBoard(BoardVo board);

	void modifyBoard(BoardVo board, UserVo user);

	void deleteBoard(Integer num, UserVo user);

	void views(Integer num);

	int getTotalCount(Criteria cri);

	void registerFile(int num, String originalFilename, String path);

	ArrayList<FileVo> getFileList(Integer num);

	void deleteFile(int num);

	void updateLike(LikeVo likeVo);

}








