package com.ymy.model;

public class ItemSkuAttr {
    private Integer itemAttrId;

    private Integer itemId;

    private Integer pId;

    private Integer vId;

    private Integer itemSkuId;

    public Integer getItemAttrId() {
        return itemAttrId;
    }

    public void setItemAttrId(Integer itemAttrId) {
        this.itemAttrId = itemAttrId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getvId() {
        return vId;
    }

    public void setvId(Integer vId) {
        this.vId = vId;
    }

    public Integer getItemSkuId() {
        return itemSkuId;
    }

    public void setItemSkuId(Integer itemSkuId) {
        this.itemSkuId = itemSkuId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", itemAttrId=").append(itemAttrId);
        sb.append(", itemId=").append(itemId);
        sb.append(", pId=").append(pId);
        sb.append(", vId=").append(vId);
        sb.append(", itemSkuId=").append(itemSkuId);
        sb.append("]");
        return sb.toString();
    }
}