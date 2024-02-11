class Solution2812 {
  public int maximumSafenessFactor(List<List<Integer>> grid) {
    // 1 is bad (always at least 1)
    // 0 is clear

    // Start at 0, 0
    // Flood fill while there's still a path

    // BFS starting from the theives while maintaining a path from top-left to bottom-right

    // First: go through the entire array and mark down the distance from the nearest theif
    // Then traverse through this matrix from top-left to bottom-right, always selecting the
    // furthest from the theives (or prioritising bottom-rightness SF is already at a number)

    // DFS

    // 0 0 0 0 1
    // 0 0 0 0 0
    // 1 0 0 0 0
    // 0 0 0 0 0
    // 1 0 0 0 0

    // 2 3 2 1 X
    // 1 2 3 2 1
    // X 1 2 3 2
    // 1 2 3 4 3
    // X 1 2 3 4

    // O O 2 1 X
    // 1 O O 2 1
    // X 1 O 3 2     Ceiling: 2
    // 1 2 O 4 3
    // X 1 O O O

    // Now the top-left to bottom-right path prioritising higher numbers or
    // bottom-rightness

    // BFS from every square to find its distance to theif, but that's double work

    // Instead, we can do BFS from each theif, and if no value or a new lower value
    // at a square, we can update the distance. (Same time complexity, but in reality
    // way way way more effecient).

    // Edgecases
    if (grid == null || grid.size() == 0 || grid.get(0) == null || grid.get(0).size() == 0) {
      return -1;
    }

    // Initialise a grid that measures how far each cell is from a thief
    int[][] distanceGrid = new int[grid.size()][grid.get(0).size()];

    // Initialise all cells to an impossible distance from a thief
    for (int row = 0; row < grid.size(); row++) {
      for (int col = 0; col < grid.get(0).size(); col++) {
        distanceGrid[row][col] = 1000;
      }
    }

    // Update the distance from thieves for all cells
    for (int row = 0; row < grid.size(); row++) {
      for (int col = 0; col < grid.get(0).size(); col++) {
        if (grid.get(row).get(col) == 1) {
          populateDistances(distanceGrid, row, col);
        }
      }
    }

    // Using a binary search to find the safeness factor of the safest path
    int leftBound = 0;
    int rightBound = grid.size() * 2; // This is the maximum manhattan distance
    int guess;

    while (leftBound <= rightBound) {
      guess = leftBound + (rightBound - leftBound) / 2;
      if (hasPath(distanceGrid, guess)) {
        if (!hasPath(distanceGrid, guess + 1)) {
          return guess;
        } else {
          leftBound = guess + 1;
        }
      } else {
        rightBound = guess - 1;
      }
    }

    return 0;
  }

  private void populateDistances(int[][] grid, int row, int col) {
    // BFS
    Queue<int[]> queue = new LinkedList<>();
    boolean[][] seen = new boolean[grid.length][grid[0].length];
    int distance = 0;

    queue.offer(new int[] {row, col});
    seen[row][col] = true;

    while (!queue.isEmpty()) {
      int nextDistances = queue.size();

      for (int cell = 0; cell < nextDistances; cell++) {
        int[] coords = queue.poll();
        int x = coords[0], y = coords[1];
        grid[x][y] = Math.min(distance, grid[x][y]);

        // Expanding outwards in all directions
        if (x < grid.length - 1 && !seen[x + 1][y]) {
          seen[x + 1][y] = true;
          queue.offer(new int[] {x + 1, y});
        }

        if (x > 0 && !seen[x - 1][y]) {
          seen[x - 1][y] = true;
          queue.offer(new int[] {x - 1, y});
        }

        if (y < grid.length - 1 && !seen[x][y + 1]) {
          seen[x][y + 1] = true;
          queue.offer(new int[] {x, y + 1});
        }

        if (y > 0 && !seen[x][y - 1]) {
          seen[x][y - 1] = true;
          queue.offer(new int[] {x, y - 1});
        }
      }

      distance++;
    }
  }

  private boolean hasPath(int[][] grid, int limit) {
    // BFS
    Queue<int[]> queue = new LinkedList<>();
    boolean[][] seen = new boolean[grid.length][grid[0].length];

    queue.offer(new int[] {0, 0});
    seen[0][0] = true;

    while (!queue.isEmpty()) {
      int nextDistances = queue.size();

      for (int cell = 0; cell < nextDistances; cell++) {
        int[] coords = queue.poll();
        int x = coords[0], y = coords[1];

        if (grid[x][y] < limit) {
          // This is outside the limit we're testing
          continue;
        }

        if (x == grid.length - 1 && y == grid.length - 1) {
          return true;
        }

        // Expanding outwards in all directions
        if (x < grid.length - 1 && !seen[x + 1][y]) {
          seen[x + 1][y] = true;
          queue.offer(new int[] {x + 1, y});
        }

        if (x > 0 && !seen[x - 1][y]) {
          seen[x - 1][y] = true;
          queue.offer(new int[] {x - 1, y});
        }

        if (y < grid.length - 1 && !seen[x][y + 1]) {
          seen[x][y + 1] = true;
          queue.offer(new int[] {x, y + 1});
        }

        if (y > 0 && !seen[x][y - 1]) {
          seen[x][y - 1] = true;
          queue.offer(new int[] {x, y - 1});
        }
      }
    }

    return false;
  }
}
