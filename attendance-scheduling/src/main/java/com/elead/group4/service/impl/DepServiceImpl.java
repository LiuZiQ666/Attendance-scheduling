package com.elead.group4.service.impl;

import com.elead.group4.mapper.DepMapper;
import com.elead.group4.mapper.FrequencyMapper;
import com.elead.group4.pojo.Dep;
import com.elead.group4.service.DepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class DepServiceImpl implements DepService {
    @Autowired
    DepMapper depMapper;
    @Autowired
    FrequencyMapper frequencyMapper;

    @Override
    public List<Dep> getDepInfo() {
        List<Dep> depList = depMapper.selectAll();
        for (Dep depInfo : depList) {
            depInfo.setFrequency(frequencyMapper.selectByPrimaryKey(depInfo.getTid()));
        }
        return depList;
    }

    @Override
    public List<Dep> getDepInfoByDepname(String depid) {
      //  Dep dep = depMapper.selectByPrimaryKey(depid);
//        if(dep == null){
//            return null;
//        }
//        dep.setFrequency(frequencyMapper.selectByPrimaryKey(dep.getTid()));
//        return dep;
        Dep dep = new Dep();
        dep.setDepid(depid);
        List<Dep> deps = depMapper.select(dep);
        for (Dep dep1 : deps) {
            dep1.setFrequency(frequencyMapper.selectByPrimaryKey(dep1.getTid()));
        }
        return deps;
    }

    @Override
    public List<Dep> getDepInfoByFrequency(String tid) {
        Example example = new Example(Dep.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("tid",tid);
        List<Dep> depList = depMapper.selectByExample(example);
        for (Dep dep : depList) {
            dep.setFrequency(frequencyMapper.selectByPrimaryKey(dep.getTid()));
        }
        return depList;
    }

    @Override
    public void updateDep(Dep dep) {
        Example example = new Example(Dep.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("depid",dep.getDepid());
        depMapper.updateByExampleSelective(dep,example);
    }

    @Override
    public int addDep(Dep dep) {
        int flag = depMapper.selectCount(dep);
        if(flag != 0){
            return 0;
        }
        return depMapper.insertSelective(dep);
    }

}
