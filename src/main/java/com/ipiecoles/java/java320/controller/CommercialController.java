package com.ipiecoles.java.java320.controller;

import com.ipiecoles.java.java320.model.Commercial;
import com.ipiecoles.java.java320.model.Employe;
import com.ipiecoles.java.java320.service.CommercialService;
import com.ipiecoles.java.java320.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.awt.*;
import java.util.Map;

@Controller
public class CommercialController {

    @Autowired
    CommercialService commercialService;
    @Autowired
    EmployeService employeService;

    @PostMapping("employes/commercials/{id}")
    public  RedirectView editCommercial(@PathVariable("id") Long id,  Commercial employe, Map<String, Object> model, RedirectAttributes attributes) {
        if (employe != null) {
            employe = this.employeService.updateEmploye(id, employe);
        }

        model.put("employe", employe);
        attributes.addAttribute("success", "Modifications enregistrées !");
        return new RedirectView("/employes/" + id);
    }

    @PostMapping("/commercials/save")
    public RedirectView saveNew(Commercial employe, Map<String,Employe> model, RedirectAttributes attributes) {
        employe = commercialService.creerEmploye(employe);
        model.put("employe", employe);
        return new RedirectView("/employes/" + employe.getId());
    }


}
