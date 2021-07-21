package com.elead.group4.service;

import com.elead.group4.pojo.Staff;

import java.util.List;

public interface StaffService {
    List<Staff> getStaffInfo();

    List<Staff> getStaffByName(String name);

    List<Staff> getStaffById(String jobid);

    List<Staff> getStaffByDep(String depname);

    List<Staff> getStaffByFrequency(String type);

    void updateStaff(Staff staff);

    int addStaff(Staff staff);
}
