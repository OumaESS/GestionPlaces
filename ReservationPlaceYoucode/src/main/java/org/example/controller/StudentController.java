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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private UserService userService;



    @RequestMapping(value = "/prossecRes")
    public  String ProsseRes(@ModelAttribute("res") ReservationEntity reservationEntity)
    {
        System.out.println(reservationEntity.getTypeRes().getId());
        reservationEntity.setUser(AuthenticatedUser.user);
       reservationService.addRes(reservationEntity);
        return "redirect:/dashbord";

    }


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

    @RequestMapping(value = "EditPfS")
    public String Edit(@ModelAttribute("EditPfS") UseradminEntity useradminEntity,Model model,HttpSession session)
    {
        Object idUser=session.getAttribute("id");
        useradminEntity=userService.getUserById((Integer) idUser);
        model.addAttribute("user",useradminEntity);
        return "EdtiProfileST";
    }


    @RequestMapping(value = "ProsseModifPr")
    public String ModifProfile(HttpServletRequest req, HttpSession session)
    {
        Object idUser=session.getAttribute("id");
        int id=(Integer)idUser;
        String FName=req.getParameter("firstName");
        String LName=req.getParameter("lastName");
        String email=req.getParameter("email");
        String password=req.getParameter("password");

        UseradminEntity useradminEntity=new UseradminEntity(id,FName,LName,email,password);

        userService.updateUser(useradminEntity);

        AuthenticatedUser.user=useradminEntity;

        session.setAttribute("Fname",AuthenticatedUser.user.getFirstName());
        session.setAttribute("lasname",AuthenticatedUser.user.getLastName());
        return "redirect:/dashbord";
    }

    @RequestMapping(value = "deleteRestudent")
    public String deleteRes(HttpServletRequest req)
    {

        int id= Integer.parseInt(req.getParameter("id"));

        reservationService.deleteRes(id);

        return "redirect:/dashbord";
    }

}
