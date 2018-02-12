package com.ipiecoles.java.java320.controller;

import com.ipiecoles.java.java320.model.Commercial;
import com.ipiecoles.java.java320.model.Employe;
import com.ipiecoles.java.java320.model.Technicien;
import com.ipiecoles.java.java320.service.CommercialService;
import com.ipiecoles.java.java320.service.EmployeService;
import com.ipiecoles.java.java320.service.TechnicienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;


@Controller
public class TechnicienController {



    @Autowired
    TechnicienService technicienService;
    @Autowired
    EmployeService employeService;

    @PostMapping("/techniciens/{id}")
    public RedirectView editechnicien(@PathVariable("id") Long id, Technicien employe, Map<String, Object> model, RedirectAttributes attributes) {
        if (employe != null) {
            employe = this.employeService.updateEmploye(id, employe);
        }

        model.put("employe", employe);
        attributes.addAttribute("success", "Modifications enregistrées !");
        return new RedirectView("/employes/" + id);
    }

    @PostMapping("/techniciens/save")
    public RedirectView saveNew(Technicien employe, Map<String,Employe> model, RedirectAttributes attributes) {
        employe = employeService.creerEmploye(employe);
        model.put("employe", employe);
        return new RedirectView("/employes/" + employe.getId());
    }
}
