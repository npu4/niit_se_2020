
import java.util.Collection;

public class ElectronicAddictedVisitor implements ShopVisitor {

    @Override
    public void visitShop(Collection<? extends ShopItem> shop){
        look(shop);
    }

    private  void look(Collection<? extends ShopItem> shop){
        shop.forEach(shopItem ->{
                if(shopItem instanceof ElectronicItem)
                    System.out.println(shopItem.getName());
        });
        buy(shop);
    }

    private  void buy(Collection<? extends ShopItem> shop){
        double max = Double.MIN_VALUE;
        ShopItem iterator=null;
        for(ShopItem item: shop){
            if(item instanceof ElectronicItem && ((ElectronicItem) item).getPower() > max){
                iterator=item;
                max=((ElectronicItem) item).getPower();
            }
        }
        if(iterator!=null){
            System.out.printf("Товар "+ iterator.getName()+" по цене " +iterator.getPrice());
        }
        shop.remove(iterator);
    }

}
