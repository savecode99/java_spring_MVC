package com.bavung.javaMVC.Controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AdminController {
    @GetMapping("/admin")
    public String DashBoardPage()
    {
        return "admin/dashboard/viewDashboard";
    }
}
