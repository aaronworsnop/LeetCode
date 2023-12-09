class Solution84 {
  public int largestRectangleArea(int[] heights) {
    // Find areas moving, calculating from left to right
    int maxArea = 0;

    // Edgecases
    if (heights.length == 1) {
      return heights[0];
    }

    // Track all columns that we should start at, avoiding duplicate and
    // subset areas
    Stack<Integer> startingColumns = new Stack<>();
    if (heights[0] > 0) startingColumns.push(0);

    // Find all columns we should start at
    for (int currentIndex = 1; currentIndex < heights.length; currentIndex++) {
      if (heights[currentIndex] > heights[currentIndex - 1]) {
        // We have an increase in height, we want to consider this column
        startingColumns.push(currentIndex);
      }
    }

    while (!startingColumns.isEmpty()) {
      // Find the maximum area starting from this column
      int startingColumnIndex = startingColumns.pop();
      int currentHeight = heights[startingColumnIndex];
      for (int areaEnd = startingColumnIndex; areaEnd < heights.length; areaEnd++) {
        if (heights[areaEnd] < currentHeight) {
          // Don't consider areas that don't exist by decreasing height
          // accordingly
          currentHeight = heights[areaEnd];
        }

        int area = (areaEnd - startingColumnIndex + 1) * currentHeight;
        maxArea = Math.max(maxArea, area);
      }
    }

    return maxArea;
  }
}
