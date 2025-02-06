class Solution {
    private int solutions;
    private Set<Integer> validCols;
    private Set<Integer> validDiagonals;

    public int totalNQueens(int n) {
        solutions = 0;

        validCols = new HashSet<>();
        for (int i = 0; i < n; i++) {
            validCols.add(i);
        }

        validDiagonals = new HashSet<>();
        int numDiagonals = 2 * ((2 * n) - 1);
        for (int i = 0; i < numDiagonals; i++) {
            validDiagonals.add(i);
        }

        determineBoard(0, n);
        return solutions;
    }

    private void determineBoard(int row, int n) {
        int remainingQueens = n - 1 - row;
        if (validCols.size() < remainingQueens || validDiagonals.size() / 2 < remainingQueens) {
            return;
        }
        
        if (row == n) {
            solutions++;
            return;
        }

            for (Integer col : new ArrayList<>(validCols)) {
                validCols.remove(col);

                // Each row has the same sum 🤯
                int numDiagonals = 2 * ((2 * n) - 1);
                int inverseRow = row;
                int inverseCol = n - 1 - col;

                int BLToTRDiagonal = row + col;
                int BRToTLDiagonal = numDiagonals / 2 + inverseRow + inverseCol;

                if (validDiagonals.contains(BLToTRDiagonal) && validDiagonals.contains(BRToTLDiagonal)) {
                    validDiagonals.remove(BLToTRDiagonal);
                    validDiagonals.remove(BRToTLDiagonal);

                    determineBoard(row + 1, n);

                    validDiagonals.add(BLToTRDiagonal);
                    validDiagonals.add(BRToTLDiagonal);
                }
                validCols.add(col);
            }
    }
}