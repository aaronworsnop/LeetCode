class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        boolean[] values = new boolean[grid.length * grid.length];
        int[] twiceAndMissing = new int[2];

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (values[grid[row][col] - 1] == true) {
                    twiceAndMissing[0] = grid[row][col];
                    continue;
                }

                values[grid[row][col] - 1] = true;
            }
        }

        for (int number = 0; number < values.length; number++) {
            if (!values[number]) {
                twiceAndMissing[1] = number + 1;
            }
        }

        return twiceAndMissing;
    }
}