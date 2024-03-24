class Solution {
  public int superEggDrop(int k, int n) {
    int memo[] = new int[k + 1];
    int m;
    for (m = 0; memo[k] < n; m++) {
      for (int x = k; x > 0; x--) {
        memo[x] += 1 + memo[x - 1];
      }
    }
    return m;
  }
}
