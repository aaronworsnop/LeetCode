class Solution279 {
  public int numSquares(int n) {
    if (n == 0) {
      return 0;
    }

    int[] depths = new int[n + 1];
    for (int depth = 1; depth <= n; depth++) {
      depths[depth] = n;
    }

    for (int depth = 1; depth <= n; depth++) {
      for (int root = 1; (depth - root * root) >= 0; root++) {
        depths[depth] = Math.min(depths[depth], depths[(depth - root * root)] + 1);
      }
    }

    return depths[n];
  }
}
