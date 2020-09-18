package serializer;

import serializer.annotations.XmlIgnore;
import serializer.annotations.XmlName;
import serializer.annotations.XmlTypeName;

@XmlTypeName(typeName = "shop_item")
public class ShopItem {
    @XmlName(fieldName = "title")
    public String productName;

    @XmlName(fieldName = "price")
    public int price;

    @XmlName(fieldName = "available")
    public boolean availability;

    @XmlIgnore
    public int internalId;


    public ShopItem() {
    }

    public ShopItem(String productName, Integer price, boolean availability, Integer internalId) {
        this.productName = productName;
        this.price = price;
        this.availability = availability;
        this.internalId = internalId;
    }

    @Override
    public String toString() {
        return "ShopItem{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                ", availability=" + availability +
                ", internalId=" + internalId +
                '}';
    }
}
