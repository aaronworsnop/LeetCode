class Solution56 {
  public int[][] merge(int[][] intervals) {
    // 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18
    //    =============
    //                                                ==============
    // =======
    //                      ========

    // Order them (O(nlogn)) then check (O(n)) -> (O(nlogn + n)) -> (O(nlogn + n))

    // 1, 3, 8,  15
    // 3, 6, 10, 18

    // check end of first place, anything less? -> yes
    // -> merge by removing and adding end

    // 1, 8,  15
    // 6, 10, 18

    // check end of first, anything less? -> no
    // chech end of second, anything less? -> no

    Set<Integer> ignores = new HashSet<>();

    int interval = 0;
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    while (interval < intervals.length - 1) {
      int intervalEnd = intervals[interval][1];
      if (intervals[interval + 1][0] <= intervalEnd) {
        intervals[interval + 1][0] = intervals[interval][0];
        if (intervals[interval][1] > intervals[interval + 1][1]) {
          intervals[interval + 1][1] = intervals[interval][1];
        }
        ignores.add(interval);
      }
      interval++;
    }

    int[][] toReturn = new int[intervals.length - ignores.size()][2];
    int toReturnIndex = 0;
    for (int i = 0; i < intervals.length; i++) {
      if (!ignores.contains(i)) {
        toReturn[toReturnIndex++] = intervals[i];
      }
    }
    return toReturn;
  }
}
