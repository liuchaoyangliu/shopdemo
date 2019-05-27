package com.lcy.web.entity;


import java.util.Objects;

public class Commodity {

    /**
     * 商品唯一标识
     */
    private String uuid;
    /**
     * 商品name
     */
    private String name;
    /**
     * 类目，目前分为两个等级
     */
    private String class1;
    private String class2;
    /**
     * 商品价格
     */
    private double price;
    /**
     * 商品剩余/库存总量',
     */
    private int totalAmount;
    /**
     * 对商品的描述',
     */
    private String Description;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    public String getClass2() {
        return class2;
    }

    public void setClass2(String class2) {
        this.class2 = class2;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Commodity(String uuid, String name, String class1, String class2, double price, int totalAmount, String description) {
        this.uuid = uuid;
        this.name = name;
        this.class1 = class1;
        this.class2 = class2;
        this.price = price;
        this.totalAmount = totalAmount;
        this.Description = description;
    }

    public Commodity() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commodity commodity = (Commodity) o;
        return uuid == commodity.uuid &&
                Double.compare(commodity.price, price) == 0 &&
                totalAmount == commodity.totalAmount &&
                name.equals(commodity.name) &&
                class1.equals(commodity.class1) &&
                class2.equals(commodity.class2) &&
                Description.equals(commodity.Description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, name, class1, class2, price, totalAmount, Description);
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", class1='" + class1 + '\'' +
                ", class2='" + class2 + '\'' +
                ", price=" + price +
                ", totalAmount=" + totalAmount +
                ", Description='" + Description + '\'' +
                '}';
    }
}
