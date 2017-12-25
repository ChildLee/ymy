package com.ymy.model;

import java.math.BigDecimal;

public class ItemSku {
    private Integer skuId;

    private Integer itemId;

    private String properties;

    private Integer quantity;

    private BigDecimal rawPrice;

    private BigDecimal newPrice;

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getRawPrice() {
        return rawPrice;
    }

    public void setRawPrice(BigDecimal rawPrice) {
        this.rawPrice = rawPrice;
    }

    public BigDecimal getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(BigDecimal newPrice) {
        this.newPrice = newPrice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", skuId=").append(skuId);
        sb.append(", itemId=").append(itemId);
        sb.append(", properties=").append(properties);
        sb.append(", quantity=").append(quantity);
        sb.append(", rawPrice=").append(rawPrice);
        sb.append(", newPrice=").append(newPrice);
        sb.append("]");
        return sb.toString();
    }
}