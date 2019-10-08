package com.android.app.electricvehicle.entity;

import java.io.Serializable;

public class Shangchuan implements Serializable {


    private String id;
    private String partPic;//局部
    private String overallPic;//全景

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPartPic() {
        return partPic;
    }

    public void setPartPic(String partPic) {
        this.partPic = partPic;
    }

    public String getOverallPic() {
        return overallPic;
    }

    public void setOverallPic(String overallPic) {
        this.overallPic = overallPic;
    }
}
