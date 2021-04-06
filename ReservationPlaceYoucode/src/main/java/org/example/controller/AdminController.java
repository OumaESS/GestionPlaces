package org.example.controller;

import org.example.Entity.ReservationEntity;
import org.example.Entity.UsersEntity;
import org.example.Global.AuthenticatedUser;
import org.example.Repostory.ReservationRepostory;
import org.example.Repostory.UserRepostory;
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
public class AdminController {


    @Autowired
    private UserService userService;

    @Autowired
    private ReservationService reservationService;




    //Afficher la listes des users in dashbord admin
    @RequestMapping(value = "dashbordadmin")
    public String rege(@ModelAttribute("dashbord") UsersEntity usersEntity, Model model, HttpSession session){

        if(session.getAttribute("id")!=null)
        {
            UserRepostory userRepostory=new UserRepostory();

            List<UsersEntity> users = userRepostory.getAllStudents();

            model.addAttribute("users",users);
            System.out.println(users);

            return "AdmiDashbord";
        }

        else
        {
            return "redirect:/loginDirect";

        }
    }


    //Confermation Compte Student
    @RequestMapping(value = "confiEmail")
    public String ConfirmEmail(HttpServletRequest req)
    {
        UserRepostory userRepostory=new UserRepostory();
        int id= Integer.parseInt(req.getParameter("id"));

      boolean accpeted=AuthenticatedUser.user.setAccepted(true);

        UsersEntity usersEntity =new UsersEntity(id,accpeted);

        userRepostory.updateUserAccpect(usersEntity);




        return "redirect:/dashbordadmin";
    }


    //Refuser le compte de student
    @RequestMapping(value = "deleteEmail")
    public String deletemEmail(HttpServletRequest req)
    {

        UserRepostory userRepostory=new UserRepostory();
        int id= Integer.parseInt(req.getParameter("id"));

        boolean accpeted=AuthenticatedUser.user.setAccepted(false);

        UsersEntity usersEntity =new UsersEntity(id,accpeted);

        userRepostory.updateUserAccpect(usersEntity);

        return "redirect:/dashbordadmin";
    }



    //Afficher les Reservation des apprenants dans le dashbord admin

    @RequestMapping(value = "ShowRes")
    public String ShoweRes(@ModelAttribute("dashbord")ReservationEntity reservationEntity, Model model){



        List<ReservationEntity> reservations = reservationService.getAllRes();

        model.addAttribute("res",reservations);


        return "ShowReservation";
    }



    //Confermation Reservation
    @RequestMapping(value = "confiRes")
    public String ConfirRes(HttpServletRequest req)
    {


        ReservationEntity res=new ReservationEntity();
        ReservationRepostory resevationRepostory=new ReservationRepostory();
        int id= Integer.parseInt(req.getParameter("id"));

        boolean accpeted=res.setConfirmation(true);

        ReservationEntity reservationEntity=new ReservationEntity(id,accpeted);

        resevationRepostory.Confirm(reservationEntity);


        return "redirect:/ShowRes";
    }


    //Refuser les reservations des apprenants
    @RequestMapping(value = "deleteRes")
    public String deleteRes(HttpServletRequest req)
    {

        ReservationEntity res=new ReservationEntity();
        ReservationRepostory resevationRepostory=new ReservationRepostory();
        int id= Integer.parseInt(req.getParameter("id"));

        boolean accpeted=res.setConfirmation(true);

        ReservationEntity reservationEntity=new ReservationEntity(id,accpeted);

        resevationRepostory.Confirm(reservationEntity);

        return "redirect:/ShowRes";
    }


    //Display Profil admin formulair
    @RequestMapping(value = "EditPfAdmin")
    public String Edit(@ModelAttribute("EditPfS") UsersEntity usersEntity, Model model, HttpSession session)
    {
        Object idUser=session.getAttribute("id");
        usersEntity =userService.getUserById((Integer) idUser);
        model.addAttribute("user", usersEntity);
        return "EditePrAdmin";
    }


    // Modif Profile
    @RequestMapping(value = "ProsseModifPrAdmin")
    public String ModifProfile(HttpServletRequest req, HttpSession session)
    {
        Object idUser=session.getAttribute("id");
        int id=(Integer)idUser;
        String FName=req.getParameter("firstName");
        String LName=req.getParameter("lastName");
        String email=req.getParameter("email");
        String password=req.getParameter("password");

        //constructeur d'initialisation contien les paramètres
        UsersEntity usersEntity =new UsersEntity(id,FName,LName,email,password);

        userService.updateUser(usersEntity);

        AuthenticatedUser.user= usersEntity;

        session.setAttribute("Fname",AuthenticatedUser.user.getFirstName());
        session.setAttribute("lasname",AuthenticatedUser.user.getLastName());
        return "redirect:/dashbordadmin";
    }


}
