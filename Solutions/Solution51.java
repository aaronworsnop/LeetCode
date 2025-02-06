class Solution {
    private int solutions;
    private Set<Integer> validCols;
    private Set<Integer> validDiagonals;
    private List<List<String>> solutionBoards; 

    public List<List<String>> solveNQueens(int n) {
        solutionBoards = new ArrayList<>();
        boardsOfNQueens(n);
        return solutionBoards;
    }

    public int boardsOfNQueens(int n) {
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

        determineBoard(0, new ArrayList<>(), n);
        return solutions;
    }

    private void determineBoard(int row, List<Pair<Integer, Integer>> coords, int n) {
        int remainingQueens = n - 1 - row;
        if (validCols.size() < remainingQueens || validDiagonals.size() / 2 < remainingQueens) {
            return;
        }
        
        if (row == n) {
            solutions++;
            solutionBoards.add(constructBoard(coords, n));
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
                coords.add(new Pair<>(row, col));

                determineBoard(row + 1, coords, n);

                coords.removeLast();
                validDiagonals.add(BLToTRDiagonal);
                validDiagonals.add(BRToTLDiagonal);
            }

            validCols.add(col);
        }
    }

    private List<String> constructBoard(List<Pair<Integer, Integer>> coords, int n) {

        // Fill a board of empty cells
        List<String> board = new ArrayList<>();

        String baseRow = "";
        for (int i = 0; i < n; i++) {
            baseRow += ".";
        }

        for (int i = 0; i < n; i++) {
            board.add(baseRow);
        }

        // Place a queen at of the solution's corresponding coordinates
        for (Pair<Integer, Integer> coord : coords) {
            StringBuilder row = new StringBuilder(board.get(coord.getKey()));
            row.setCharAt(coord.getValue(), 'Q');
            board.set(coord.getKey(), row.toString());
        }

        return board;
    }
}