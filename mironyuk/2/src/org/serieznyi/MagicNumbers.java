package org.serieznyi;

import java.util.Arrays;
import java.util.Random;

public class MagicNumbers {
  public static void main(String[] args) {
    Random random = new Random();
    int[] numbers = random.ints(-100, 100).limit(100).toArray();

    System.out.println("Сгенерировал массив чисел: \n");

    System.out.println(Arrays.toString(numbers) + "\n");

    System.out.println("Пытаемся найти магические числа. \n");

    for (int currentNumber : numbers) {
      if (isMagicNumber(currentNumber)) {
        System.out.printf("Число %s - магическое!\n", currentNumber);
      }
    }
  }

  static boolean isMagicNumber(int number) {
    int absNumber = Math.abs(number);
    int remains = absNumber % 10;

    if (remains > 0) {
      return 11 == absNumber / remains;
    }

    return false;
  }
}
