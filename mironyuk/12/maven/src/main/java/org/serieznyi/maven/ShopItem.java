package org.serieznyi.maven;

import org.apache.commons.lang3.RandomStringUtils;

final public class ShopItem {
    final private String id;
    final private String category;
    final private double price;
    final private String name;
    final private int count;

    public ShopItem(String category, double price, String name, int count) {
        this.id = RandomStringUtils.randomAlphabetic(25);
        this.category = category;
        this.price = price;
        this.name = name;
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ShopItem shopItem = (ShopItem) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(price, shopItem.price)
                .append(count, shopItem.count)
                .append(id, shopItem.id)
                .append(category, shopItem.category)
                .append(name, shopItem.name)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(id)
                .append(category)
                .append(price)
                .append(name)
                .append(count)
                .toHashCode();
    }
}
