class Solution289 {
  public void gameOfLife(int[][] board) {
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[0].length; col++) {
        int liveAround = checkLiveAround(board, row, col);

        if (board[row][col] <= 0 && liveAround == 3) {
          board[row][col] = -1;
        } else if (board[row][col] >= 1) {
          if (liveAround < 2 || liveAround > 3) {
            board[row][col] = 2;
          }
        }
      }
    }

    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[0].length; col++) {
        if (board[row][col] == -1) {
          board[row][col] = 1;
        } else if (board[row][col] == 2) {
          board[row][col] = 0;
        }
      }
    }
  }

  private int checkLiveAround(int[][] board, int row, int col) {
    int liveAround = 0;

    for (int checkRow = row - 1; checkRow < row + 2; checkRow++) {
      for (int checkCol = col - 1; checkCol < col + 2; checkCol++) {
        if (checkRow < 0
            || checkRow >= board.length
            || checkCol < 0
            || checkCol >= board[0].length
            || checkRow == row && checkCol == col) {
          continue;
        }

        if (board[checkRow][checkCol] >= 1) {
          liveAround++;
        }

        if (liveAround > 3) return 4;
      }
    }
    return liveAround;
  }
}
