class Solution {
  private int[][] memo;

  public int superEggDrop(int k, int n) {
    this.memo = new int[k + 1][n + 1];
    Arrays.stream(memo).forEach(A -> Arrays.fill(A, -1));
    return drop(k, n);
  }

  private int drop(int k, int n) {
    if (k == 0) {
      return 0;
    } else if (k == 1) {
      return n;
    } else if (n == 0) {
      return 0;
    } else if (n == 1) {
      return 1;
    } else if (memo[k][n] != -1) {
      return memo[k][n];
    }

    int lower = 1;
    int higher = n;

    while (lower <= higher) {
      int mid = lower + (higher - lower) / 2;
      int broken = drop(k - 1, mid - 1);
      int unbroken = drop(k, n - mid);

      if (broken >= unbroken) {
        higher = mid - 1;
      } else {
        lower = mid + 1;
      }
    }

    return memo[k][n] = 1 + drop(k - 1, lower - 1);
  }
}
