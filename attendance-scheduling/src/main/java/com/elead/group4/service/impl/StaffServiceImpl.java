package com.elead.group4.service.impl;

import com.elead.group4.mapper.DepMapper;
import com.elead.group4.mapper.FrequencyMapper;
import com.elead.group4.mapper.StaffMapper;
import com.elead.group4.pojo.Dep;
import com.elead.group4.pojo.Frequency;
import com.elead.group4.pojo.Staff;
import com.elead.group4.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    StaffMapper staffInfoMapper;
    @Autowired
    DepMapper depMapper;
    @Autowired
    FrequencyMapper frequencyMapper;

    @Override
    public List<Staff> getStaffInfo() {
        List<Staff> staffs = staffInfoMapper.selectAll();
        for (Staff staff : staffs) {
            Dep dep = depMapper.selectByPrimaryKey(staff.getDepid());
            dep.setFrequency(frequencyMapper.selectByPrimaryKey(dep.getTid()));
            staff.setDep(dep);
        }
        return staffs;
    }

    @Override
    public List<Staff> getStaffByName(String name) {
        Example example = new Example(Staff.class);
        Example.Criteria criteria = example.createCriteria();
        name = "%" + name + "%";
        criteria.andLike("name",name);
        return getStaff(example);
    }

    @Override
    public List<Staff> getStaffById(String jobid) {
//        Staff staff = staffInfoMapper.selectByPrimaryKey(jobid);
//        Dep dep = depMapper.selectByPrimaryKey(staff.getDepid());
//        dep.setFrequency(frequencyMapper.selectByPrimaryKey(dep.getTid()));
//        staff.setDep(dep);
//        return staff;
        Example example = new Example(Staff.class);
        Example.Criteria criteria = example.createCriteria();
        jobid = "%" + jobid + "%";
        criteria.andLike("jobid",jobid);
        return getStaff(example);
    }

    @Override
    public List<Staff> getStaffByDep(String depname) {
//        Dep dep = new Dep();
//        dep.setDepname(depname);
//        dep = depMapper.selectOne(dep);
//        String depid = dep.getDepid();
//        Example example = new Example(Staff.class);
//        Example.Criteria criteria = example.createCriteria();
//        criteria.andEqualTo("depid",depid);
//        return getStaff(example);
        Example example = new Example(Dep.class);
        Example.Criteria criteria = example.createCriteria();
        depname = "%" + depname + "%";
        criteria.andLike("depname",depname);
        List<Dep> depList = depMapper.selectByExample(example);
        if(depList.size() == 0){
            return null;
        }
        List<String> list = new ArrayList<>();
        for (Dep dep : depList) {
            list.add(dep.getDepid());
        }
        Example example1 = new Example(Staff.class);
        Example.Criteria criteria1 = example1.createCriteria();
        criteria1.andIn("depid",list);
        return getStaff(example1);
    }

    @Override
    public List<Staff> getStaffByFrequency(String type) {
//        Frequency frequency = new Frequency();
//        frequency.setType(type);
//        frequency = frequencyMapper.selectOne(frequency);
//        String tid = frequency.getId();
//        System.out.println(tid);
//        Example example = new Example(Staff.class);
//        Example.Criteria criteria = example.createCriteria();
//        criteria.andEqualTo("tid",tid);
//        return getStaff(example);
        Example example = new Example(Frequency.class);
        Example.Criteria criteria = example.createCriteria();
        type = "%" + type + "%";
        criteria.andLike("type",type);
        List<Frequency> frequencies = frequencyMapper.selectByExample(example);
        if(frequencies.size() == 0){
            return null;
        }
        List<String> list = new ArrayList<>();
        for (Frequency frequency : frequencies) {
            list.add(frequency.getId());
        }
        Example example1 = new Example(Staff.class);
        Example.Criteria criteria1 = example1.createCriteria();
        criteria1.andIn("tid",list);
        return getStaff(example1);
    }

    @Override
    public void updateStaff(Staff staff) {
        Example example = new Example(Staff.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("jobid", staff.getJobid());
        staffInfoMapper.updateByExampleSelective(staff,example);
    }

    @Override
    public int addStaff(Staff staff) {
        Dep dep = new Dep();
        dep.setDepid(staff.getDepid());
        dep = depMapper.selectOne(dep);
        staff.setTid(dep.getTid());
        return staffInfoMapper.insertSelective(staff);
    }

    private List<Staff> getStaff(Example example) {
        List<Staff> staffs = staffInfoMapper.selectByExample(example);
        for (Staff staff : staffs) {
            Dep dep = depMapper.selectByPrimaryKey(staff.getDepid());
            dep.setFrequency(frequencyMapper.selectByPrimaryKey(dep.getTid()));
            staff.setDep(dep);
        }
        return staffs;
    }
}
