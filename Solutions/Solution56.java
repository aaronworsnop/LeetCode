class Solution {
  public int[][] merge(int[][] intervals) {
      // Sort the intervals by their start position
      List<int[]> intervalList = new ArrayList<>(Arrays.asList(intervals));
      intervalList.sort( (a, b) -> a[0] - b[0]);

      List<int[]> mergedIntervals = new ArrayList<>();

      int start = intervalList.get(0)[0];
      int end = intervalList.get(0)[1];
      for (int interval = 1; interval < intervalList.size(); interval++) {
          int[] current = intervalList.get(interval);
          
          if (current[0] > end) {
              mergedIntervals.add(new int[]{start, end});
              start = current[0];
          }

          end = Math.max(end, current[1]);
      }

      mergedIntervals.add(new int[]{start, end});

      int[][] toReturn = new int[mergedIntervals.size()][2]; 
      for (int index = 0; index < mergedIntervals.size(); index++) {
          toReturn[index] = mergedIntervals.get(index);
      }

      return toReturn;
  }
}