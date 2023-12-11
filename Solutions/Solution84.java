class Solution84 {
  public int largestRectangleArea(int[] heights) {
    // Edgecases
    if (heights.length == 1) {
      return heights[0];
    }

    int n = heights.length;
    int[] nextSmallerRight = new int[n];
    int[] nextSmallerLeft = new int[n];

    Stack<Integer> stack = new Stack<>();

    // Calculate Next Smaller to the Right
    for (int i = n - 1; i >= 0; i--) {
      while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        nextSmallerRight[i] = n;
      } else {
        nextSmallerRight[i] = stack.peek();
      }
      stack.push(i);
    }

    while (!stack.isEmpty()) {
      stack.pop();
    }

    // Calculate Next Smaller to the Left
    for (int i = 0; i < n; i++) {
      while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        nextSmallerLeft[i] = -1;
      } else {
        nextSmallerLeft[i] = stack.peek();
      }
      stack.push(i);
    }

    // Calculate the maximum rectangle area
    int maxArea = 0;

    for (int i = 0; i < n; i++) {
      maxArea = Math.max(maxArea, heights[i] * (nextSmallerRight[i] - nextSmallerLeft[i] - 1));
    }

    return maxArea;
  }
}
