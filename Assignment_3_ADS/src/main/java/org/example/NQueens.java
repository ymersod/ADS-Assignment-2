package org.example;

public class NQueens {

  private int[][] board;
  private final int SIZE;

  public NQueens(int n) {
    if (n < 4)
      throw new IllegalArgumentException("Pls don't");

    SIZE = n;
    board = new int[SIZE][SIZE];
  }

  public boolean solve() {
    return solve(0);
  }

  private boolean solve(int row) {
    if (row == SIZE) {
      return true;
    }

    for (int col = 0; col < SIZE; col++) {
      if (isSafe(row, col)) {
        board[row][col] = 1;
        if (solve(row + 1)) {
          return true;
        }
        board[row][col] = 0;
      }
    }

    return false;
  }

  private boolean isSafe(int row, int col) {
    for (int i = 0; i < row; i++) {
      if (board[i][col] == 1) {
        return false;
      }
    }

    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
      if (board[i][j] == 1) {
        return false;
      }
    }

    for (int i = row - 1, j = col + 1; i >= 0 && j < SIZE; i--, j++) {
      if (board[i][j] == 1) {
        return false;
      }
    }

    return true;
  }

  public void printBoard() {
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    NQueens nQueens = new NQueens(4);
    if (nQueens.solve()) {
      nQueens.printBoard();
    } else {
      System.out.println("Solution not found");
    }
  }
}
