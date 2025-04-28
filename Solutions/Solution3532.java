class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        // Edgecases
        if (nums == null || nums.length == 0 || queries == null || queries.length == 0 || maxDiff < 0 || n < 0) {
            return new boolean[0];
        } 

        boolean[] paths = new boolean[queries.length];

        // Calculate what the earliest node each node can reach is
        int[] reachableFrom = new int[n];
        reachableFrom[0] = 0;
        int id = 0;

        for (int i = 1; i < nums.length; i++) {
            if (Math.abs(nums[i] - nums[i - 1]) > maxDiff) {
                id++;
            }

            reachableFrom[i] = id;
        }

        // If two nodes can reach each other, their earliest nodes will be
        // the same. This only works because `nums` is non-decreasing.
        for (int i = 0; i < queries.length; i++) {
            int[] currentQuery = queries[i];
            int from = currentQuery[0];
            int to = currentQuery[1];

            if (reachableFrom[from] == reachableFrom[to]) {
                paths[i] = true;
            }
        }

        return paths;
    }
}