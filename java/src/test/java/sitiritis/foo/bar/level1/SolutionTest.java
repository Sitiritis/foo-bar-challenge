package sitiritis.foo.bar.level1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static sitiritis.foo.bar.level1.Solution.*;

class SolutionTest {
  @Test
  @DisplayName("From task: area = 12")
  void solutionFromTaskCase1() {
    assertIterableEquals(
      solutionList(12),
      Arrays.asList(9, 1, 1, 1)
    );
  }

  @Test
  @DisplayName("From task: area = 15324")
  void solutionFromTaskCase2() {
    assertIterableEquals(
      solutionList(15324),
      Arrays.asList(15129, 169, 25, 1)
    );
  }
}