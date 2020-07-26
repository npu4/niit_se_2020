package org.serieznyi.ui;

import org.serieznyi.ui.exception.ElementsOverlapException;

import java.util.ArrayList;
import java.util.List;

public final class UI {
  private final int width;
  private final int height;
  List<Rectangle> elements = new ArrayList<>();

  UI(int width, int height) {

    this.width = width;
    this.height = height;
  }

  public List<Rectangle> getAllElements() {
    return elements;
  }

  public void addElement(Rectangle newRectangle) {
    for (Rectangle rectangle : elements) {
      if (isCross(newRectangle, rectangle)) {
        throw ElementsOverlapException.fromRectangles(newRectangle, rectangle);
      }
    }

    System.out.println("Добавил элемент: " + newRectangle);

    elements.add(newRectangle);
  }

  public boolean isCross(Rectangle a, Rectangle b) {
    int aX = a.getX();
    int aY = a.getY();
    int aW = a.getWidth();
    int aH = a.getHeight();

    int bX = b.getX();
    int bY = b.getY();
    int bW = b.getWidth();
    int bH = b.getHeight();

    // Прямоугольники НЕ пересекаются:
      // или верхний край второго лежит ниже нижнего края первого
      return aX <= bX + bW
              && // если левый край первого лежит правее правого края второго
              bX <= aX + aW
              && // или левый край второго лежит правее правого края первого
              aY <= bY + bH
              && // или верхний край первого лежит ниже нижнего края второго
              bY <= aY + aH;

      //        // это были координаты точек диагонали по каждому прямоугольнику
    //
    //        // 1. Проверить условия перекрытия, например, если XПA<XЛB ,
    //        //    то прямоугольники не пересекаются,и общая площадь равна нулю.
    //        //   (это случай, когда они справа и слева) и аналогично, если они сверху
    //        //    и снизу относительно друг друга.
    //        //    (XПА - это  Х Правой точки прямоугольника А)
    //        //    (ХЛВ - Х Левой точки прямоугольника В )
    //
    //        if (max(aX, aW) < min(bX, bW) || max(aY, aH) < min(bY, bH) || min(aY, aH) > max(bY,
    // bH)) {
    //            return false;
    //        }
    //
    //        // 2. Определить стороны прямоугольника образованного пересечением,
    //        // например,
    //        // если XПA>XЛB, а XЛA<XЛB, то ΔX=XПA−XЛB
    //
    //        else if (max(aX, aW) > min(bX, bW) && min(aX, aW) < min(bX, bW)) {
    //            return true;     // пересекаются
    //        }
    //
    //        return true;
  }
}
