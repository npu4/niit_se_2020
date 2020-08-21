package org.example;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ShopItem {
    private String category;
    private Double price;
    private String title;
    private int quantity;
    private String ID;

    public ShopItem(String category, Double price, String title, int quantity, String ID) {
        this.category = category;
        this.price = price;
        this.title = title;
        this.quantity = quantity;
        this.ID = ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ShopItem shopItem = (ShopItem) o;

        return new EqualsBuilder()
                .append(ID, shopItem.ID)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(ID)
                .toHashCode();
    }

    public String getCategory() {
        return category;
    }

    public Double getPrice() {
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

