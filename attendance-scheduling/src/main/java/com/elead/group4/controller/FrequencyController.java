package com.elead.group4.controller;

import com.elead.group4.pojo.Frequency;
import com.elead.group4.service.FrequencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@CrossOrigin
@Controller
public class FrequencyController {

    @Autowired
    FrequencyService frequencyService;

    @RequestMapping("getFrequency")
    @ResponseBody
    public List<Frequency> getFrequency(){
        return frequencyService.getFrequency();
    }
}
