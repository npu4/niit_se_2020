
import java.util.Collection;
import java.util.ArrayList;
public class RichVisitor implements ShopVisitor {

    @Override
    public void visitShop(Collection<? extends ShopItem> shop){
        shop.forEach(shopItem -> System.out.println("Товар "+ shopItem.getName()+" Цена "+shopItem.getPrice()));
        buy(shop);
    }

    private  void buy(Collection<? extends ShopItem> shop) {
        int count = 0;
        ShopItem iterator = null;
        ArrayList<ShopItem> del = new ArrayList<>();
        for (ShopItem item : shop) {
            if (count % 2 == 0) {
                System.out.println("Товар " + item.getName() + " куплен");
                del.add(item);
            }
            count++;
        }
        shop.removeAll(del);
    }


}
