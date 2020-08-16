package org.apache.commons;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class ShopItem {

    private String category;
    private double price;
    private String title;
    private int quantity;
    private String ID;


    public ShopItem(String category, String title, double price) {
        this.category = category;
        this.price = price;
        this.title = title;
        this.quantity = new Random().nextInt(100);
        this.ID = RandomStringUtils.randomAscii(25);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ShopItem shopItem = (ShopItem) o;

        return new org.apache.commons.lang.builder.EqualsBuilder()
                .append(ID, shopItem.ID)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang.builder.HashCodeBuilder(17, 37)
                .append(ID)
                .toHashCode();
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getID() {
        return ID;
    }
}
