class Solution240 {
  public boolean searchMatrix(int[][] matrix, int target) {
    // 1 2 3
    // 2 5 8
    // 5 6 9

    // Target 9

    // This is not as simple as it initially may seem, because
    // the non-decreasing order of the rows and columns are
    // independent of another.

    // We can however find a property that does help us.

    // We will never have anything greater than the PREVIOUS
    // value (for topwards and leftwards)

    // Trivial solution: Go through every single number and
    // return true if we see `target`, false if we don't.

    // This can be done in a divide and conquer sense, just a
    // little more tricky

    int row = matrix.length - 1;
    int col = 0;

    while (row >= 0 && col < matrix[0].length) {
      int current = matrix[row][col];
      if (current == target) {
        return true;
      }

      if (current < target) {
        col++;
      } else {
        row--;
      }
    }

    return false;
  }
}
