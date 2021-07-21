package com.elead.group4.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;

public class Frequency implements Serializable {
    /**
     * id 班次id
     * worktime 上班时间
     * gotime   下班时间
     * type     班次
     */
    @Id
    @Column
    private String id;
    @Column
    private  String worktime;
    @Column
    private String gotime;
    @Column
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
