package com.ipiecoles.java.java320.controller;

import com.ipiecoles.java.java320.service.EmployeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employes")
public class EmployesController {

    @RequestMapping("/count")
    public Long getCount(){
        EmployeService employeService = new EmployeService();
        return employeService.countAllEmploye();
    }

}
