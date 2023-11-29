class Solution42 {
  public int trap(int[] height) {
    int area = 0;

    // Edgecases
    if (height.length < 3) {
      return area;
    }

    int leftPoint = 0;
    int rightPoint = height.length - 1;

    int leftMax = height[leftPoint];
    int rightMax = height[rightPoint];

    while (leftPoint < rightPoint) {
      if (leftMax < rightMax) {
        leftPoint++;
        leftMax = Math.max(height[leftPoint], leftMax);
        area += Math.max(leftMax - height[leftPoint], 0);
      } else {
        rightPoint--;
        rightMax = Math.max(height[rightPoint], rightMax);
        area += Math.max(rightMax - height[rightPoint], 0);
      }
    }

    return area;
  }
}
