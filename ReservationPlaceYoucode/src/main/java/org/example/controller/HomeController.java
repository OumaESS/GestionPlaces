package org.example.controller;

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

	private UsersEntity user;

	//display login
	@RequestMapping(value="/")
	public String DisplayLogin(@ModelAttribute("userlogin") UsersEntity usersEntity)
	{
		return "login";
	}


	// Authentification
	@RequestMapping(value="/prosseForm")
	public String ProsseLogin(@ModelAttribute("userlogin") UsersEntity usersEntity, HttpSession session)
	{

		//instantiation loginReposotory
		LoginRepostory loginRepostory=new LoginRepostory();

		//une fois on fais l'instontiation on a le droit d'appeler lett les méthode de classe
		user=  loginRepostory.getUserByEmailPassword(usersEntity.getEmail(), usersEntity.getPassword()); //si il trouve les mêmes email et psw il va retourné USER
		AuthenticatedUser.user = user;
		if (user != null && user.isAccepted()==true) {
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


	//get liste Type Reservation in input select

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
	//on déclare mode attribute on le donne un nom
	public String DisplayRegestre(@ModelAttribute("student") StudentEntity studentEntity)
	{
		return "inscription"; //fichier jsp
	}



    //Inscription

	@RequestMapping(value = "registerForm", method = RequestMethod.POST)
	//http request pour la confirmation du psw
	public String register(HttpServletRequest request, @ModelAttribute("student") StudentEntity studentEntity){
		String Cpass = request.getParameter("re_pass"); //re_pass nom d'inpote
		if (Cpass.equals(studentEntity.getPassword())){
			studentEntity.setReservationMax(3);
			RoleEntity roleEntity = roleDao.getRoleById(2);
			studentEntity.setRole(roleEntity);
			userService.addUser(studentEntity); //confirmation false par défaut
			System.out.println(studentEntity.getFirstName());
			return "redirect:/loginDirect"; //URL
		}else{
			return "login";
		}

	}

}
