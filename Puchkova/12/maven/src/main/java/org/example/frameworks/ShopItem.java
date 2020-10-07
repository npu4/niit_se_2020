package org.example.frameworks;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ShopItem {
    private final String category;
    private final double price;
    private final String title;
    private final int quantity;
    private final String id; //ID - это строка из 25 символов (английские буквы или цифры)

    public ShopItem(String category, double price, String title, int quantity, String id) {
        this.category = category;
        this.price = price;
        this.title = title;
        this.quantity = quantity;
        this.id = id;
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

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof ShopItem) {
            ShopItem shopItem = (ShopItem) object;
            EqualsBuilder equalsBuilder = new EqualsBuilder()
                    .append(this.category, shopItem.category)
                    .append(this.price, shopItem.price)
                    .append(this.title, shopItem.title)
                    .append(this.quantity, shopItem.quantity)
                    .append(this.id, shopItem.id);
            return equalsBuilder.isEquals();
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}