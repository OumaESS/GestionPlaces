package org.example.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.DAO.RoleDaoImpl;
import org.example.Entity.*;
import org.example.Repostory.LoginRepostory;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleDaoImpl roleDao;



	private UseradminEntity user;


	//display login
	@RequestMapping(value="/")
	public String DisplayLogin(@ModelAttribute("userlogin") UseradminEntity useradminEntity)
	{
		return "login";
	}


	// Authentification
	@RequestMapping(value="/prosseForm")
	public String ProsseLogin(@ModelAttribute("userlogin") UseradminEntity useradminEntity,Model model)
	{

		LoginRepostory loginRepostory=new LoginRepostory();

		user=  loginRepostory.getUserByEmailPassword(useradminEntity.getEmail(),useradminEntity.getPassword());
		if (user != null && user.getPassword().equals(useradminEntity.getPassword())) {
			if (user.getRole().getRoleName().equals("admin")) {
				return "redirect:/regestre";
			} else if (user.getRole().getRoleName().equals("student")) {
				return "redirect:/hello";
			}
		}
		return "redirect:/";
	}


    //Redirect Login
	@RequestMapping(value = "/loginDirect")
	public String loginDerict(){
		return "login";
	}


	//Display Regestre

	@RequestMapping(value="/regestre")
	public String DisplayRegestre(@ModelAttribute("student") StudentEntity studentEntity)
	{
		return "inscription";
	}



    //Inscription
	@RequestMapping(value = "registerForm", method = RequestMethod.POST)
	public String register(HttpServletRequest request, @ModelAttribute("student") StudentEntity studentEntity){
		String Cpass = request.getParameter("re_pass");
		if (Cpass.equals(studentEntity.getPassword())){
			studentEntity.setReservationMax(3);
			RoleEntity roleEntity = roleDao.getRoleById(2);
			studentEntity.setRole(roleEntity);
			userService.addUser(studentEntity);
			System.out.println(studentEntity.getFirstName());
			return "home";
		}else{
			return "login";
		}


	}
	@RequestMapping(value = "/hello")
	public String DisplayHello()
	{
		return "home";
	}

}
