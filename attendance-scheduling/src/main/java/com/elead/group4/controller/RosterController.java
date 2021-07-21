package com.elead.group4.controller;

import com.elead.group4.pojo.Roster;
import com.elead.group4.service.RosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class RosterController {
   @Autowired
   RosterService rosterService;

    @RequestMapping("getRosterAll")
    @ResponseBody
    public List<Roster> getRosterAll(String breaktime,String depid) {
        List<Roster> rosters = rosterService.getRosterAll(breaktime,depid);
        return rosters;
    }

    @RequestMapping("updateRoster")
    @ResponseBody
    public String updateRoster(@RequestBody Roster roster){
         rosterService.updateRoster(roster);
         return "seccess";
    }
}
