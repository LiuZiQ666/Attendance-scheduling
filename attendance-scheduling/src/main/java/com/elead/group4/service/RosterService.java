package com.elead.group4.service;

import com.elead.group4.pojo.Roster;

import java.util.List;

public interface RosterService {
    List<Roster> getRosterAll(String breaktime,String depid);

    void updateRoster(Roster roster);
}
