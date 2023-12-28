class Solution73 {
  public void setZeroes(int[][] matrix) {
    boolean firstColZero = false;

    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix[0].length; col++) {
        if (matrix[row][col] == 0) {
          matrix[row][0] = 0;
          if (col > 0) {
            matrix[0][col] = 0;
          } else {
            firstColZero = true;
          }
        }
      }
    }

    for (int row = 1; row < matrix.length; row++) {
      for (int col = 1; col < matrix[0].length; col++) {
        if (matrix[row][0] == 0 || matrix[0][col] == 0) matrix[row][col] = 0;
      }
    }

    // Handle the top-left element separately
    if (matrix[0][0] == 0) {
      for (int col = 0; col < matrix[0].length; col++) {
        matrix[0][col] = 0;
      }
    }

    if (firstColZero) {
      for (int row = 0; row < matrix.length; row++) {
        matrix[row][0] = 0;
      }
    }
  }
}
