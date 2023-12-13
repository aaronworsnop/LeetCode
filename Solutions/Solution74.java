class Solution74 {
  public boolean searchMatrix(int[][] matrix, int target) {
    // Each row is sorted (increasing)
    // The whole thing can be represented by one large array, just 2d-ified

    return isPresent(0, matrix.length * matrix[0].length - 1, matrix, target);
  }

  /** Binary search in a matrix (with linear array approach) */
  private boolean isPresent(int left, int right, int[][] matrix, int target) {
    if (left > right) return false;

    int mid = left + (right - left) / 2;
    int row = mid / matrix[0].length;
    int col = mid % matrix[0].length;
    int current = matrix[row][col];

    System.out.println(mid);

    if (current == target) return true;
    else if (current > target) return isPresent(left, mid - 1, matrix, target);
    else return isPresent(mid + 1, right, matrix, target);
  }
}
