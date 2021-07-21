package com.elead.group4.controller;

import com.elead.group4.pojo.Cwork;
import com.elead.group4.service.CworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@CrossOrigin
@Controller
public class CworkController {
    @Autowired
    CworkService cworkService;

    @RequestMapping("getCwork")
    @ResponseBody
    public List<Cwork> getCwork(){
        List<Cwork> cworks = cworkService.getCwork();
        return cworks;
    }

    @RequestMapping("getCworkByName")
    @ResponseBody
    public List<Cwork> getCworkByName(String name){
        List<Cwork> cworks = cworkService.getCworkByName(name);
        return cworks;
    }

    @RequestMapping("getCworkByDep")
    @ResponseBody
    public List<Cwork> getCworkByDep(String depname){
        List<Cwork> cworks = cworkService.getCworkByDep(depname);
        return cworks;
    }

    @RequestMapping("getCworkByType")
    @ResponseBody
    public List<Cwork> getCworkByType(String type){
        List<Cwork> cworks = cworkService.getCworkByType(type);
        return cworks;
    }
}
