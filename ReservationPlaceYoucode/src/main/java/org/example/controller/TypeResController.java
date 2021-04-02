package org.example.controller;

import org.example.Entity.TypereservationEntity;
import org.example.Entity.UseradminEntity;
import org.example.Global.AuthenticatedUser;
import org.example.Repostory.UserRepostory;
import org.example.service.TypeResService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TypeResController {


    @Autowired
    private TypeResService typeResService;



    @RequestMapping(value = "TypeRes")
    public String DisplayType(@ModelAttribute("typeRes")TypereservationEntity typereservationEntity, Model model, HttpSession session){


        List<TypereservationEntity> types = typeResService.getAllTypeRes();

        model.addAttribute("types",types);

        return "TypeReservation";
    }


    @RequestMapping(value = "ModifType")
    public String DisplayModifType(@ModelAttribute("typeRes")TypereservationEntity typereservationEntity, HttpServletRequest req,Model model,HttpSession session){


        int id= Integer.parseInt(req.getParameter("id"));

        session.setAttribute("id",typereservationEntity.getId());
        typereservationEntity=typeResService.getTypeResById(id);
        model.addAttribute("type",typereservationEntity);

        return "ModifType";
    }


    @RequestMapping(value = "ProsseModifType")
    public String ModifProfile(HttpServletRequest req, HttpSession session)
    {
        Object idURes=session.getAttribute("id");
        int id=(Integer)idURes;
        int nbr= Integer.parseInt(req.getParameter("nbr"));
        String type=req.getParameter("typeres");

        TypereservationEntity typereservationEntity=new TypereservationEntity(id,type,nbr);

        typeResService.updateTypeRes(typereservationEntity);

        return "redirect:/TypeRes";
    }

    @RequestMapping(value = "deleteTypeRes")
    public String deleteType(HttpServletRequest req)
    {

        int id= Integer.parseInt(req.getParameter("id"));

        typeResService.deleteTypeRes(id);

        return "redirect:/TypeRes";
    }



    @RequestMapping(value = "disAddRes")
    public String DisplayAddRes(){




        return "AddTypeRes";
    }

    @RequestMapping(value = "AddType")
    public String AddTypeRes(HttpServletRequest req){


        int nbr= Integer.parseInt(req.getParameter("nbr"));
        String type=req.getParameter("typeres");
        TypereservationEntity typereservationEntity=new TypereservationEntity(type,nbr);
        typeResService.addTypeRes(typereservationEntity);


        return "redirect:/TypeRes";
    }








}
