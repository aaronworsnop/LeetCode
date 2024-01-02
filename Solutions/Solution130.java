class Solution130 {
  public void solve(char[][] board) {
    for (int row = 0; row < board.length; row++) {
      if (board[row][0] == 'O') DFS(board, row, 0);
      if (board[row][board[0].length - 1] == 'O') DFS(board, row, board[0].length - 1);
    }

    for (int col = 1; col < board[0].length - 1; col++) {
      if (board[0][col] == 'O') DFS(board, 0, col);
      if (board[board.length - 1][col] == 'O') DFS(board, board.length - 1, col);
    }

    // Capture regions
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[0].length; col++) {
        if (board[row][col] == 'O') board[row][col] = 'X';
        else if (board[row][col] == '@') board[row][col] = 'O';
      }
    }
  }

  private void DFS(char[][] board, int row, int col) {
    if (row < 0 || row > board.length - 1 || col < 0 || col > board[0].length - 1) return;

    if (board[row][col] == 'O') board[row][col] = '@';

    if (row > 0 && board[row - 1][col] == 'O') DFS(board, row - 1, col);
    if (row < board.length - 1 && board[row + 1][col] == 'O') DFS(board, row + 1, col);
    if (col > 0 && board[row][col - 1] == 'O') DFS(board, row, col - 1);
    if (col < board[0].length - 1 && board[row][col + 1] == 'O') DFS(board, row, col + 1);
  }
}
