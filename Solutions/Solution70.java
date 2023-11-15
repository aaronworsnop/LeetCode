class Solution70 {
  public int climbStairs(int n) {
    // For a staircase with n steps, how many unique ways can you climb it? (1 and 2 steps only)

    int distinct = 1;

    // Edgecase
    if (n == 1) {
      return distinct;
    }

    int a = 0;
    int b = 1;

    for (int i = 0; i <= n; i++) {
      distinct = a + b;
      b = a;
      a = distinct;
    }

    return distinct;

    /*
    n = 2
    1 1
    2

    n = 3
    1 1 1
    1 2
    2 1

    n = 4
    1 1 1 1
    1 1 2
    1 2 1
    2 1 1
    2 2

    n = 5
    1 1 1 1 1
    1 1 1 2
    1 1 2 1
    1 2 1 1
    2 1 1 1
    2 2 1
    2 1 2
    1 2 2

    Fibonacci sequence

    */
  }
}
