package org.example;

import java.security.InvalidAlgorithmParameterException;

public class Backtracking {

    int queens;
    int[][] board;

    public Backtracking(int queens) throws InvalidAlgorithmParameterException
    {
        if(queens <= 3) throw new InvalidAlgorithmParameterException();

        this.queens = queens;
        board = new int[queens][queens];
    }

    public void tryStep(int step)
    {
        //Done
        if (step==queens) return;

        int[][] prevBoard = board;
        for (int i = 0; i < queens; i++) {
            //Saving previous board

            //OK?
            if(OK(i, step))
            {
                //Action
                board[i][step] = 1;
                setDangerZones(i,step);

                tryStep(step+1);
            }
            //Undo
            board = prevBoard;
        }

    }

    private void setDangerZones(int h, int v)
    {
        //Horizontal
        for (int i = 0; i < queens; i++) {
            if (i != h) board[i][v] = -1;
        }

        //Vertical
        for (int i = 0; i < queens; i++) {
            if (i != v) board[h][i] = -1;
        }

        //Diagonals
        diagonalDangerZones(-1,-1,h,v);
        diagonalDangerZones(1,1,h,v);
        diagonalDangerZones(-1,1,h,v);
        diagonalDangerZones(1,-1,h,v);
    }

    private void diagonalDangerZones(int hChange, int vChange, int initH, int initV)
    {
        int currentH = initH;
        int currentV = initV;
        while(true)
        {
            currentH += hChange;
            currentV += vChange;

            if(isOutsideOfBoard(currentH,currentV)) break;

            board[currentH][currentV] = -1;
        }
    }

    private boolean isOutsideOfBoard(int h, int v)
    {
        return h < 0 || h > queens-1 || v < 0 || v > queens -1;
    }

    public boolean OK(int h, int v)
    {
        return board[h][v] == 0;
    }

    public int[][] getBoard() {
        return board;
    }


    public void printBoard()
    {
        for (int i = 0; i < queens; i++) {
            for (int j = 0; j < queens; j++) {
                System.out.print(board[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
