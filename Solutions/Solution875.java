class Solution {
  public int minEatingSpeed(int[] piles, int h) {
    // Find the maximum "right" value in this binary search
    int maxRight = 0;

    for (int pile : piles) {
      maxRight = Math.max(maxRight, pile);
    }

    return binaryTry(1, maxRight, h, piles);
  }

  private int binaryTry(int left, int right, int hours, int[] piles) {
    int mid = left + (right - left) / 2;

    if (kIsEnough(mid, hours, piles)) {
      if (!kIsEnough(mid - 1, hours, piles)) return mid;
      else return binaryTry(left, mid - 1, hours, piles);
    } else {
      return binaryTry(mid + 1, right, hours, piles);
    }
  }

  private boolean kIsEnough(int k, int hours, int[] piles) {
    int actualK = 0;
    for (int pile : piles) {
      actualK += Math.ceil((double) pile / k);
    }

    return (actualK <= hours);
  }
}
