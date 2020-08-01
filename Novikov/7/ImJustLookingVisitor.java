
import java.util.ArrayList;
import java.util.Collection;

public class ImJustLookingVisitor implements  ShopVisitor {

    @Override
    public void visitShop(Collection<? extends ShopItem> shop){
        shop.forEach(shopItem -> System.out.println("Товар "+ shopItem.getName()+" Цена "+shopItem.getPrice()));

    }
}
