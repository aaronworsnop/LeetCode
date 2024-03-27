class Solution119 {
  public List<Integer> getRow(int rowIndex) {
    List<List<Integer>> triangle = new ArrayList<>();

    // Edgecases
    if (rowIndex < 0) {
      return new ArrayList<Integer>();
    } else if (rowIndex == 0) {
      return new ArrayList<Integer>(Arrays.asList(1));
    }

    // There is actuallly no need for the capstone element
    int currentRow = 1;
    while (currentRow <= rowIndex) {
      List<Integer> triangleRow = new ArrayList<Integer>();

      for (int index = 0; index <= currentRow; index++) {
        if (index == 0 || index == currentRow) {
          // Edges of the triangle
          triangleRow.add(1);
        } else {
          System.out.println(currentRow - 1);
          List<Integer> prevTriangleRow = triangle.get(currentRow - 2);
          triangleRow.add(prevTriangleRow.get(index - 1) + prevTriangleRow.get(index));
        }
      }

      triangle.add(triangleRow);
      currentRow++;
    }

    return triangle.get(rowIndex - 1);
  }
}
