package drivers;

import backtracking.CombinationSum;
import backtracking.CombinationSum2;
import backtracking.Combinations;
import backtracking.LetterCombinationsOfPhoneNumber;
import backtracking.NQueenProblem;
import backtracking.PalindromePartitioning;
import backtracking.PartitionToKEqualSumSubsets;
import backtracking.Permutations;
import backtracking.Permutations2;
import backtracking.RestoreIPAddresses;
import backtracking.SubSets;
import backtracking.WordSearch;

public class BackTrackingDriver {

    public void NQueenProblem() {
        NQueenProblem nQueenProblem = new NQueenProblem();
        nQueenProblem.solveNQueens(4);
    }

    public void wordSearchProblem() {

        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        WordSearch wordSearchProblem = new WordSearch();
//        System.out.println("exists=" + wordSearchProblem.exist(board, "ABCCED"));
        System.out.println("exists=" + wordSearchProblem.exist(board, "SEE"));
    }

    public void permutations() {
        Permutations permutations = new Permutations();
        permutations.permute(new int[]{1, 2, 3});
    }

    public void permutations2() {
        Permutations2 permutations2 = new Permutations2();
        permutations2.permute(new int[]{1, 1, 3});
    }

    public void subsets() {
        SubSets subSets = new SubSets();
        subSets.subsets(new int[]{1, 2, 3});
    }

    public void palindromePartitioning() {
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        palindromePartitioning.partition("aab");
    }

    public void letterCombinationsOfPhoneNumber() {
        LetterCombinationsOfPhoneNumber letterCombinationsOfPhoneNumber = new LetterCombinationsOfPhoneNumber();
//        letterCombinationsOfPhoneNumber.letterCombinations("23");
        letterCombinationsOfPhoneNumber.letterCombinations("23238");
    }

    public void combinationSum() {
        CombinationSum combinationSum = new CombinationSum();
        combinationSum.combinationSum(new int[]{2, 3, 6, 7}, 7);
    }

    public void combinationSum2() {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        combinationSum2.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    }

    public void combinations() {
        Combinations combinations = new Combinations();
        combinations.combine(4, 2);
    }

    public void restoreIPAddresses() {
        RestoreIPAddresses restoreIPAddresses = new RestoreIPAddresses();
//        restoreIPAddresses.restoreIpAddresses("25525511135");
//        restoreIPAddresses.restoreIpAddresses("101023");
        restoreIPAddresses.restoreIpAddresses("255255255255");
    }

    public void partitionToKEqualSumSubsets() {
        PartitionToKEqualSumSubsets partitionToKEqualSumSubsets = new PartitionToKEqualSumSubsets();
        System.out.println("partition=" + partitionToKEqualSumSubsets.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
    }
}
