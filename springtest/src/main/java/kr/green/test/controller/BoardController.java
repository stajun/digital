package kr.green.test.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.green.test.pagination.Criteria;
import kr.green.test.pagination.PageMaker;
import kr.green.test.service.BoardService;
import kr.green.test.service.UserService;
import kr.green.test.utils.UploadFileUtils;
import kr.green.test.vo.BoardVo;
import kr.green.test.vo.FileVo;
import kr.green.test.vo.LikeVo;
import kr.green.test.vo.UserVo;

@Controller
public class BoardController {
	@Autowired
	BoardService boardService;
	@Autowired
	UserService userService;
	
	private String uploadPath = "D:\\JAVA_JIK\\upfile";
	
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	//현재 페이지정보를 화면에서 전달받아옴(매개변수) : Criteria cri
	public ModelAndView boardListGet(ModelAndView mv, HttpServletRequest request, Criteria cri) {
		//(수정) 전체 게시글을 가져오는 서비스의 getBoardList()를
    //현재 페이지글을 가져오는 getBoardList(cri)로 수정
		ArrayList<BoardVo> list = boardService.getBoardList(cri);
		//페이지네이션기능 : 서비스에게 전체 게시글 갯수를 알려 달라고 요청하여 변수에 저장
		//int totalCount = boardService.getTotalCount();
		//페이지네이션 + 검색 기능 : 서비스에게 전체 게시글이 아닌 현재 페이지 정보에 
		//(검색타입, 검색어 포함)맞는 게시글을 가져오라고 요청하도록 수정
		int totalCount = boardService.getTotalCount(cri);
		//한 페이지네이션에서 보여줄 최대 페이지 수를 임의로 선정하여 변수에 저장
		int displayPageNum = 2;
		//현재페이지정보, displayPageNum, 전체 게시글 수를 이용하여 새로운 PageMaker 객체를 생성
		PageMaker pm = new PageMaker(totalCount,displayPageNum, cri);
		//생성된 PageMaker를 화면에 전송
		mv.addObject("pm", pm);
		mv.addObject("boardList", list);
		mv.setViewName("/board/list");
		return mv;
	}
	
	@RequestMapping(value = "/board/detail", method = RequestMethod.GET)
	public ModelAndView boardDetailGet(ModelAndView mv,Integer num, Criteria cri, HttpServletRequest request) {
		//조회수 증가
		boardService.views(num);
		//게시글 정보 가져오기
		BoardVo board = boardService.getBoard(num);
		//첨부파일 정보 가져오기
		ArrayList<FileVo> fileList = boardService.getFileList(num);
		
		UserVo user = userService.getUser(request);
		//로그인 한 경우에만 추천/비추천 정보를 가져와서 화면에 전달
		if(user != null) {
			LikeVo like = new LikeVo(num,user.getId());
			LikeVo dbLike = boardService.getLike(like);
			mv.addObject("like", dbLike);
		}
		mv.addObject("fList", fileList);
		mv.addObject("cri", cri);
		mv.addObject("board", board);
		mv.setViewName("/board/detail");
		return mv;
	}
	
	@RequestMapping(value = "/board/register", method = RequestMethod.GET)
	public ModelAndView boardRegisterGet(ModelAndView mv) {
		mv.setViewName("/board/register");
		return mv;
	}
	@RequestMapping(value = "/board/register", method = RequestMethod.POST)
	public ModelAndView boardRegisterPost(ModelAndView mv, BoardVo board, MultipartFile[] fileList) throws IOException, Exception {
		
		boardService.registerBoard(board);
		//첨부파일 배열에 첨부파일이 있으면
		if(fileList != null && fileList.length != 0) {
			for(MultipartFile file : fileList) {
				//화면에서 넘어온 파일이 있고, 파일명이 0글자가 아닐때
				if(file != null && file.getOriginalFilename().length() != 0) {
					//파일을 업로드하고, 업로드된 경로를 path에 저장
					String path = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(),file.getBytes());
					//DB에 첨부파일 정보를 추가
					boardService.registerFile(board.getNum(), file.getOriginalFilename(), path);
				}
			}
		}
		
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	@RequestMapping(value = "/board/modify", method = RequestMethod.GET)
	public ModelAndView boardModifyGet(ModelAndView mv,Integer num) {
		BoardVo board = boardService.getBoard(num);
		ArrayList<FileVo> fileList = boardService.getFileList(num);
		
		mv.addObject("fileList", fileList);
		mv.addObject("board",board);
		mv.setViewName("/board/modify");
		return mv;
	}
	@RequestMapping(value = "/board/modify", method = RequestMethod.POST)
	public ModelAndView boardModifyPost(ModelAndView mv,BoardVo board, HttpServletRequest request, MultipartFile [] fileList) throws IOException, Exception {
		UserVo user = userService.getUser(request);
		boardService.modifyBoard(board, user);
		//기존 첨부파일 삭제
		boardService.deleteFile(board.getNum());
		//새 첨부파일 업로드 및 DB 추가
		if(fileList != null && fileList.length != 0) {
			for(MultipartFile file : fileList) {
				if(file != null && file.getOriginalFilename().length() != 0) {
					String path = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(),file.getBytes());
					boardService.registerFile(board.getNum(), file.getOriginalFilename(), path);
				}
			}
		}
	
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	@RequestMapping(value = "/board/delete", method = RequestMethod.GET)
	public ModelAndView boardDeleteGet(ModelAndView mv,Integer num,HttpServletRequest request) {
		System.out.println("/board/delete : num="+num);
		UserVo user = userService.getUser(request);
		System.out.println("/board/delete : user="+user);
		boardService.deleteBoard(num, user);
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value="/board/download")
	public ResponseEntity<byte[]> downloadFile(String filename)throws Exception{
	    InputStream in = null;
	    ResponseEntity<byte[]> entity = null;
	    try{
	        HttpHeaders headers = new HttpHeaders();
	        in = new FileInputStream(uploadPath+filename);

	        filename = filename.substring(filename.indexOf("_")+1);
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	        headers.add("Content-Disposition",  "attachment; filename=\"" 
				+ new String(filename.getBytes("UTF-8"), "ISO-8859-1")+"\"");
	        entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in),headers,HttpStatus.CREATED);
	    }catch(Exception e) {
	        e.printStackTrace();
	        entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
	    }finally {
	        in.close();
	    }
	    return entity;
	}
	@RequestMapping(value = "/board/like", method = RequestMethod.POST)
	@ResponseBody
	public String boardLikeGet(LikeVo likeVo) {
		boardService.updateLike(likeVo);
		return "ok";
	}
}


















