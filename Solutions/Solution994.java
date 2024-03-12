class Solution994 {
  public int orangesRotting(int[][] grid) {
    // grid
    // 0, empty
    // 1, fresh
    // 2, rotten

    // Do a BFS from all rotten oranges and only increment a
    // minute counter at the end of each LEVEL, not sub iteration

    // Only traverse to 1's in BFS

    // Are there any more fresh ones? If so return -1, else return minutes

    // Run-through
    // 2 1 0 0
    // 0 1 1 0 -> return -1
    // 0 2 1 0
    // 0 0 0 1

    // q:
    // minutes: 2

    // Edgecases
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      // No oranges exist, so by definition there are no rotten organges
      // immediately
      return 0;
    }

    return orangeBfs(grid);
  }

  private int orangeBfs(int[][] grid) {
    Queue<Pair<Integer, Integer>> searchQueue = new LinkedList<>();
    boolean[][] visitedCells = new boolean[grid.length][grid[0].length];

    // Find all rotten oranges to start our infection from
    int freshOranges = 0;
    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[0].length; col++) {
        if (grid[row][col] == 2) {
          searchQueue.add(new Pair<>(row, col));
        } else if (grid[row][col] == 1) {
          freshOranges++;
        }
      }
    }

    if (searchQueue.isEmpty() && freshOranges == 0) {
      return 0;
    }

    // Infect fresh oranges, counting the minutes that pass
    int minutes = -1;

    while (!searchQueue.isEmpty()) {
      int queueSize = searchQueue.size();

      for (int count = 0; count < queueSize; count++) {
        Pair<Integer, Integer> orange = searchQueue.poll();
        int orangeRow = orange.getKey();
        int orangeCol = orange.getValue();

        visitedCells[orangeRow][orangeCol] = true;

        // Infect all 4-directionally adjacent fresh oranges from
        // the current rotten `orange`
        if (orangeRow > 0
            && grid[orangeRow - 1][orangeCol] == 1
            && !visitedCells[orangeRow - 1][orangeCol]) {
          // North
          searchQueue.add(new Pair<>(orangeRow - 1, orangeCol));
          visitedCells[orangeRow - 1][orangeCol] = true;
        }

        if (orangeRow < grid.length - 1
            && grid[orangeRow + 1][orangeCol] == 1
            && !visitedCells[orangeRow + 1][orangeCol]) {
          // South
          searchQueue.add(new Pair<>(orangeRow + 1, orangeCol));
          visitedCells[orangeRow + 1][orangeCol] = true;
        }

        if (orangeCol > 0
            && grid[orangeRow][orangeCol - 1] == 1
            && !visitedCells[orangeRow][orangeCol - 1]) {
          // West
          searchQueue.add(new Pair<>(orangeRow, orangeCol - 1));
          visitedCells[orangeRow][orangeCol - 1] = true;
        }

        if (orangeCol < grid[0].length - 1
            && grid[orangeRow][orangeCol + 1] == 1
            && !visitedCells[orangeRow][orangeCol + 1]) {
          // East
          searchQueue.add(new Pair<>(orangeRow, orangeCol + 1));
          visitedCells[orangeRow][orangeCol + 1] = true;
        }
      }

      minutes++;
    }

    // Check if there are any remaining fresh oranges, in which case we should
    // return -1 to symbolise that our infection was not exhaustive
    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[0].length; col++) {
        if (!visitedCells[row][col] && grid[row][col] == 1) {
          // We found a fresh orange
          return -1;
        }
      }
    }

    return minutes;
  }
}
