class Solution119 {
  public List<Integer> getRow(int rowIndex) {
    List<List<Integer>> triangle = new ArrayList<>();

    // Edgecases
    if (rowIndex < 0) {
      return new ArrayList<Integer>();
    }

    // Add the first layer
    triangle.add(new ArrayList<Integer>(Arrays.asList(1)));

    int currentRow = 1;
    while (currentRow <= rowIndex) {
      List<Integer> triangleRow = new ArrayList<>();

      // Add the edge piece
      triangleRow.add(1);

      // Construct half of the trianlge row
      for (int index = 1; index < (currentRow + 2) / 2; index++) {
        List<Integer> previousRow = triangle.get(currentRow - 1);
        triangleRow.add(previousRow.get(index - 1) + previousRow.get(index));
      }

      // Reflect the row
      for (int index = 0; index < (currentRow + 1) / 2; index++) {
        triangleRow.add(triangleRow.get((currentRow + 1) / 2 - index - 1));
      }

      triangle.add(triangleRow);
      currentRow++;
    }

    return triangle.get(rowIndex);
  }
}
