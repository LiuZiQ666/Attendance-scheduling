package com.elead.group4.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;

public class Staff implements Serializable {

    /**
     * jobid 工号
     * depid 部门id
     * name  姓名
     * tid   班次id
     * dep   部门对象
     */
    @Id
    @Column
    private String jobid;
    @Column
    private String depid;
    @Column
    private String name;
    @Column
    private String tid;
    @Transient
    Dep dep;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public Dep getDep() {
        return dep;
    }

    public void setDep(Dep dep) {
        this.dep = dep;
    }

    public String getJobid() {
        return jobid;
    }

    public void setJobid(String jobid) {
        this.jobid = jobid;
    }

    public String getDepid() {
        return depid;
    }

    public void setDepid(String depid) {
        this.depid = depid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
