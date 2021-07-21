package com.elead.group4.service.impl;

import com.elead.group4.mapper.CworkMapper;
import com.elead.group4.mapper.DepMapper;
import com.elead.group4.mapper.StaffMapper;
import com.elead.group4.pojo.Cwork;
import com.elead.group4.pojo.Dep;
import com.elead.group4.pojo.Staff;
import com.elead.group4.service.CworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
public class CworkServiceImpl implements CworkService {
    @Autowired
    CworkMapper cworkMapper;
    @Autowired
    StaffMapper staffMapper;
    @Autowired
    DepMapper depMapper;

    @Override
    public List<Cwork> getCwork() {
        List<Cwork> cworks = cworkMapper.selectAll();
        for (Cwork cwork : cworks) {
            Staff staff = staffMapper.selectByPrimaryKey(cwork.getJobid());
            staff.setDep(depMapper.selectByPrimaryKey(staff.getDepid()));
            cwork.setStaff(staff);
        }
        return cworks;
    }

    @Override
    public List<Cwork> getCworkByName(String name) {
        Example example = new Example(Staff.class);
        Example.Criteria criteria = example.createCriteria();
        String jname = "%" + name + "%";
        criteria.andLike("name",jname);
     //   criteria.andEqualTo("name", name);
        List<Staff> staff = staffMapper.selectByExample(example);
        if(staff.size() == 0){
            return null;
        }
        List<String> list = new ArrayList<>();
        for (Staff staff1 : staff) {
            list.add(staff1.getJobid());
        }
        Example example1 = new Example(Cwork.class);
        Example.Criteria criteria1 = example1.createCriteria();
        criteria1.andIn("jobid",list);
        return getCworks(example1);
    }

    @Override
    public List<Cwork> getCworkByDep(String depname) {
        Example example = new Example(Dep.class);
        Example.Criteria criteria = example.createCriteria();
        depname = "%" + depname + "%";
        criteria.andLike("depname",depname);
        List<Dep> depList = depMapper.selectByExample(example);
        if(depList.size() == 0){
            return null;
        }
        List<String> list1 = new ArrayList<>();
        for (Dep dep : depList) {
            list1.add(dep.getDepid());
        }
        Example example1 = new Example(Staff.class);
        Example.Criteria criteria1 = example1.createCriteria();
        criteria1.andIn("depid",list1);
        List<Staff> staff = staffMapper.selectByExample(example1);
        List<String> list2 = new ArrayList<>();
        for (Staff staff1 : staff) {
            list2.add(staff1.getJobid());
        }
        Example example2 = new Example(Cwork.class);
        Example.Criteria criteria2 = example2.createCriteria();
        criteria2.andIn("jobid",list2);
        return getCworks(example2);
    }

    @Override
    public List<Cwork> getCworkByType(String type) {
        Example example = new Example(Cwork.class);
        Example.Criteria criteria = example.createCriteria();
        type = "%" + type + "%";
        criteria.andLike("type",type);
        return getCworks(example);
    }

    private List<Cwork> getCworks(Example example) {
        List<Cwork> cworks = cworkMapper.selectByExample(example);
        for (Cwork cwork : cworks) {
            Staff staff = staffMapper.selectByPrimaryKey(cwork.getJobid());
            staff.setDep(depMapper.selectByPrimaryKey(staff.getDepid()));
            cwork.setStaff(staff);
        }
        return cworks;
    }
}
