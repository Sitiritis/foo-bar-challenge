package sitiritis.foo.bar.level2.challenge1;

import static org.junit.jupiter.api.Assertions.*;
import static sitiritis.foo.bar.level2.challenge1.Solution.solution;
import static sitiritis.foo.bar.level2.challenge1.Solution.moveFromSourceBy;
import static sitiritis.foo.bar.level2.challenge1.Solution.possibleMovesFrom;
import static sitiritis.foo.bar.level2.challenge1.Solution.cellNumberToCoordinates;
import static sitiritis.foo.bar.level2.challenge1.Solution.coordinatesToCellNumber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

class SolutionTest {
  @Test
  @DisplayName("From task: src = 19, dst = 36")
  void solutionFromTaskCase1() {
    assertEquals(
      1,
      solution(19, 36)
    );
  }

  @Test
  @DisplayName("From task: src = 0, dst = 1")
  void solutionFromTaskCase2() {
    assertEquals(
      3,
      solution(0, 1)
    );
  }

  @Test
  @DisplayName("Same source and destination")
  void solutionSameSourceAndDestination() {
    assertEquals(
      0,
      solution(1, 1)
    );
  }

  @Test
  @DisplayName("Always returns result for valid input")
  void solutionReturnsForValid() {
    for (int i = 0; i < 64; ++i)
    {
      for (int j = 0; j < 64; ++j)
      {
        final int finalI = i;
        final int finalJ = j;
        assertDoesNotThrow(() -> solution(finalI, finalJ));
      }
    }
  }


  @Test
  @DisplayName("moveFromSource - Don't move")
  void moveFromSourceBy00() {
    assertEquals(
      Optional.of(27),
      moveFromSourceBy(27, 0, 0)
    );
  }

  @Test
  @DisplayName("moveFromSource - (-1; 2)")
  void moveFromSourceByTopLeft() {
    assertEquals(
      Optional.of(10),
      moveFromSourceBy(27, -1, -2)
    );
  }

  @Test
  @DisplayName("moveFromSource - (1; 2)")
  void moveFromSourceByTopRight() {
    assertEquals(
      Optional.of(12),
      moveFromSourceBy(27, 1, -2)
    );
  }

  @Test
  @DisplayName("moveFromSource - (2; 1)")
  void moveFromSourceByRightTop() {
    assertEquals(
      Optional.of(21),
      moveFromSourceBy(27, 2, -1)
    );
  }

  @Test
  @DisplayName("moveFromSource - (2; -1)")
  void moveFromSourceByRightBottom() {
    assertEquals(
      Optional.of(37),
      moveFromSourceBy(27, 2, 1)
    );
  }

  @Test
  @DisplayName("moveFromSource - (1; -2)")
  void moveFromSourceByBottomRight() {
    assertEquals(
      Optional.of(44),
      moveFromSourceBy(27, 1, 2)
    );
  }

  @Test
  @DisplayName("moveFromSource - (-1; -2)")
  void moveFromSourceByBottomLeft() {
    assertEquals(
      Optional.of(42),
      moveFromSourceBy(27, -1, 2)
    );
  }

  @Test
  @DisplayName("moveFromSource - (-2; -1)")
  void moveFromSourceByLeftBottom() {
    assertEquals(
      Optional.of(33),
      moveFromSourceBy(27, -2, 1)
    );
  }

  @Test
  @DisplayName("moveFromSource - (-2; 1)")
  void moveFromSourceByLeftTop() {
    assertEquals(
      Optional.of(17),
      moveFromSourceBy(27, -2, -1)
    );
  }

  // Invalid input
  @Test
  @DisplayName("moveFromSource - invalid move top left")
  void moveFromSourceByInvalidTopLeft() {
    assertEquals(
      Optional.empty(),
      moveFromSourceBy(16, -1, 2)
    );
  }

  @Test
  @DisplayName("moveFromSource - invalid move top right")
  void moveFromSourceByInvalidTopRight() {
    assertEquals(
      Optional.empty(),
      moveFromSourceBy(23, 1, -2)
    );
  }

  @Test
  @DisplayName("moveFromSource - invalid move right top")
  void moveFromSourceByInvalidRightTop() {
    assertEquals(
      Optional.empty(),
      moveFromSourceBy(5, 2, -1)
    );
  }

  @Test
  @DisplayName("moveFromSource - invalid move right bottom")
  void moveFromSourceByInvalidRightBottom() {
    assertEquals(
      Optional.empty(),
      moveFromSourceBy(61, 2, 1)
    );
  }

  @Test
  @DisplayName("moveFromSource - invalid move bottom right")
  void moveFromSourceByInvalidBottomRight() {
    assertEquals(
      Optional.empty(),
      moveFromSourceBy(47, 1, 2)
    );
  }

