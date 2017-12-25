package com.ymy.model;

public class Items {
    private Integer id;

    private Integer categoryId;

    private String name;

    private String desc;

    private String image;

    private Integer quantity;

    private String barcode;

    private Boolean issku;

    private Byte status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Boolean getIssku() {
        return issku;
    }

    public void setIssku(Boolean issku) {
        this.issku = issku;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", name=").append(name);
        sb.append(", desc=").append(desc);
        sb.append(", image=").append(image);
        sb.append(", quantity=").append(quantity);
        sb.append(", barcode=").append(barcode);
        sb.append(", issku=").append(issku);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}