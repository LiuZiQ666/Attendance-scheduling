package com.elead.group4.controller;

import com.elead.group4.pojo.Staff;
import com.elead.group4.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class StaffController {

    @Autowired
    StaffService staffService;

    @RequestMapping("getStaffInfo")
    @ResponseBody
    public List<Staff> getStaffInfo(){
        List<Staff> staff = staffService.getStaffInfo();
        return staff;
    }

    @RequestMapping("getStaffByName")
    @ResponseBody
    public List<Staff> getStaffByName(String name){
        List<Staff> staff = staffService.getStaffByName(name);
        return staff;
    }

    @RequestMapping("getStaffById")
    @ResponseBody
    public List<Staff> getStaffById(String jobid){
        List<Staff> staff = staffService.getStaffById(jobid);
        return staff;
    }

    @RequestMapping("getStaffByDep")
    @ResponseBody
    public List<Staff> getStaffByDep(String depname){
        List<Staff> staff = staffService.getStaffByDep(depname);
        return staff;
    }

    @RequestMapping("getStaffByFrequency")
    @ResponseBody
    public List<Staff> getStaffByFrequency(String type){
        List<Staff> staff = staffService.getStaffByFrequency(type);
        return staff;
    }

    @RequestMapping("updateStaff")
    @ResponseBody
    public String updateStaff(@RequestBody Staff staff){
        staffService.updateStaff(staff);
        return "success";
    }

    @RequestMapping("addStaff")
    @ResponseBody
    public int addStaff(@RequestBody Staff staff){
        return staffService.addStaff(staff);
    }
}
