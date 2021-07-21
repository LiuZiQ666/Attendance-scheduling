package com.elead.group4.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;

public class Cwork implements Serializable {
    /**
     * id  主键
     * jobid 工号
     * worktime 上班打卡时间
     * gotime   下班打卡时间
     * type     考勤情况
     * staff    员工实体类
     */
    @Id
    @Column
    private String id;
    @Column
    private String jobid;
    @Column
    private String worktime;
    @Column
    private String gotime;
    @Column
    private String type;
    @Transient
    Staff staff;

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobid() {
        return jobid;
    }

    public void setJobid(String jobid) {
        this.jobid = jobid;
    }

    public String getWorktime() {
        return worktime;
    }

    public void setWorktime(String worktime) {
        this.worktime = worktime;
    }

    public String getGotime() {
        return gotime;
    }

    public void setGotime(String gotime) {
        this.gotime = gotime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
