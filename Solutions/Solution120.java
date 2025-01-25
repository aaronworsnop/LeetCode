class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        // Edgecases
        if (triangle == null || triangle.size() == 0) {
            return -1;
        }

        List<List<Integer>> memo = new ArrayList<>();
        memo.add(new ArrayList<>(Arrays.asList(triangle.get(0).get(0))));

        // When moving downwards, let 'left' be defined as
        // i and 'right' be defined as i + 1

        for (int level = 1; level < triangle.size(); level++) {
            List<Integer> memoPreviousLayer = memo.get(level - 1);
            List<Integer> triangleLayer = triangle.get(level);
            List<Integer> memoLayer = new ArrayList<>();

            for (int index = 0; index < level + 1; index++) {
                int positionMin = triangleLayer.get(index);

                if (index == 0) {
                    positionMin += memoPreviousLayer.get(0);
                } else if (index == level) {
                    positionMin += memoPreviousLayer.get(level - 1);
                } else {
                    positionMin += Math.min(memoPreviousLayer.get(index - 1), memoPreviousLayer.get(index));
                }

                memoLayer.add(positionMin);
            }

            memo.add(memoLayer);
        }

        int minPathSum = Integer.MAX_VALUE;
        for (int pathSum : memo.get(memo.size() - 1)) {
            minPathSum = Math.min(minPathSum, pathSum);
        }

        return minPathSum;
    }
}