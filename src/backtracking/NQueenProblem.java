package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * LeetCode: https://leetcode.com/problems/n-queens/
 * NeetCode: https://www.youtube.com/watch?v=Ph95IHmRp5M
 *
 */

public class NQueenProblem {

    static int count = 0;

    public List<List<String>> solveNQueens(int n) {


        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];

        Set<Integer> colSet = new HashSet<>();
        Set<Integer> posDiagSet = new HashSet<>();
        Set<Integer> negDiagSet = new HashSet<>();

        initBoard(board);
//        printBoard(board);

        backTrack(board, 0, colSet, posDiagSet, negDiagSet, result);

//        System.out.println("total solutions = " + count);

        return result;

    }

    private void backTrack(char[][] board, int r, Set<Integer> colSet, Set<Integer> posDiagSet, Set<Integer> negDiagSet, List<List<String>> result) {

        if (r == board.length) {
//            printBoard(board);
            addSolutionToResult(result, board);
            count++;
            return;
        }

        for (int c = 0; c < board.length; c++) {

            if (colSet.contains(c) || negDiagSet.contains(r - c) || posDiagSet.contains(r + c)) {
                continue;
            }

            colSet.add(c);
            negDiagSet.add(r - c);
            posDiagSet.add(r + c);
            board[r][c] = 'Q';

            backTrack(board, r + 1, colSet, posDiagSet, negDiagSet, result);

            colSet.remove(c);
            negDiagSet.remove(r - c);
            posDiagSet.remove(r + c);
            board[r][c] = '.';
        }

    }

    private void initBoard(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '.';
            }

        }
    }

    private void printBoard(char[][] board) {

        System.out.println("***********");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("***********");
    }

    private void addSolutionToResult(List<List<String>> result, char[][] board) {

        List<String> sol = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder(board.length);

            for (int j = 0; j < board[i].length; j++) {
                sb.append(board[i][j]);
            }

            sol.add(sb.toString());
        }

        result.add(sol);

    }
}
