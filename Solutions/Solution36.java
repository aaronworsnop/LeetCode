class Solution {
    public boolean isValidSudoku(char[][] board) {
        // We assume the board to always be 9x9

        // Edgecases
        if (board == null) {
            return false;
        }

        List<Set<Integer>> rows = new ArrayList<>();
        List<Set<Integer>> cols = new ArrayList<>();
        List<Set<Integer>> grids = new ArrayList<>();

        // Iterate through all cells and populate the sets.
        // If we ever encounter a collision, then we return false

        for (int i = 0; i < 9; i++) {
            // We must initialise all new sets immediately, even when
            // there is nothing to add, since we skip certain cells
            Set<Integer> rowSet = new HashSet<>();
            rows.add(rowSet);

            for (int j = 0; j < 9; j++) {
                if (i == 0) {
                    Set<Integer> colSet = new HashSet<>();
                    cols.add(colSet);
                }

                int gridIndex = ((i / 3) * 3) + (j / 3);
                if (gridIndex >= grids.size()) {
                    grids.add(new HashSet<>());
                }

                int cellValue = board[i][j];

                if (cellValue == '.') {
                    // Empty squares won't invalidate the board
                    continue;
                }

                Set<Integer> gridSet = grids.get(gridIndex);
                Set<Integer> colSet = cols.get(j);

                if (rowSet.contains(cellValue) || colSet.contains(cellValue) || gridSet.contains(cellValue)) {
                    return false;
                } else {
                    rowSet.add(cellValue);
                    colSet.add(cellValue);
                    gridSet.add(cellValue);
                }
            }
        }

        return true;
    }
}