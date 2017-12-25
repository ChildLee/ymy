package com.ymy.model;

public class ShopSettled {
    private Integer id;

    private Integer userId;

    private Integer adminId;

    private String name;

    private String phone;

    private String expectShopName;

    private String expectUsername;

    private String desc;

    private Byte status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getExpectShopName() {
        return expectShopName;
    }

    public void setExpectShopName(String expectShopName) {
        this.expectShopName = expectShopName;
    }

    public String getExpectUsername() {
        return expectUsername;
    }

    public void setExpectUsername(String expectUsername) {
        this.expectUsername = expectUsername;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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
        sb.append(", userId=").append(userId);
        sb.append(", adminId=").append(adminId);
        sb.append(", name=").append(name);
        sb.append(", phone=").append(phone);
        sb.append(", expectShopName=").append(expectShopName);
        sb.append(", expectUsername=").append(expectUsername);
        sb.append(", desc=").append(desc);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}