class Solution {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    // Since the solution is unique, once we have confirmed
    // one exists we can do a greedy search. Starting from
    // the beginning of the array, we assume an index to be
    // the solution index. We calculate the moving sum from
    // an index, and if it ever goes negative, we know that
    // starting index is not the solution. Once we find an
    // index that can reach the end of the array without
    // going negative, we know it's the solution. This only
    // works as the solution is unique.

    int totalSum = 0;
    for (int index = 0; index < gas.length; index++) {
      totalSum += gas[index] - cost[index];
    }

    if (totalSum < 0) {
      // There is no solution
      return -1;
    }

    int finalIndex = 0;

    // Find the unique solution
    int currentSum = 0;
    for (int index = 0; index < gas.length; index++) {
      currentSum += gas[index] - cost[index];

      if (currentSum < 0) {
        currentSum = 0;
        finalIndex = index + 1;
      }
    }

    return finalIndex;
  }
}