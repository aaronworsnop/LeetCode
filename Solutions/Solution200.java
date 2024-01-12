class Solution200 {
  public int numIslands(char[][] grid) {
    // Go through the whole grid and when we find a 1 we do a DFS
    // and change all the connected to 3. If we see a three or a 0
    // we ignore it, we count the number of times we find a 1 and
    // start a DFS

    if (grid.length == 1 && grid[0].length == 1) return (grid[0][0] == '1') ? 1 : 0;

    int islands = 0;

    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[0].length; col++) {
        if (grid[row][col] == '1') {
          islands++;
          System.out.println("Row: " + row + ", Col: " + col);
          islandDFS(grid, row, col);
        }
      }
    }

    return islands;
  }

  private void islandDFS(char[][] grid, int row, int col) {
    if (row < 0 || row > grid.length - 1 || col < 0 || col > grid[0].length - 1) return;

    if (grid[row][col] == '1') grid[row][col] = '0';

    if (row > 0 && grid[row - 1][col] == '1') islandDFS(grid, row - 1, col);
    if (row < grid.length - 1 && grid[row + 1][col] == '1') islandDFS(grid, row + 1, col);
    if (col > 0 && grid[row][col - 1] == '1') islandDFS(grid, row, col - 1);
    if (col < grid[0].length - 1 && grid[row][col + 1] == '1') islandDFS(grid, row, col + 1);
  }
}
