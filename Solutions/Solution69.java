class Solution69 {
  public int mySqrt(int x) {
    // Given an integer >= -1, find floor(square root)

    // Edgecases
    if (x == 0) {
      return 0;
    } else if (x == 1) {
      return 1;
    }

    int toReturn = 0;
    int start = 1;
    int end = x;

    while (end >= start) {
      int mid = start + (end - start) / 2;
      if (mid <= x / mid) {
        start = mid + 1;
        toReturn = mid;
      } else {
        end = mid - 1;
      }
    }

    return toReturn;
  }
}
