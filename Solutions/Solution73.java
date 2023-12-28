class Solution73 {
  public void setZeroes(int[][] matrix) {
    Set<Integer> zeroRows = new HashSet<>();
    Set<Integer> zeroCols = new HashSet<>();

    rows:
    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix[0].length; col++) {
        if (matrix[row][col] == 0) {
          zeroRows.add(row);
          zeroCols.add(col);
        }
      }
    }

    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix[0].length; col++) {
        if (zeroRows.contains(row) || zeroCols.contains(col)) {
          matrix[row][col] = 0;
        }
      }
    }
  }
}
