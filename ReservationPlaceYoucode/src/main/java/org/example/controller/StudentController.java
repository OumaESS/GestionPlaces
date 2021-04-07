package org.example.controller;


import org.example.Entity.*;
import org.example.Global.AuthenticatedUser;
import org.example.Repostory.ReservationRepostory;
import org.example.service.ReservationService;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private UserService userService;



    //les cliques pour ajouter un reserv
    @RequestMapping(value = "/prossecRes")
    public  String ProsseRes(@ModelAttribute("res") ReservationEntity reservationEntity)
    {
        System.out.println(reservationEntity.getTypeRes().getId());
        reservationEntity.setUser(AuthenticatedUser.user);
       reservationService.addRes(reservationEntity);
        return "redirect:/dashbord";

    }


    //l'afficahge du dashbord
    @RequestMapping(value = "dashbord")
    public String rege(@ModelAttribute("dashbord") ReservationEntity reservationEntity, Model model, HttpSession session){

        if(session.getAttribute("id")!=null)
        {
            ReservationRepostory reservationRepostory=new ReservationRepostory();
            Object idUser=session.getAttribute("id");
            System.out.println(idUser);
            List<ReservationEntity> reservations = reservationRepostory.getAllReservationsById((Integer) idUser);

            model.addAttribute("reservations",reservations);
            System.out.println(reservations);

            return "DashbordStudent";
        }
        else
        {
            return "redirect:/loginDirect";

        }

    }


    //affichage du page edite profile
    @RequestMapping(value = "EditPfS")
    public String Edit(@ModelAttribute("EditPfS") UsersEntity usersEntity, Model model, HttpSession session)
    {
        Object idUser=session.getAttribute("id");
        usersEntity =userService.getUserById((Integer) idUser);
        model.addAttribute("user", usersEntity);
        return "EdtiProfileST";
    }


    //update profil
    @RequestMapping(value = "ProsseModifPr")
    public String ModifProfile(HttpServletRequest req, HttpSession session)
    {
        Object idUser=session.getAttribute("id");
        int id=(Integer)idUser;
        String FName=req.getParameter("firstName");
        String LName=req.getParameter("lastName");
        String email=req.getParameter("email");
        String password=req.getParameter("password");

        UsersEntity usersEntity =new UsersEntity(id,FName,LName,email,password);

        userService.updateUser(usersEntity);

        AuthenticatedUser.user= usersEntity;

        session.setAttribute("Fname",AuthenticatedUser.user.getFirstName());
        session.setAttribute("lasname",AuthenticatedUser.user.getLastName());
        return "redirect:/dashbord";
    }

    //delete reserv
    @RequestMapping(value = "deleteRestudent")
    public String deleteRes(HttpServletRequest req)
    {

        int id= Integer.parseInt(req.getParameter("id"));

        reservationService.deleteRes(id);

        return "redirect:/dashbord";
    }

}
