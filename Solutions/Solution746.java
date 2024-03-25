class Solution {
  public int minCostClimbingStairs(int[] cost) {
    // Edgecases
    if (cost == null || cost.length == 0) {
      return 0;
    } else if (cost.length == 1) {
      return cost[0];
    }

    int[] minCost = new int[cost.length];

    // Determine the acummulative cost of getting to each step, by
    // adding its own cost to the cheapest of the previous two. Thus,
    // finding the minimum cost of getting to each step.
    for (int stair = 0; stair < minCost.length; stair++) {
      if (stair == 0 || stair == 1) {
        minCost[stair] = cost[stair];
      } else {
        minCost[stair] = Math.min(minCost[stair - 1], minCost[stair - 2]) + cost[stair];
      }
    }

    // Whichever of the final two steps are the cheapest to get to is our answer, since
    // we can reach our final step from either of them.
    return Math.min(minCost[minCost.length - 1], minCost[minCost.length - 2]);
  }
}
