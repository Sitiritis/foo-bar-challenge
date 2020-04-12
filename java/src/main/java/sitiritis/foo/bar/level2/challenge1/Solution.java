package sitiritis.foo.bar.level2.challenge1;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

public class Solution
{
  public static int solution(int src, int dest)
  {
    Queue<IntPair> q = new ArrayDeque<>(64);
    Set<Integer> visited = new HashSet<>(64);

    int currentPosition = src;
    int currentDepth = 0;
    while (currentPosition != dest)
    {
      visited.add(currentPosition);

      for (Integer newSrc : possibleMovesFrom(currentPosition, visited))
      {
        q.add(IntPair.of(newSrc, currentDepth + 1));
      }

      IntPair currentState = q.remove();
      currentPosition = currentState.getFirst();
      currentDepth = currentState.getSecond();
    }

    return currentDepth;
  }

  public static class IntPair
  {
    private final int fst;
    private final int snd;

    public static IntPair of(int fst, int snd)
    {
      return new IntPair(fst, snd);
    }

    public IntPair(int fst, int snd) {
      this.fst = fst;
      this.snd = snd;
    }

    public int getFirst() {
      return fst;
    }

    public int getSecond() {
      return snd;
    }

    public IntPair add(int deltaX, int deltaY)
    {
      return IntPair.of(fst + deltaX, snd + deltaY);
    }

    @Override
    public boolean equals(Object o) {
      if (o instanceof IntPair)
      {
        IntPair other = (IntPair)o;
        return fst == other.fst && snd == other.snd;
      }
      else
      {
        return false;
      }
    }
  }

  public static IntPair cellNumberToCoordinates(int src)
  {
    return IntPair.of(src % 8, src / 8);
  }

  public static int coordinatesToCellNumber(IntPair intPair)
  {
    return intPair.getSecond() * 8 + intPair.getFirst();
  }

  // optimizations possible
  public static Optional<Integer> moveFromSourceBy(int src, int relativeX, int relativeY)
  {
    return
      Optional.of(src)
        // check if the given source is within the board boundaries
        .filter((c) -> 0 <= c && c < 64)
        .map(Solution::cellNumberToCoordinates)
        .map((c) -> c.add(relativeX, relativeY))
        // check if the new coordinates within boundaries of the board
        .filter((c) ->
          0 <= c.getFirst() && c.getFirst() < 8 &&
          0 <= c.getSecond() && c.getSecond() < 8
        )
        .map(Solution::coordinatesToCellNumber)
    ;
  }

  // optimizations possible
  public static List<Integer> possibleMovesFrom(int src, Set<Integer> visited)
  {
    List<Integer> result = new ArrayList<>(8);

    moveFromSourceBy(src, -1, -2) // up then left
      .filter((newSrc) -> !visited.contains(newSrc))
      .ifPresent(result::add);
    moveFromSourceBy(src, 1, -2) // up then right
      .filter((newSrc) -> !visited.contains(newSrc))
      .ifPresent(result::add);

    moveFromSourceBy(src, 2, -1) // right then up
      .filter((newSrc) -> !visited.contains(newSrc))
      .ifPresent(result::add);
    moveFromSourceBy(src, 2, 1) // right then down
      .filter((newSrc) -> !visited.contains(newSrc))
      .ifPresent(result::add);

    moveFromSourceBy(src, 1, 2) // down then right
      .filter((newSrc) -> !visited.contains(newSrc))
      .ifPresent(result::add);
    moveFromSourceBy(src, -1, 2) // down then left
      .filter((newSrc) -> !visited.contains(newSrc))
      .ifPresent(result::add);

    moveFromSourceBy(src, -2, 1) // left then down
      .filter((newSrc) -> !visited.contains(newSrc))
      .ifPresent(result::add);
    moveFromSourceBy(src, -2, -1) // left then up
      .filter((newSrc) -> !visited.contains(newSrc))
      .ifPresent(result::add);

    return result;
  }
}
