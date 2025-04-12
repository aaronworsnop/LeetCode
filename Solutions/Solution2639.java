class Solution {
    public int[] findColumnWidth(int[][] grid) {
        int[] width = new int[grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                width[j] = Math.max(width[j], String.valueOf(grid[i][j]).length());
            }
        }

        return width;
    }
}
