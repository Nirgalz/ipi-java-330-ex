package com.ipiecoles.java.java320.controller;

import com.ipiecoles.java.java320.model.Commercial;
import com.ipiecoles.java.java320.service.CommercialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.awt.*;
import java.util.Map;

@Controller
@RequestMapping("/commercials")
public class CommercialController {

    @Autowired
    CommercialService commercialService;

    @RequestMapping(
            value = "/{id]",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public  String editCommercial(@PathVariable("id") Long id, @RequestBody Commercial commercial, Map<String, Object> model) {
        commercial = commercialService.updateEmploye(id, commercial);
        model.put("commercial", commercial);
        return "employes/detail";
    }

}
