class Solution {
  public int twoEggDrop(int n) {
    // Two identical eggs
    // 1 - n floors
    // f can be 0

    // Minimum number of moves to determine f

    // 100
    // 9 + 12
    // 10 + 10
    // 11 + 10
    // 12 + 9
    // 13 + 8
    // 15 + 7
    // f(5,6) = 3

    // [0-100 (10), 10-100 ()]

    // n = 0 return 0;
    // n = 1 return 1;
    // n = 2 return 2;
    // n =

    // Trial numbers of splits + run up at each split, and find the one that matches with
    // splits + run = number
    // Use binary search

    // trial: 50
    // (drop@50) 50, drop@99

    // Edgecase
    if (n < 0) {
      return -1;
    } else if (n == 0) {
      return 0;
    }

    // Try possible "Number of moves to determine f, with certainty"s until
    // we find the smallest one, using a binary search
    int lower = 1;
    int higher = n;
    int mid = -1;
    while (lower <= higher) {
      mid = lower + (higher - lower) / 2;

      boolean midValidDetermination = validDetermination(mid, n);
      if (midValidDetermination && !validDetermination(mid - 1, n)) {
        // Found the minimum "Number of moves to determine f, with certainty"
        break;
      } else if (midValidDetermination) {
        // Too many moves
        higher = mid - 1;
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

    int floor = 0;

    while (x > 0 && floor < n) {
      floor += x--;
    }

    return floor >= n;
  }
}
