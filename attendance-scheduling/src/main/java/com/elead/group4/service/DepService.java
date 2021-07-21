package com.elead.group4.service;

import com.elead.group4.pojo.Dep;

import java.util.List;

public interface DepService {
    List<Dep> getDepInfo();

    List<Dep> getDepInfoByDepname(String depid);

    List<Dep> getDepInfoByFrequency(String tid);

    void updateDep(Dep dep);

    int addDep(Dep dep);
}
