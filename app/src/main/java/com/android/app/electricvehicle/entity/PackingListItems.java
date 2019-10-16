package com.android.app.electricvehicle.entity;

//用来记录添加装箱单的时候，传入的列表
public class PackingListItems {

    /**
     * soItem : 10
     * material : RD-89VHJ4A5PF
     * rl : 100
     * agl : 200
     * qty : 300
     */
    private String soItem;
    private String material;
    private String rl;
    private String agl;
    private String qty;




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
