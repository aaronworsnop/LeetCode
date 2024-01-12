class Solution200 {
  public int numIslands(char[][] grid) {
    if (grid.length == 1 && grid[0].length == 1) return (grid[0][0] == '1') ? 1 : 0;

    int islands = 0;
    int rows = grid.length;
    int cols = grid[0].length;

    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (grid[row][col] == '1') {
          islands++;
          islandDFS(grid, row, col);
        }
      }
    }

    return islands;
  }

  private void islandDFS(char[][] grid, int row, int col) {
    if (row < 0
        || row > grid.length - 1
        || col < 0
        || col > grid[0].length - 1
        || grid[row][col] != '1') return;

    grid[row][col] = '0';

    islandDFS(grid, row - 1, col);
    islandDFS(grid, row + 1, col);
    islandDFS(grid, row, col - 1);
    islandDFS(grid, row, col + 1);
  }
}
