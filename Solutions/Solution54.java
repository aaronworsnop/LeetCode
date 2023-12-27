class Solution54 {
  public List<Integer> spiralOrder(int[][] matrix) {
    Set<Integer> travelledRows = new HashSet<>();
    Set<Integer> travelledCols = new HashSet<>();
    travelledRows.add(matrix.length);
    travelledRows.add(-1);
    travelledCols.add(matrix[0].length);
    travelledCols.add(-1);

    int currentRow = 0;
    int currentCol = 0;

    List<Integer> order = new LinkedList<>();

    while (!travelledRows.contains(currentRow) || !travelledCols.contains(currentCol)) {
      while (!travelledCols.contains(currentCol)) {
        order.add(matrix[currentRow][currentCol]);
        currentCol++;
      }
      currentCol--;
      if (order.size() == matrix.length * matrix[0].length) break;
      travelledRows.add(currentRow);

      currentRow++;
      while (!travelledRows.contains(currentRow)) {
        order.add(matrix[currentRow][currentCol]);
        currentRow++;
      }
      currentRow--;
      if (order.size() == matrix.length * matrix[0].length) break;
      travelledCols.add(currentCol);

      currentCol--;
      while (!travelledCols.contains(currentCol)) {
        order.add(matrix[currentRow][currentCol]);
        System.out.println(order);
        currentCol--;
      }
      currentCol++;
      if (order.size() == matrix.length * matrix[0].length) break;
      travelledRows.add(currentRow);

      currentRow--;
      while (!travelledRows.contains(currentRow)) {
        order.add(matrix[currentRow][currentCol]);
        currentRow--;
      }
      currentRow++;
      if (order.size() == matrix.length * matrix[0].length) break;
      travelledCols.add(currentCol);

      currentCol++;
    }

    return order;
  }
}
