package sitiritis.foo.bar.level1;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public static List<Integer> solutionList(int area) {
    List<Integer> result = new ArrayList<>();

    while (area > 0) {
      int currentSquare = (int)Math.pow((int)Math.sqrt(area), 2);
      result.add(currentSquare);
      area -= currentSquare;
    }

    return result;
  }
}