  @Test
  @DisplayName("moveFromSource - invalid move bottom left")
  void moveFromSourceByInvalidBottomLeft() {
    assertEquals(
      Optional.empty(),
      moveFromSourceBy(40, -1, 2)
    );
  }

  @Test
  @DisplayName("moveFromSource - invalid move left bottom")
  void moveFromSourceByInvalidLeftBottom() {
    assertEquals(
      Optional.empty(),
      moveFromSourceBy(58, -2, 1)
    );
  }

  @Test
  @DisplayName("moveFromSource - invalid move left top")
  void moveFromSourceByInvalidLeftTop() {
    assertEquals(
      Optional.empty(),
      moveFromSourceBy(2, -2, -1)
    );
  }

  @Test
  @DisplayName("moveFromSource - invalid source")
  void moveFromSourceByInvalidSource() {
    assertEquals(
      Optional.empty(),
      moveFromSourceBy(-1, 0, 0)
    );
  }


  @Test
  @DisplayName("possibleMovesFrom - 0")
  void possibleMovesFrom0() {
    List<Integer> actual = possibleMovesFrom(0, Collections.emptySet());
    Collections.sort(actual);

    assertIterableEquals(
      Arrays.asList(10, 17),
      actual
    );
  }

  @Test
  @DisplayName("possibleMovesFrom - 7")
  void possibleMovesFrom7() {
    List<Integer> actual = possibleMovesFrom(7, Collections.emptySet());
    Collections.sort(actual);

    assertIterableEquals(
      Arrays.asList(13, 22),
      actual
    );
  }

  @Test
  @DisplayName("possibleMovesFrom - 63")
  void possibleMovesFrom63() {
    List<Integer> actual = possibleMovesFrom(63, Collections.emptySet());
    Collections.sort(actual);

    assertIterableEquals(
      Arrays.asList(46, 53),
      actual
    );
  }

  @Test
  @DisplayName("possibleMovesFrom - 56")
  void possibleMovesFrom56() {
    List<Integer> actual = possibleMovesFrom(56, Collections.emptySet());
    Collections.sort(actual);

    assertIterableEquals(
      Arrays.asList(41, 50),
      actual
    );
  }

  @Test
  @DisplayName("possibleMovesFrom - 46")
  void possibleMovesFrom46() {
    List<Integer> actual = possibleMovesFrom(46, Collections.emptySet());
    Collections.sort(actual);

    assertIterableEquals(
      Arrays.asList(29, 31, 36, 52, 61, 63),
      actual
    );
  }


  @Test
  @DisplayName("cellNumberToCoordinates - coordinates of 0")
  void cellNumberToCoordinatesOf0() {
    assertEquals(
      Solution.IntPair.of(0, 0),
      cellNumberToCoordinates(0)
    );
  }

  @Test
  @DisplayName("cellNumberToCoordinates - coordinates of 63")
  void cellNumberToCoordinatesOf63() {
    assertEquals(
      Solution.IntPair.of(7, 7),
      cellNumberToCoordinates(63)
    );
  }

  @Test
  @DisplayName("cellNumberToCoordinates - coordinates of 33")
  void cellNumberToCoordinatesOf33() {
    assertEquals(
      Solution.IntPair.of(1, 4),
      cellNumberToCoordinates(33)
    );
  }

  @Test
  @DisplayName("coordinatesToCellNumber - coordinates of (0; 0))")
  void coordinatesToCellNumber00() {
    assertEquals(
      0,
      coordinatesToCellNumber(Solution.IntPair.of(0 ,0))
    );
  }

  @Test
  @DisplayName("coordinatesToCellNumber - coordinates of (7; 7))")
  void coordinatesToCellNumber77() {
    assertEquals(
      63,
      coordinatesToCellNumber(Solution.IntPair.of(7, 7))
    );
  }

  @Test
  @DisplayName("coordinatesToCellNumber - coordinates of (2; 3))")
  void coordinatesToCellNumber23() {
    assertEquals(
      26,
      coordinatesToCellNumber(Solution.IntPair.of(2, 3))
    );
  }

  @Test
  @DisplayName("isomorphism of coordinates and cell number")
  void coordinatesCellNumberIsomorphism() {
    int cellNumber = 10;

    assertEquals(
      cellNumber,
      coordinatesToCellNumber(cellNumberToCoordinates(cellNumber))
    );

    Solution.IntPair intPair = Solution.IntPair.of(6, 5);
    assertEquals(
      intPair,
      cellNumberToCoordinates(coordinatesToCellNumber(intPair))
    );
  }
}