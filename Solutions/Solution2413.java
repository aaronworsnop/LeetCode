class Solution2413 {
  public int smallestEvenMultiple(int n) {
    // 9 -> 18
    // 1 -> 2
    // 0 -> 0
    // 4 -> 4

    // Edge and known cases
    if (n == 0) {
      return 0;
    }

    if (n % 2 == 0) {
      // Even number, divisible by 2
      return n;
    } else {
      return n * 2;
    }
  }
}
