class Solution {
    public boolean isValidSudoku(char[][] board) {
        // We assume the board to always be 9x9

        // Edgecases
        if (board == null) {
            return false;
        }

        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] grids = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int cellValue = board[i][j];

                if (cellValue == '.') {
                    // Empty squares won't invalidate the board
                    continue;
                }

                // Update `cellValue` to be the actual integer representation for
                // indexing purposes
                cellValue = cellValue - '1';
                int gridIndex = ((i / 3) * 3) + (j / 3);

                if (rows[i][cellValue] || cols[j][cellValue] || grids[gridIndex][cellValue]) {
                    return false;
                } else {
                    rows[i][cellValue] = true;
                    cols[j][cellValue] = true;
                    grids[gridIndex][cellValue] = true;
                }
            }
        }

        return true;
    }
}