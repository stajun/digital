package kr.green.test.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.test.pagination.Criteria;
import kr.green.test.vo.BoardVo;
import kr.green.test.vo.FileVo;
import kr.green.test.vo.LikeVo;

public interface BoardDao {

	ArrayList<BoardVo> getBoardList(@Param("cri")Criteria cri);

	BoardVo getBoard(@Param("num")Integer num);

	void insertBoard(@Param("board")BoardVo board);

	void updateBoard(@Param("board")BoardVo oriBoard);

	void updateViews(@Param("num")Integer num);

	int getTotalCount(@Param("cri")Criteria cri);

	void insertFile(@Param("num")int num, @Param("filename")String originalFilename, @Param("path")String path);

	ArrayList<FileVo> getFileList(@Param("num")Integer num);

	void deleteFile(@Param("num")int num);

	LikeVo getLike(@Param("like")LikeVo likeVo);

	void insertLike(@Param("like")LikeVo likeVo);

	void updateLike(@Param("like")LikeVo likeVo);

}








