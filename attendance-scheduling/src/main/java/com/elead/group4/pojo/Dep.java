package com.elead.group4.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;

public class Dep implements Serializable {
    /**
     * depid 部门id
     * depname 部门名称
     * tid    班次id
     * frequency 班次对象
     */
    @Id
    @Column
    private String depid;
    @Column
    private String depname;
    @Column
    private String tid;
    @Transient
    Frequency frequency;

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public String getDepid() {
        return depid;
    }

    public void setDepid(String depid) {
        this.depid = depid;
    }

    public String getDepname() {
        return depname;
    }

    public void setDepname(String depname) {
        this.depname = depname;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

}
