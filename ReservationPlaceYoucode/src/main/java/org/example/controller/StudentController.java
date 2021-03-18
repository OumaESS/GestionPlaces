package org.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

    @RequestMapping(value = "dashbord")
    public String DisplayDashbor()
    {
        return "DashbordStudent";
    }

    @RequestMapping(value = "Res")
    public String DisplayAddRes()
    {
        return "AddRes";
    }
}
