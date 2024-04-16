class Solution2894 {
  public int differenceOfSums(int n, int m) {
    int divisible = 0;
    int total = 0;

    for (int i = 1; i <= n; i++) {
      if (i % m == 0) divisible += i;
      total += i;
    }

    int notDivisible = total - divisible;

    return notDivisible - divisible;
  }
}
