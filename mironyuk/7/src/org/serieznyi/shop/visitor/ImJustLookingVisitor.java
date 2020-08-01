package org.serieznyi.shop.visitor;

import org.serieznyi.shop.item.ShopItem;

import java.util.Collection;

import static java.lang.String.format;

/** Просто смотрит товары и выводит их на консоль в формате Название - цена */
public final class ImJustLookingVisitor implements ShopVisitor {
  @Override
  public void visitShop(Collection<? extends ShopItem> shop) {
    say("Обожаю донимать персонал магазина вопросами. Зайду-ка сюда");

    if (shop.size() == 0) {
      say("Похоже в магазине нет товаров");
      return;
    }

    for (ShopItem item : shop) {
      viewItem(item);
    }
  }

  private void viewItem(ShopItem item) {
    say(format("Просто смотрю товар \"%s\" и похоже он стоит %s", item.getName(), item.getPrice()));
  }
}
