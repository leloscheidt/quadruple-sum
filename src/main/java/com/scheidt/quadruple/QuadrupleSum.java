package com.scheidt.quadruple;

import java.util.ArrayList;
import java.util.List;

public class QuadrupleSum {
  public List<Integer[]> fourNumberSum(Integer[] array, int targetSum) {
    List<Integer[]> results = new ArrayList<>();

    if (array == null || array.length < 4) {
      return results;
    }

    for (int firstIndex = 0; firstIndex < array.length; firstIndex++) {
      for (int secondIndex = firstIndex + 1; secondIndex < array.length; secondIndex++) {
        for (int thirdIndex = secondIndex + 1; thirdIndex < array.length; thirdIndex++) {
          for (int fourthIndex = thirdIndex + 1; fourthIndex < array.length; fourthIndex++) {

            Integer first = array[firstIndex];
            Integer second = array[secondIndex];
            Integer third = array[thirdIndex];
            Integer fourth = array[fourthIndex];

            if (first != null && second != null && third != null && fourth != null) { // test case with null element
              if (first + second + third + fourth == targetSum) {
                results.add(new Integer[]{first, second, third, fourth});
              }
            }
          }
        }
      }
    }
    return results;
  }
}
