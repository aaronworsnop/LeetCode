class Solution11 {
  public int maxArea(int[] height) {
    // Use two pointers that converge to the middle, checking
    // keeping track of a max the whole time

    int leftPoint = 0;
    int rightPoint = height.length - 1;

    int maxArea = 0;

    while (leftPoint < rightPoint) {
      int leftHeight = height[leftPoint];
      int rightHeight = height[rightPoint];
      int dist = rightPoint - leftPoint;

      maxArea = Math.max(Math.min(leftHeight, rightHeight) * dist, maxArea);

      if (leftHeight < rightHeight) {
        leftPoint++;
      } else {
        rightPoint--;
      }
    }

    return maxArea;
  }
}
