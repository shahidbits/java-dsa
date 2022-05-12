package backtracking;

/*
 * LeetCode: https://leetcode.com/problems/word-search/
 * NeetCode: https://www.youtube.com/watch?v=pfiQ_PS1g8E&list=PLot-Xpze53lf5C3HSjCnyFghlW0G1HHXo
 *
 */

public class WordSearch {

    /*
     * Time Complexity = O( M x N x DFS) = O (M x N x 4^L), where
     *
     * M = number of rows
     * N = number of columns
     * L = Length of the word
     *
     */
    public boolean exist(char[][] board, String word) {

        if (board != null && word != null && word.length() > 0) {

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (word.charAt(0) == board[i][j]) {
                        boolean found = exists(board, word, i, j, 0);
                        if (found) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    private boolean exists(char[][] board, String word, int r, int c, int idx) {

        if (idx == word.length()) {
            return true;
        }

        // avoid out of bounds column and row value
        if (c < 0 || c >= board[0].length || r < 0 || r >= board.length) {
            return false;
        }

        if (board[r][c] != word.charAt(idx)) {
            return false;
        }

        char temp = board[r][c];
        board[r][c] = '#';

        boolean foundNextTop = exists(board, word, r - 1, c, idx + 1);
        boolean foundNextRight = exists(board, word, r, c + 1, idx + 1);
        boolean foundNextBottom = exists(board, word, r + 1, c, idx + 1);
        boolean foundNextLeft = exists(board, word, r, c - 1, idx + 1);

        board[r][c] = temp;

        return (foundNextTop || foundNextRight || foundNextLeft || foundNextBottom);

    }

    private String getKey(int r, int c) {
        return String.format("R=%s;C=%s", r, c);
    }
}
