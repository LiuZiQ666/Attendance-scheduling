package com.elead.group4.service.impl;

import com.elead.group4.mapper.RosterMapper;
import com.elead.group4.pojo.Roster;
import com.elead.group4.service.RosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class RosterServiceImpl implements RosterService {
    @Autowired
    RosterMapper rosterMapper;


    @Override
    public List<Roster> getRosterAll(String breaktime,String depid) {
        Example example = new Example(Roster.class);
        Example.Criteria criteria = example.createCriteria();
        breaktime =  breaktime + "%";
        criteria.andLike("breaktime",breaktime).andEqualTo("depid",depid);
        List<Roster> rosters = rosterMapper.selectByExample(example);
        return rosters;
    }

    @Override
    public void updateRoster(Roster roster) {
        int i = rosterMapper.selectCount(roster);
        if(roster.getFlag().equals("0") && i != 0){
            return;
        }else if(roster.getFlag().equals("0") && i == 0){
            rosterMapper.insertSelective(roster);
        }else if(roster.getFlag().equals("1") && i != 0){
            rosterMapper.delete(roster);
        }else if(roster.getFlag().equals("1") && i == 0){
            return;
        }
//        for (Roster roster1 : roster) {
//            if(roster1.getFlag() == "0"){
//                rosterMapper.insertSelective(roster1);
//            }if(roster1.getFlag() == "1"){
//                rosterMapper.delete(roster1);
//            }
//        }
    }
}
