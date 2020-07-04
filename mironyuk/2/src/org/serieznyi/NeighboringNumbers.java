package org.serieznyi;

import java.util.Arrays;
import java.util.Random;

public class NeighboringNumbers {
  public static void main(String[] args) {
    Random random = new Random();
    int[] numbers = random.ints().limit(10).toArray();

    System.out.println("Сгенерировал массив чисел: \n");

    System.out.println(Arrays.toString(numbers) + "\n");

    System.out.println("Пытаемся найти соседние числа с разными знаками. \n");

    for (int i = 0; i < numbers.length - 1; i++) {
      int a = numbers[i];
      int b = numbers[i + 1];

      if (isOppositeNumbers(a, b)) {
        System.out.printf("Числа с противоположными знаками обнаружены: %s %s\n", a, b);
      }
    }
  }

  static boolean isOppositeNumbers(int a, int b) {
    return a > 0 && b < 0 || a < 0 && b > 0;
  }
}
