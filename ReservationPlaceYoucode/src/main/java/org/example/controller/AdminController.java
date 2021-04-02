package org.example.controller;

import org.example.Entity.ReservationEntity;
import org.example.Entity.StudentEntity;
import org.example.Entity.UseradminEntity;
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




    @RequestMapping(value = "dashbordadmin")
    public String rege(@ModelAttribute("dashbord")UseradminEntity useradminEntity, Model model,HttpSession session){

        if(session.getAttribute("id")!=null)
        {
            UserRepostory userRepostory=new UserRepostory();

            List<UseradminEntity> users = userRepostory.getAllStudents();

            model.addAttribute("users",users);
            System.out.println(users);

            return "AdmiDashbord";
        }

        else
        {
            return "redirect:/loginDirect";

        }
    }


    @RequestMapping(value = "confiEmail")
    public String ConfirmEmail(HttpServletRequest req)
    {
        UserRepostory userRepostory=new UserRepostory();
        int id= Integer.parseInt(req.getParameter("id"));

      boolean accpeted=AuthenticatedUser.user.setAccepted(true);

        UseradminEntity useradminEntity=new UseradminEntity(id,accpeted);

        userRepostory.updateUserAccpect(useradminEntity);




        return "redirect:/dashbordadmin";
    }


    @RequestMapping(value = "deleteEmail")
    public String deletemEmail(HttpServletRequest req)
    {

        int id= Integer.parseInt(req.getParameter("id"));

        userService.deleteUser(id);

        return "redirect:/dashbordadmin";
    }



    @RequestMapping(value = "ShowRes")
    public String ShoweRes(@ModelAttribute("dashbord")ReservationEntity reservationEntity, Model model){



        List<ReservationEntity> reservations = reservationService.getAllRes();

        model.addAttribute("res",reservations);


        return "ShowReservation";
    }



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


    @RequestMapping(value = "deleteRes")
    public String deleteRes(HttpServletRequest req)
    {

        int id= Integer.parseInt(req.getParameter("id"));

        reservationService.deleteRes(id);

        return "redirect:/ShowRes";
    }


    @RequestMapping(value = "EditPfAdmin")
    public String Edit(@ModelAttribute("EditPfS") UseradminEntity useradminEntity,Model model,HttpSession session)
    {
        Object idUser=session.getAttribute("id");
        useradminEntity=userService.getUserById((Integer) idUser);
        model.addAttribute("user",useradminEntity);
        return "EditePrAdmin";
    }


    @RequestMapping(value = "ProsseModifPrAdmin")
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
        return "redirect:/dashbordadmin";
    }


}
