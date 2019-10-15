package com.android.app.electricvehicle.entity;

//用来存储修改装箱单的实体类
public class PackingListItem {

    /**
     * id : 530bf6b9ee6111e994c60242ac110018
     * soItem : 130
     * material : RD-89VHJ4A5PF
     * rl : 100
     * agl : 200
     * qty : 300
     */

    private String id;
    private String soItem;
    private String material;
    private String rl;
    private String agl;
    private String qty;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSoItem() {
        return soItem;
    }

    public void setSoItem(String soItem) {
        this.soItem = soItem;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getRl() {
        return rl;
    }

    public void setRl(String rl) {
        this.rl = rl;
    }

    public String getAgl() {
        return agl;
    }

    public void setAgl(String agl) {
        this.agl = agl;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }
}
