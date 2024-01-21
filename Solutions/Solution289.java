class Solution289 {
  public void gameOfLife(int[][] board) {
    int[][] newBoard = new int[board.length][board[0].length];

    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[0].length; col++) {
        int liveAround = checkLiveAround(board, row, col);

        if (board[row][col] == 0 && liveAround == 3) {
          newBoard[row][col] = 1;
        } else if (board[row][col] == 1) {
          System.out.println("Row: " + row + ", Col: " + col + " Live Around: " + liveAround);
          if (liveAround < 2) {
            newBoard[row][col] = 0;
          } else if (liveAround > 3) {
            newBoard[row][col] = 0;
          } else {
            newBoard[row][col] = 1;
          }
        }
      }
    }

    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[0].length; col++) {
        board[row][col] = newBoard[row][col];
      }
    }
  }

  private int checkLiveAround(int[][] board, int row, int col) {
    int live = 0;

    for (int checkRow = row - 1; checkRow < row + 2; checkRow++) {
      for (int checkCol = col - 1; checkCol < col + 2; checkCol++) {
        if (checkRow < 0
            || checkRow >= board.length
            || checkCol < 0
            || checkCol >= board[0].length
            || checkRow == row && checkCol == col) {
          continue;
        }

        if (board[checkRow][checkCol] == 1) {
          live++;
        }

        if (live > 3) return 4;
      }
    }

    return live;
  }
}
