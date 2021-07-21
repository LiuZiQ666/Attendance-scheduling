package com.elead.group4.controller;

import com.elead.group4.pojo.Dep;
import com.elead.group4.service.DepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class DepController {
   @Autowired
    DepService depService;

    @RequestMapping("getDepInfo")
    @ResponseBody
    public List<Dep> getDepInfo(){
        List<Dep> deps = depService.getDepInfo();
        return deps;
    }

    @RequestMapping("getDepInfoByDepname")
    @ResponseBody
    public List<Dep> getDepInfoByDepname(String depid){
        List<Dep> dep = depService.getDepInfoByDepname(depid);
        return dep;
    }

    @RequestMapping("getDepInfoByFrequency")
    @ResponseBody
    public List<Dep> getDepInfoByFrequency(String tid){
       List<Dep> deps = depService.getDepInfoByFrequency(tid);
       return deps;
    }

    @RequestMapping("updateDep")
    @ResponseBody
    public String updateDep(@RequestBody Dep dep){
        depService.updateDep(dep);
        return "seccuss";
    }

    @RequestMapping("addDep")
    @ResponseBody
    public int addDep(@RequestBody Dep dep){
        return depService.addDep(dep);
    }
}
