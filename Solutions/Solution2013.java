class DetectSquares {
  // Key: Coordinate, Value: Number of points there
  private Map<Pair<Integer, Integer>, Integer> points;

  public DetectSquares() {
    this.points = new HashMap<>();
  }

  public void add(int[] point) {
    Pair<Integer, Integer> coordinate = new Pair<>(point[0], point[1]);
    int numberAtCoordinate = points.getOrDefault(coordinate, 0) + 1;
    points.put(coordinate, numberAtCoordinate);
  }

  public int count(int[] point) {
    // Check the diagonal axis, then we are able
    // to check the adjacents

    int totalCorrectPoints = 0;

    for (Map.Entry<Pair<Integer, Integer>, Integer> otherPoint : points.entrySet()) {
      // Check for diagonal points
      Pair<Integer, Integer> coordinate = otherPoint.getKey();
      int x = coordinate.getKey();
      int y = coordinate.getValue();

      if (point[0] == x || point[1] == y) {
        // If it sits on the same axis, it is not a positive area
        continue;
      }

      // Calculate the offset
      int xOffset = point[0] - x;
      int yOffset = point[1] - y;

      if (Math.abs(xOffset) == Math.abs(yOffset)) {
        // We have found a diagonal and need to check if the adjacent points exist.

        // We also need to keep track of the number of "correct" points. 3 -> 1 square
        // 4 -> 2, 5 -> 3 squares etc.
        int correctPointsOnOpposite = points.get(coordinate);
        int correctPointsOnX = 0;
        int correctPointsOnY = 0;

        // Check x-axis adjacency
        Pair<Integer, Integer> xPoint = new Pair<>(point[0], y);
        if (points.containsKey(xPoint)) {
          correctPointsOnX = points.get(xPoint);
        } else {
          continue;
        }

        // Check y-axis adjacency
        Pair<Integer, Integer> yPoint = new Pair<>(x, point[1]);
        if (points.containsKey(yPoint)) {
          correctPointsOnY = points.get(yPoint);
        } else {
          continue;
        }

        totalCorrectPoints += correctPointsOnOpposite * correctPointsOnX * correctPointsOnY;
      }
    }

    return totalCorrectPoints;
  }
}

/**
 * Your DetectSquares object will be instantiated and called as such: DetectSquares obj = new
 * DetectSquares(); obj.add(point); int param_2 = obj.count(point);
 */
