class Solution79 {
  public boolean[][] visited;

  public boolean exist(char[][] board, String word) {
    visited = new boolean[board.length][board[0].length];

    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[0].length; col++) {
        if (board[row][col] == word.charAt(0) && existCalculator(board, word, 0, row, col))
          return true;
      }
    }

    return false;
  }

  private boolean existCalculator(char[][] board, String word, int character, int row, int col) {
    // We have found the whole word
    if (character == word.length()) return true;

    // We are trying to looking outside of the board
    if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) return false;

    // We are searching at an already visited square
    if (visited[row][col]) return false;

    // We didn't find the correct next character at this square
    if (board[row][col] != word.charAt(character)) return false;

    visited[row][col] = true;

    if (existCalculator(board, word, character + 1, row + 1, col)
        || existCalculator(board, word, character + 1, row - 1, col)
        || existCalculator(board, word, character + 1, row, col + 1)
        || existCalculator(board, word, character + 1, row, col - 1)) {
      return true;
    }

    visited[row][col] = false;
    return false;
  }
}
