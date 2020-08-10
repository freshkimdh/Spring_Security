package edu.bit.ex;

import java.security.Principal;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
@Log4j
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@GetMapping("/admin/adminHome")
	public void adminHome() { // void는 "/admin/adminHome" 경로 가지고 오는 것 
		log.info("adminHome...");
	}
	
	@GetMapping("/user/userHome")
	public void userHome() { // void는 "/admin/adminHome" 경로 가지고 오는 것 
		log.info("adminHome...");
	}
	
	@GetMapping("/login/loginForm")
	public String loginForm() { 
		log.info("Welcom Login Form!");
		return "login/loginForm";
	}
	
	@GetMapping("/login/accessDenied")
	public void accessDenied() { 
		log.info("Welcom Login Form!");
	}
	
	@GetMapping("/loginInfo")
	public String loginInfo(Principal principal) { 
		log.info("loginInfo");
		
		String user_id;
		
		//1. SpringContextHolder를 통하여 가져오는 방법(일반적인 빈에서 사용 할 수 있음)
		
		//다이렉트로 SecurityContextHolder 이용하는 방법이 있다.
		//어디서 기본적으로 쓰이냐??
		//진짜 목적은 UserDetails 이것을 가지고 오는 것이다.
		//결국에는 이것을 꺼내오려고 하는 것.
		//UserDetails 여기에 유저의 권한,활성 이 있네 없네 하는 것이다.
		//내부적으로 해당 sql 읽으면 UserDetails 이놈이 해당 유저의 정보를 여기에 담아 온다.	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();  //인증 정보를 가져옴
		user_id = auth.getName(); 
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		
		System.out.println("유저 아이디: " + userDetails.getUsername());
		
		
		//2. Controller를 통하여 principal 객체로 가져오는 방법
		//컨트롤러에서는 Principal 존재 하는데, 내부에서는 겟 네임하고
		// 시큐리티 -> get _>  ㄱpri
		// 시큐리티홀더 -> authriccatrion(인증) -> 프린시퍼 -> userdetalil -> user
		//db에서 제공하는 5개 객체 외우자!!
		
		UserDetails userDetail = (UserDetails) principal;
		System.out.println(userDetail.getUsername());
		
		
		
		//3. User 클래스로 변환 하여 가져오는 방법
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		System.out.println(user.getUsername());
		
		return "home";
	}
	
	
	
	
	
	
	
}
