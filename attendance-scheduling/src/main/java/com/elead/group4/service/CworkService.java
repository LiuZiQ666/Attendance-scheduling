package com.elead.group4.service;

import com.elead.group4.pojo.Cwork;

import java.util.List;

public interface CworkService {
    List<Cwork> getCwork();

    List<Cwork> getCworkByName(String name);

    List<Cwork> getCworkByDep(String depname);

    List<Cwork> getCworkByType(String type);
}
