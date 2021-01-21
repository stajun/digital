package kr.green.spring.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.pagination.Criteria;
import kr.green.spring.pagination.PageMaker;
import kr.green.spring.service.BoardService;
import kr.green.spring.service.UserService;
import kr.green.spring.utils.UploadFileUtils;
import kr.green.spring.vo.BoardVo;
import kr.green.spring.vo.FileVo;
import kr.green.spring.vo.LikeVo;
import kr.green.spring.vo.UserVo;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	@Autowired
	UserService userService;
	
	private String uploadPath="D:\\JAVA_JIK\\upfile";
	
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public ModelAndView boardListGet(ModelAndView mv,Criteria cri) {
		System.out.println("현재 페이지 정보 : "+cri);
		ArrayList<BoardVo> list = boardService.getBoardList(cri);
		int totalCount = boardService.getTotalCount(cri);
		
		PageMaker pm = new PageMaker(cri, 2, totalCount);

		mv.addObject("pm",pm);
		mv.addObject("list", list);		
		mv.setViewName("/board/list");
		return mv;
	}
	@RequestMapping(value = "/board/detail", method = RequestMethod.GET)
	public ModelAndView boardDetailGet(ModelAndView mv,Integer num,Criteria cri,
			HttpServletRequest request) {
		//해당 게시글의 조회수를 증가
		boardService.view(num);
		BoardVo board = boardService.getBoard(num);
		ArrayList<FileVo> fList = boardService.getFileList(num);
		
		UserVo user = userService.getUser(request);
		LikeVo like = boardService.getLike(num, user);
		
		ArrayList<Integer> alist = new ArrayList<Integer>();
		alist.add(1);
		alist.add(2);
		alist.add(3);
		alist.add(4);
		alist.add(5);
		mv.addObject("alist",alist);
		
		mv.addObject("like",like);
		mv.addObject("fList", fList);
		mv.addObject("board", board);
		mv.addObject("cri", cri);
		mv.setViewName("/board/detail");
		return mv;
	}
	@RequestMapping(value = "/board/register", method = RequestMethod.GET)
	public ModelAndView boardRegisterGet(ModelAndView mv) {
	
		mv.setViewName("/board/register");
		return mv;
	}
	@RequestMapping(value = "/board/register", method = RequestMethod.POST)
	public ModelAndView boardRegisterPost(ModelAndView mv,BoardVo board, MultipartFile[] fileList) throws IOException, Exception {
		boardService.registerBoard(board);

		
		if(fileList != null) {
			for(MultipartFile file : fileList) {
				if(file != null && file.getOriginalFilename().length() != 0) {
					String fileName = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(),file.getBytes());
					boardService.registerFile(board.getNum(),file.getOriginalFilename(),fileName);
				}
			}
		}
		
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	@RequestMapping(value = "/board/modify", method = RequestMethod.GET)
	public ModelAndView boardModifyGet(ModelAndView mv, Integer num) {
		BoardVo board = boardService.getBoard(num);
		
		ArrayList<FileVo> fList = boardService.getFileList(num);
		mv.addObject("fList", fList);
		
		mv.addObject("board", board);
		mv.setViewName("/board/modify");
		return mv;
	}
	@RequestMapping(value = "/board/modify", method = RequestMethod.POST)
	public ModelAndView boardModifyPost(
			ModelAndView mv, 
			BoardVo board, 
			HttpServletRequest request,
			MultipartFile[] fileList) throws IOException, Exception {
		
		UserVo user = userService.getUser(request);
		boardService.modifyBoard(board,user);
		if(fileList != null) {
			System.out.println("수정될 첨부파일 갯수 : "+fileList.length);
			for(MultipartFile file : fileList) {
				if(file != null && file.getOriginalFilename().length() != 0) {
					String fileName = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(),file.getBytes());
					System.out.println("추가된 파일명 : " + fileName);
					boardService.registerFile(board.getNum(),file.getOriginalFilename(),fileName);
				}
			}
		}
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	@RequestMapping(value = "/board/delete", method = RequestMethod.GET)
	public ModelAndView boardDeleteGet(ModelAndView mv,Integer num,HttpServletRequest request) {
		UserVo user = userService.getUser(request);
		boardService.deleteBoard(num, user);
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	@ResponseBody
	@RequestMapping(value="/board/download")
	public ResponseEntity<byte[]> downloadFile(String fileName)throws Exception{
	    InputStream in = null;
	    ResponseEntity<byte[]> entity = null;
	    try{
	        HttpHeaders headers = new HttpHeaders();
	        in = new FileInputStream(uploadPath+fileName);

	        fileName = fileName.substring(fileName.indexOf("_")+1);
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	        headers.add("Content-Disposition",  "attachment; filename=\"" 
				+ new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\"");
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
	public Object authorModifyPost(@RequestBody LikeVo likeVo) {
		System.out.println("/board/like : " + likeVo);
		boardService.like(likeVo);		
		HashMap<String, Object> map = new HashMap<String, Object>();
		return map;
	}
}









