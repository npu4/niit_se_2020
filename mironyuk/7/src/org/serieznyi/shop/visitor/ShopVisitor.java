package org.serieznyi.shop.visitor;

import org.serieznyi.shop.item.ShopItem;

import java.util.Collection;

public interface ShopVisitor {
  void visitShop(Collection<? extends ShopItem> shop);

  default void say(String message) {
    System.out.println(getClass().getSimpleName() + ": " + message);
  }
}
