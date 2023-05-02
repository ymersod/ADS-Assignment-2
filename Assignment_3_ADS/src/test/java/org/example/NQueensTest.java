package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NQueensTest {

    @Test
    void test() {
        int size = 4;
        int[][] myArray = {
                {0, 1, 0, 0},
                {0, 0, 0, 1},
                {1, 0, 0, 0},
                {0, 0, 1, 0}
        };
        NQueens queens = new NQueens(size);
        queens.InitiateSolve();
        assertEquals(printBoard(size, myArray), queens.print());
    }

    String printBoard(int size, int[][] board) {
        String toReturn = "";
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                toReturn += board[i][j] + " ";
            }
            toReturn += "\n";
        }
        return toReturn;
    }
}