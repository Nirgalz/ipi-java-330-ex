package com.ipiecoles.java.java320.controller;

import com.ipiecoles.java.java320.model.Commercial;
import com.ipiecoles.java.java320.model.Employe;
import com.ipiecoles.java.java320.model.Technicien;
import com.ipiecoles.java.java320.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Map;

@Controller
@RequestMapping("/employes")
public class EmployesController {

    @Autowired
    private EmployeService employeService;

//    @RequestMapping("/count")
//    public Long getCount(){
//
//        return employeService.countAllEmploye();
//    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getEmployeDetailsbyId (@PathVariable("id") Long pEmployeId, Map<String, Employe> model) {

         Employe employe = employeService.findById(pEmployeId);
        model.put("employe", employe);

        if (employe != null) {
            return "employes/detail";
        } else {
          return "";
        }
    }

    @RequestMapping(value = "" , method = RequestMethod.GET)
    public  String getSortableEmployesOrbyMatricule(
            @RequestParam(value = "page",required = false) Integer pPage,
            @RequestParam(value = "size",required = false) Integer pSize,
            @RequestParam(value = "sortProperty",required = false) String pSortProperty,
            @RequestParam(value = "sortDirection",required = false) String pSortDirection,
            @RequestParam(value = "matricule",required = false) String pMatricule,
            Map<String, Object>model
    ) {
        if (pMatricule == null) {
            Page page = employeService.findAllEmployes(pPage, pSize,pSortProperty, pSortDirection);
            int totalPages = page.getTotalPages();
            int actualPage = page.getNumber();
            Long nbEmployes = employeService.countAllEmploye();
            model.put("page", page);
            model.put("totalPages", totalPages);
            model.put("actualPage", actualPage);
            model.put("nbEmployes", nbEmployes);
            model.put("size", pSize);
            model.put("sortProperty", pSortProperty);
            model.put("sortDirection", pSortDirection);
            if (page != null) {
                return "employes/liste";
            } else {
                return "";
            }
        } else {
            Employe employe = employeService.findMyMatricule(pMatricule);
            model.put("employe", employe);
            if (employe != null) {
                return "employes/detail";
            } else {
                return "";
            }
        }

    }

    @RequestMapping(
            value = "employes/new/{type}",
            method = {
                    RequestMethod.GET,
                    RequestMethod.POST
            }
//            ,
//            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public String createEmployeByType(
            @PathVariable(value = "type", required = false) String type,
            @RequestBody (required=false) MultiValueMap<String, Employe> postContent,
            Map<String, Employe>modelType
    ) {

//            if (type.equals("commercial")) {
//                Commercial employe = new Commercial();
//            } else if (type.equals("technicien")) {
//
//            }
//
//            modelType.put("employeType", employe);
            return "employes/detail";

    }


}
