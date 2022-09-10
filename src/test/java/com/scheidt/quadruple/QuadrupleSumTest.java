package com.scheidt.quadruple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QuadrupleSumTest {

  private QuadrupleSum quadruple;

  @BeforeEach
  public void setUp() {
    this.quadruple = new QuadrupleSum();
  }

  @Test
  public void shouldGetCorrectResultCase1() {
    List<Integer[]> expectedArray = new ArrayList<>();
    expectedArray.add(new Integer[]{7, 6, 4, -1});
    expectedArray.add( new Integer[]{7, 6, 1, 2});

    List<Integer[]> results = this.quadruple.fourNumberSum(new Integer[]{7, 6, 4, -1, 1, 2}, 16);

    Assertions.assertEquals(expectedArray.size(), results.size());
    Assertions.assertTrue(resultIsOk(expectedArray, results));
  }

  @Test
  public void shouldGetCorrectResultCase2() {
    List<Integer[]> expectedArray = new ArrayList<>();
    expectedArray.add(new Integer[]{1, 2, 3, 4});

    List<Integer[]> results = this.quadruple.fourNumberSum(new Integer[]{1, 2, 3, 4, 5, 6, 7}, 10);

    Assertions.assertEquals(expectedArray.size(), results.size());
    Assertions.assertTrue(resultIsOk(expectedArray, results));
  }

  @Test
  public void shouldGetCorrectResultCase3() {
    List<Integer[]> expectedArray = new ArrayList<>();
    expectedArray.add(new Integer[]{5, -5, -2, 2});
    expectedArray.add(new Integer[]{5, -5, 3, -3});
    expectedArray.add(new Integer[]{-2, 2, 3, -3});

    List<Integer[]> results = this.quadruple.fourNumberSum(new Integer[]{5, -5, -2, 2, 3, -3}, 0);

    Assertions.assertEquals(expectedArray.size(), results.size());
    Assertions.assertTrue(resultIsOk(expectedArray, results));
  }

  @Test
  public void shouldGetCorrectResultCase4() {
    List<Integer[]> expectedArray = new ArrayList<>();
    expectedArray.add(new Integer[]{-2, -1, 1, 6});
    expectedArray.add(new Integer[]{-2, 1, 2, 3});
    expectedArray.add(new Integer[]{-2, -1, 2, 5});
    expectedArray.add(new Integer[]{-2, -1, 3, 4});

    List<Integer[]> results = this.quadruple.fourNumberSum(new Integer[]{-2, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 4);

    Assertions.assertEquals(expectedArray.size(), results.size());
    Assertions.assertTrue(resultIsOk(expectedArray, results));
  }

  @Test
  public void shouldGetCorrectResultCase5() {
    List<Integer[]> expectedArray = new ArrayList<>();
    expectedArray.add(new Integer[]{-1, 22, 7, 2});
    expectedArray.add(new Integer[]{22, 4, 7, -3});
    expectedArray.add(new Integer[]{-1, 18, 11, 2});
    expectedArray.add(new Integer[]{18, 4, 11, -3});
    expectedArray.add(new Integer[]{22, 11, 2, -5});

    List<Integer[]> results = this.quadruple.fourNumberSum(new Integer[]{-1, 22, 18, 4, 7, 11, 2, -5, -3}, 30);

    Assertions.assertEquals(expectedArray.size(), results.size());
    Assertions.assertTrue(resultIsOk(expectedArray, results));
  }

  @Test
  public void shouldGetCorrectResultCase6() {
    List<Integer[]> expectedArray = new ArrayList<>();
    expectedArray.add(new Integer[]{-5, 2, 15, 8});
    expectedArray.add(new Integer[]{-3, 2, -7, 28});
    expectedArray.add(new Integer[]{-10, -3, 28, 5});
    expectedArray.add(new Integer[]{-10, 28, -6, 8});
    expectedArray.add(new Integer[]{-7, 28, -6, 5});
    expectedArray.add(new Integer[]{-5, 2, 12, 11});
    expectedArray.add(new Integer[]{-5, 12, 8, 5});

    List<Integer[]> results = this.quadruple.fourNumberSum(
        new Integer[]{-10, -3, -5, 2, 15, -7, 28, -6, 12, 8, 11, 5}, 20);

    Assertions.assertEquals(expectedArray.size(), results.size());
    Assertions.assertTrue(resultIsOk(expectedArray, results));
  }

  @Test
  public void shouldReturnEmptyList() {
    List<Integer[]> results = this.quadruple.fourNumberSum(new Integer[]{1, 2, 3, 4, 5}, 100);

    Assertions.assertTrue(results.isEmpty());
  }

  @Test
  public void shouldGetCorrectResultCase7() {
    List<Integer[]> expectedArray = new ArrayList<>();
    expectedArray.add(new Integer[]{2, 3, 5, -5});
    expectedArray.add(new Integer[]{1, 4, 5, -5});
    expectedArray.add(new Integer[]{2, 4, 5, -6});
    expectedArray.add(new Integer[]{1, 3, -5, 6});
    expectedArray.add(new Integer[]{2, 3, 6, -6});
    expectedArray.add(new Integer[]{1, 4, 6, -6});

    List<Integer[]> results = this.quadruple.fourNumberSum(new Integer[]{1, 2, 3, 4, 5, -5, 6, -6}, 5);

    Assertions.assertEquals(expectedArray.size(), results.size());
    Assertions.assertTrue(resultIsOk(expectedArray, results));
  }

  @Test
  public void inputWithLessThan4Elements_shouldReturnEmptyList() {
    List<Integer[]> results = this.quadruple.fourNumberSum(new Integer[]{1, 2, 3}, 6);

    Assertions.assertTrue(results.isEmpty());
  }

  @Test
  public void nullInput_shouldReturnEmptyList() {
    List<Integer[]> results = this.quadruple.fourNumberSum(null, 6);

    Assertions.assertTrue(results.isEmpty());
  }

  @Test
  public void nullElementShouldBeIgnored_shouldReturnEmptyList() {
    List<Integer[]> expectedArray = new ArrayList<>();
    expectedArray.add(new Integer[]{1, 2, 4, 5});

    List<Integer[]> results = this.quadruple.fourNumberSum(new Integer[]{1, 2, null, 4, 5, -5, 6, -6}, 12);

    Assertions.assertEquals(expectedArray.size(), results.size());
    Assertions.assertTrue(resultIsOk(expectedArray, results));
  }

  private boolean resultIsOk(List<Integer[]> expectedArray, List<Integer[]> results) {
    boolean ok = true;
    for (Integer[] expected : expectedArray) {
      ok = ok && checkIfResultContains(results, expected);
    }
    return ok;
  }

  private boolean checkIfResultContains(List<Integer[]> results, Integer[] expected) {
    Arrays.sort(expected);

    for(Integer[] result : results) {
      Arrays.sort(result);
      boolean equals = Arrays.equals(result, expected);

      if (equals) {
        return true;
      }
    }
    return false;
  }
}
