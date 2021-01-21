package kr.green.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.service.UserService;
import kr.green.spring.vo.TestVo;
import kr.green.spring.vo.UserVo;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView homeGet(ModelAndView mv, String name) {
		mv.setViewName("/main/login");
		return mv;
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signupGet(ModelAndView mv) {
		mv.setViewName("/main/signup");
		return mv;
	}
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView signupPost(ModelAndView mv,UserVo user) {
		System.out.println(user);
		//회원가입을 진행시키기 위해 userService에게 일을 시키기위한 메소드를 생성해
		//보세요.
		boolean isSignup = userService.signup(user);
		if(isSignup) {
			mv.setViewName("redirect:/login");	
		}else {
			mv.setViewName("redirect:/signup");
		}
		return mv;
	}
	
	@RequestMapping(value = "/user/list", method = RequestMethod.GET)
	public ModelAndView userListGet(ModelAndView mv) {
		ArrayList<UserVo> list = new ArrayList<UserVo>();
		//모든 회원 정보를 가져오는 코드
		list = userService.getAllUser();
		mv.addObject("list",list);
		mv.setViewName("/main/list2");
		return mv;
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginGet(ModelAndView mv) {
		mv.setViewName("/main/login");
		return mv;
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginPost(ModelAndView mv, String id, String pw) {
		//수정전 : id와 pw가 일치하는 회원이 있으면 true,
		//       없으면 false를 가져옴
		//수정후 : id와 pw가 일치하는 회원이 있으면 회원 정보를 가져오고,
		//       없으면 null을 가져옴
		//boolean isUser = userService.isUser(id, pw);
		UserVo isUser = userService.isUser(id, pw);
		
		mv.addObject("user", isUser);
		if(isUser != null) {
			mv.setViewName("redirect:/");//로그인 성공시
			//localhost:8080/spring/
		}else {
			mv.setViewName("redirect:/login");//로그인 실패시
			//localhost:8080/spring/login
		}
		return mv;
	}
	@RequestMapping(value = "/signout", method = RequestMethod.GET)
	public ModelAndView signoutGet(ModelAndView mv,HttpServletRequest r) {
		//세션에 저장된 user 정보를 삭제
		r.getSession().removeAttribute("user");
		mv.setViewName("redirect:/");
		return mv;
	}
	@RequestMapping(value = "/ajax1", method = RequestMethod.POST)
	@ResponseBody
	public String ajax1Post(TestVo testVo) {
		System.out.println("ajax 테스트 성공!");
		System.out.println(testVo);
		return testVo.toString();
	}
	
	@RequestMapping(value = "/dup", method = RequestMethod.POST)
	@ResponseBody
	public String dupPost(String id) {
		UserVo user = userService.getUser(id);
		if(user == null)
			return "not user";
		return "user";
	}
	
	@RequestMapping(value = "/ajax2", method = RequestMethod.POST)
	@ResponseBody
	public Object ajax2Post(@RequestBody TestVo testVo) {
		HashMap<String, Object> map = new HashMap<String,Object>();
		ArrayList<UserVo> list = userService.getAllUser();
		map.put("list", list);
		map.put("testVo", testVo);
		return map;
	}
	@RequestMapping(value = "/author/modify", method = RequestMethod.POST)
	@ResponseBody
	public Object authorModifyPost(@RequestBody UserVo userVo) {
		userService.updateAuthor(userVo);
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		return map;
	}
	@RequestMapping(value = "/find/pw", method = RequestMethod.GET)
	public ModelAndView findPwGet(ModelAndView mv) {

		mv.setViewName("/main/findpw");
		return mv;
	}
	@RequestMapping(value = "/find/pw", method = RequestMethod.POST)
	@ResponseBody
	public Object findPwPost(@RequestBody UserVo user) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		UserVo dbUser = userService.getUser(user.getId());
		if(dbUser == null)
			map.put("result", "비회원");
		else {
			//비밀번호 랜덤으로 새로 생성
			/* 비밀번호는 8자
			 * 비밀번호는 0~9, a~z, A~Z에서 랜덤으로 선택해서 새 비밀번호 생성
			 * 랜덤으로 0~61사이의 숫자를 뽑아서 0~9면 그냥 숫자로
			 * 10~35면 소문자 a~z로
			 * 36~61면 대문자 A~Z로
			 * 예시 : 랜덤 숫자가 9 24 36 60 10 1 4 35 이면
			 *       만들어진 비밀번호는 9oAa14z
			 */
			int size = 8;
			String newPw = "";
			for(int i=0; i<8; i++) {
				int r = (int)(Math.random()*62);
				char ch;
				if( r <= 9) {
					//숫자 0~9를 문자 '0'~'9'로 만드는 코드
					ch = (char)('0' + r);
				}else if(r <= 35) {
					//숫자 10~35를 문자 'a'~'z'로 만드는 코드
					ch = (char)('a' + (r-10));
				}else {
					//숫자 36~61를 문자 'A'~'Z'로 만드는 코드
					ch = (char)('A' + (r-36));
				}
				newPw += ch;
			}
			System.out.println(newPw);
			//새 비밀번호 DB에 업데이트
			dbUser.setPw(newPw);
			userService.updateUser(dbUser);
			
			//새 비밀번호 메일로 전송
			String setfrom = "stajun@gmail.com";         
	    String tomail  = dbUser.getEmail(); // 받는 사람 이메일
	    String title   = "비밀번호 찾기";      // 제목
	    String content = "새 비밀번호 : " + newPw;    				// 내용

	    try {
	        MimeMessage message = mailSender.createMimeMessage();
	        MimeMessageHelper messageHelper 
	            = new MimeMessageHelper(message, true, "UTF-8");

	        messageHelper.setFrom(setfrom);  // 보내는사람 생략하거나 하면 정상작동을 안함
	        messageHelper.setTo(tomail);     // 받는사람 이메일
	        messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
	        messageHelper.setText(content);  // 메일 내용

	        mailSender.send(message);
	    } catch(Exception e){
	        System.out.println(e);
	        map.put("result", "실패");
	        return map;
	    }
						
			map.put("result", "성공");
		}
		return map;
	}
	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public ModelAndView mypageGet(ModelAndView mv) {

		mv.setViewName("/main/mypage");
		return mv;
	}
	@RequestMapping(value = "/mypage", method = RequestMethod.POST)
	public ModelAndView mypagePost(ModelAndView mv, UserVo user,HttpServletRequest request) {
		//화면에서 넘겨준 정보 가져오기
		//화면에서 넘겨준 정보를 이용하여 DB에 정보 수정하기
		userService.updateUser(user);
		//세션에 저장된 회원 정보 수정하기
		System.out.println(user);
		request.getSession().setAttribute("user", user);
		mv.setViewName("redirect:/mypage");
		return mv;
	}
}





