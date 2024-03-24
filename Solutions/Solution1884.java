class Solution {
  public int twoEggDrop(int n) {
    // Edgecase
    if (n < 0) {
      // Invalid input
      return -1;
    } else if (n == 0) {
      return 0;
    }

    // Try possible "Number of moves to determine f, with certainty"s until
    // we find the smallest valid one, using a binary search
    int lower = 1;
    int higher = n;
    int mid = -1;

    while (lower <= higher) {
      mid = lower + (higher - lower) / 2;

      boolean midValidDetermination = validDetermination(mid, n);
      if (midValidDetermination) {
        if (!validDetermination(mid - 1, n)) {
          // Smallest valid "Number of moves to determine f, with certainty"
          break;
        } else {
          // Too many moves
          higher = mid - 1;
        }
      } else {
        // Too few moves
        lower = mid + 1;
      }
    }

    return mid;
  }

  private boolean validDetermination(int x, int n) {
    // Edgecases
    if (x < 0) {
      return false;
    }

    // Determine whether a proposed "Number of moves to determine f, with certainty"
    // `x` is valid, depending on whether it covers the entire range of floors
    int floor = 0;
    while (x > 0 && floor < n) {
      floor += x--;
    }

    return floor >= n;
  }
}
