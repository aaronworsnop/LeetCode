class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        if (nums == null || nums.length == 0 || queries == null || queries.length == 0 || maxDiff < 0 || n < 0) {
            return new boolean[0];
        } 

        boolean[] paths = new boolean[queries.length];

        // The index in the set cannot reach the **next** index
        Set<Integer> breakIndices = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (Math.abs(nums[i] - nums[i + 1]) > maxDiff) {
                // We found a break
                breakIndices.add(i);
            }
        }

        queriesLoop:
        for (int i = 0; i < queries.length; i++) {
            int[] currentQuery = queries[i];
            int from, to;
            if (currentQuery[0] <= currentQuery[1]) {
                from = currentQuery[0];
                to = currentQuery[1];
            } else {
                from = currentQuery[1];
                to = currentQuery[0];
            }

            for (int index = from; index < to; index++) {
                if (breakIndices.contains(index)) {
                    // There is no path
                    paths[i] = false;
                    continue queriesLoop;
                }
            }

            paths[i] = true;
        }

        return paths;

        // [1, 3, 3, 4, 6, 7]
        //  ^     ^

        // Check for breaks between two nodes
    }
}