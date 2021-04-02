package org.example.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.example.DAO.RoleDaoImpl;
import org.example.Entity.*;
import org.example.Global.AuthenticatedUser;
import org.example.Repostory.LoginRepostory;
import org.example.service.TypeResService;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleDaoImpl roleDao;

@Autowired
private TypeResService typeResService;

	private UseradminEntity user;


//	@RequestMapping(value="/")
//	public ModelAndView test(HttpServletResponse response) throws IOException{
//		return new ModelAndView("login");
//	}

	//display login
	@RequestMapping(value="/")
	public String DisplayLogin(@ModelAttribute("userlogin") UseradminEntity useradminEntity)
	{
		return "login";
	}


	// Authentification
	@RequestMapping(value="/prosseForm")
	public String ProsseLogin(@ModelAttribute("userlogin") UseradminEntity useradminEntity, HttpSession session)
	{

		LoginRepostory loginRepostory=new LoginRepostory();

		user=  loginRepostory.getUserByEmailPassword(useradminEntity.getEmail(),useradminEntity.getPassword());
		AuthenticatedUser.user = user;
		if (user != null && user.getPassword().equals(useradminEntity.getPassword()) && user.isAccepted()==true) {
			session.setAttribute("id",AuthenticatedUser.user.getId());
			session.setAttribute("Fname",AuthenticatedUser.user.getFirstName());
			session.setAttribute("lasname",AuthenticatedUser.user.getLastName());
			if (user.getRole().getRoleName().equals("admin")) {
				return "redirect:/dashbordadmin";
			} else if (user.getRole().getRoleName().equals("student")) {
				return "redirect:/dashbord";
			}
		}
		return "redirect:/";
	}


	//Set User ver dashbord




	@RequestMapping(value = "Res")
	public String DisplayAddRes(@ModelAttribute("res") ReservationEntity reservationEntity,Model model)
	{
		List<TypereservationEntity> typeList = typeResService.getAllTypeRes();
		model.addAttribute("list", typeList);
		return "AddRes";
	}


    //Redirect Login
	@RequestMapping(value = "loginDirect")
	public String loginDerict(){

		return "redirect:/";
	}


	//Display Regestre

	@RequestMapping(value="regestre")
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

}
