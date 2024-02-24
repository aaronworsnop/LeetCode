class Solution378 {
  public int kthSmallest(int[][] matrix, int k) {
    // [1  5  9 ]
    // [10 11 13]
    // [12 13 15]

    if (matrix == null
        || matrix.length == 0
        || matrix[0].length == 0
        || k > matrix.length * matrix[0].length) {
      return 0;
    }

    if (k == 1) {
      return matrix[0][0];
    }

    // Move down and left to the smallest k times

    // To realistically find the kTh smallest element with checking in order we need to check all
    // elements up to
    // k manhatten distance away from the top-left.

    // The kTh smallest is going to be manhattan distances from the middle

    // Rather than a BFS or a DFS, we have a PFS based on the smallness of a digit.

    // This priority queue sorts by smallest element at `matrix[Integer, Integer]`

    PriorityQueue<Tuple> priority = new PriorityQueue<>();
    for (int col = 0; col < matrix.length; col++) {
      priority.offer(new Tuple(0, col, matrix[0][col]));
    }

    for (int th = 0; th < k - 1; th++) {
      Tuple position = priority.poll();
      if (position.row == matrix.length - 1) {
        continue;
      }

      priority.offer(
          new Tuple(position.row + 1, position.col, matrix[position.row + 1][position.col]));
    }

    return priority.poll().val;
  }

  class Tuple implements Comparable<Tuple> {
    int row, col, val;

    public Tuple(int row, int col, int val) {
      this.row = row;
      this.col = col;
      this.val = val;
    }

    @Override
    public int compareTo(Tuple that) {
      return this.val - that.val;
    }
  }
}
