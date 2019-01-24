package com.accolite.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.accolite.springmvc.config.ConnectionDetails;
import com.accolite.springmvc.dao.ConnectionClasstoDatabase;
import com.accolite.springmvc.model.LoginUserFeilds;
import com.accolite.springmvc.model.UserDetails;

@Controller
public class LoginController {
	
	ConnectionDetails cd = new ConnectionDetails();
	ConnectionClasstoDatabase dc = cd.userdao();
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public ModelAndView getString() {
		System.out.println("In /login reuqest");
		return new ModelAndView("login");
	
	}
	
	@RequestMapping(value="/login1", method=RequestMethod.POST)
	public ModelAndView loginUser(HttpServletRequest request,@RequestParam("userName") String userName
			,@RequestParam("password") String password ) {
		
		System.out.println("In /login reuqest");
		
		LoginUserFeilds loginUser=new LoginUserFeilds();
		loginUser.setUname(userName);
		loginUser.setPassword(password);
		UserDetails user=dc.validateUser(loginUser);
		if(user!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("user", user);
			return new ModelAndView("update","message","");
		}
		else
			return new ModelAndView("login","message","Invalid Username or password");
	}
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView registerUser(HttpServletRequest request,@RequestParam("userName") String userName
			,@RequestParam("password") String password, @RequestParam("age") int age, @RequestParam("email") String email ){
		
		UserDetails ud = new UserDetails();
		ud.setUserName(userName);
		ud.setPassword(password);
		ud.setAge(age);
		ud.setEmail(email);
		boolean flag  = dc.register(ud);
		if(flag == true)
			return new ModelAndView("login");
		else
			return new ModelAndView("login");
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public ModelAndView registerPage() {
		return new ModelAndView("register");
	}
	
	@RequestMapping(value="/lusers")
	public ModelAndView listUsers() {
		System.out.println("In list of Users");
		ModelAndView mv=new ModelAndView("listusers");
		List<UserDetails> users = new ArrayList<UserDetails>();
		users=dc.getAll();
		mv.addObject("users", users);
		return mv;

	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public ModelAndView update(HttpServletRequest request,@RequestParam("userName") String userName
			, @RequestParam("age") int age, @RequestParam("email") String email) {
		
		UserDetails user=new UserDetails();
		user.setUserName(request.getParameter("userName"));
		user.setAge(Integer.parseInt(request.getParameter("age")));
		user.setEmail(request.getParameter("email"));
		int res = dc.update(user);
		ModelAndView mv=new ModelAndView("logout","message","updated");
		List<UserDetails> users=new ArrayList<UserDetails>();
		users=dc.getAll();
		mv.addObject("users", users);
		return mv;
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public ModelAndView logout() {
		return new ModelAndView("login");
	}
	@RequestMapping(value="/listtologin")
	public ModelAndView redirectToLogin() {
		return new ModelAndView("login");
	}
}
