package kr.green.study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	//서버=>화면으로 데이터 보내는 예제
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView homeGet(ModelAndView mv) {
		mv.addObject("name","임꺽정");
		mv.addObject("num",20);
		mv.setViewName("/main/home");
		return mv;
	}
	//화면=>서버로 데이터 보내는 예제
	@RequestMapping(value = "/data/get", method = RequestMethod.GET)
	public ModelAndView dataGet(ModelAndView mv, String name, Integer num) {
		System.out.println("/data/get : 화면에서 넘어온 정보");
		System.out.println("name : " + name);
		System.out.println("num  : " + num);
		mv.setViewName("redirect:/");
		return mv;
	}
	
}
