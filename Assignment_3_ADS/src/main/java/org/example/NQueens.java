package org.example;

public class NQueens {

  private int[][] board;
  private final int SIZE;

  public NQueens(int n) {
    SIZE = n;
    board = new int[SIZE][SIZE];
  }

  //The method that initiates the solving of the problem
  public boolean InitiateSolve() {
    return solve(0);
  }

  private boolean solve(int row) {
    if (row == SIZE) {
      return true;
    }

    //For each row there has to be placed a queen, so we iterate through the columns.
    for (int column = 0; column < SIZE; column++) {
      if (isSafe(row, column)) {
        board[row][column] = 1;
        if (solve(row + 1)) {
          return true;
        }
        board[row][column] = 0;
      }
    }

    return false;
  }

  //Check if it is safe to place a queen in the given position
  private boolean isSafe(int row, int column) {
    //Check if there is a queen in the same row
    for (int i = 0; i < row; i++) {
      if (board[i][column] == 1) {
        return false;
      }
    }

    //Check the diagonal from top left to bottom right
    for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) {
      if (board[i][j] == 1) {
        return false;
      }
    }

    //Check the diagonal from top right to bottom left
    for (int i = row - 1, j = column + 1; i >= 0 && j < SIZE; i--, j++) {
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
    if (nQueens.InitiateSolve()) {
      nQueens.printBoard();
    } else {
      System.out.println("Solution not found");
    }
  }
}
