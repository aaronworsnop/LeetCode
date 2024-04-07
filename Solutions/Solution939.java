class Solution939 {
  public int minAreaRect(int[][] points) {
    // Is it guaranteed that we have 2 elements only in points[i]
    // points[i] -> [x, y]

    // return the smallelst rectangle, or a 0

    // If manhattan distance between two points is greater than that of the minimum, shortcircuit

    // . . . . .
    // __X_____X
    // . . . . .
    // . . . . .
    // __X___X_X

    // (1, 1), (3, 3) -> (1, 3) & (3, 3)

    // Yn: {x-coords}
    // 3: 1, 4

    // 0: 1, 3, 4

    // existList: 1, 4

    // Do we have at least 2 in each level?
    // Find two `n`s that exist in each Y level, that's a rectangle
    // (abs(`existList` element - element2) * abs(Y1 - Y2)), update the min accordinglyr

    // Edge and known cases
    if (points == null || points.length < 4) {
      // No rectangles exist
      return 0;
    }

    int minArea = Integer.MAX_VALUE;

    // Record points that exist at each `y` level
    Map<Integer, Set<Integer>> yLevelSets = new HashMap<>();
    Map<Integer, List<Integer>> yLevelLists = new HashMap<>();

    for (int point = 0; point < points.length; point++) {
      int x = points[point][0];
      int y = points[point][1];

      Set<Integer> yLevelSet = yLevelSets.getOrDefault(y, new HashSet<>());
      List<Integer> yLevelList = yLevelLists.getOrDefault(y, new ArrayList<>());

      yLevelSet.add(x);
      yLevelList.add(x);

      yLevelSets.put(y, yLevelSet);
      yLevelLists.put(y, yLevelList);
    }

    // O(n) + O(n^2)

    // Check for valid rectangles by checking through the points
    // at every unique pair of levels
    for (Map.Entry<Integer, List<Integer>> yLevel1 : yLevelLists.entrySet()) {
      for (Map.Entry<Integer, List<Integer>> yLevel2 : yLevelLists.entrySet()) {
        if (minArea == 1) {
          // No lesser area possible
          break;
        }

        int y1 = yLevel1.getKey();
        int y2 = yLevel2.getKey();

        if (y1 == y2) {
          // These are lines, not rectangles
          continue;
        }

        if (yLevel1.getValue().size() < 2 || yLevel2.getValue().size() < 2) {
          continue;
        }

        // Get all pairs of `x` co-ords at these two `y`-levels
        List<Integer> xPairs = new ArrayList<>();

        List<Integer> yLevel1Points = yLevelLists.get(y1);
        for (int point = 0; point < yLevel1Points.size(); point++) {
          int x = yLevel1Points.get(point);

          if (yLevelSets.get(y2).contains(x)) {
            // Point exists on both `y` levels
            xPairs.add(x);
          }
        }

        for (int xPair1 = 0; xPair1 < xPairs.size(); xPair1++) {
          for (int xPair2 = xPair1 + 1; xPair2 < xPairs.size(); xPair2++) {
            minArea =
                Math.min(
                    minArea,
                    (Math.abs(xPairs.get(xPair1) - xPairs.get(xPair2))) * (Math.abs(y1 - y2)));
          }
        }
      }
    }

    if (minArea == Integer.MAX_VALUE) {
      // No valid rectangle exists
      return 0;
    } else {
      return minArea;
    }
  }
}
