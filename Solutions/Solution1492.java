class Solution1492 {
  public int kthFactor(int n, int k) {
    int factor = 0;
    for (int i = 1; i <= n; i++) {
      if (n % i == 0) {
        factor++;
      }

      if (factor == k) {
        return i;
      }
    }

    return -1;
  }
}
