import company.twilio.CountryPhoneCode;
import company.twilio.SortedTransactions;
import drivers.ArrayDriver;
import drivers.BackTrackingDriver;
import drivers.DynamicProgrammingDriver;
import drivers.GraphDriver;
import drivers.LinkedListDriver;
import drivers.MiscDriver;
import drivers.StackDriver;
import drivers.StringDriver;
import drivers.TreeDriver;

import java.util.Arrays;
import java.util.List;

public class Driver {

    public static void main(String[] args) {

        ArrayDriver arrayDriver = new ArrayDriver();
        TreeDriver treeDriver = new TreeDriver();
        GraphDriver graphDriver = new GraphDriver();
        StringDriver stringDriver = new StringDriver();
        StackDriver stackDriver = new StackDriver();
        DynamicProgrammingDriver dpDriver = new DynamicProgrammingDriver();
        MiscDriver miscDriver = new MiscDriver();
        LinkedListDriver linkedListDriver = new LinkedListDriver();
        BackTrackingDriver backTrackingDriver = new BackTrackingDriver();

        /****************** Array *******************/
//        arrayDriver.twoSum();
//        arrayDriver.maximumSubarray();
//        arrayDriver.twoSum2();
//        arrayDriver.bestTimeToBuyAndSellStock();
//        arrayDriver.greatestElementOnRight();


        /****************** Linked List *******************/
//        linkedListDriver.mergeTwoSortedList();
//        linkedListDriver.reverseLinkedList();
//        linkedListDriver.palindromeLinkedList();

        /****************** Tree *******************/
//        treeDriver.invertBinaryTree();
//        treeDriver.mergeTwoBinaryTree();
//        treeDriver.lowestCommonAncestorBST();
//        treeDriver.balancedBinaryTree();
//        treeDriver.countGoodNodesInBT();
//        treeDriver.sortedArrayToBalancedBST();
//        treeDriver.validateBST();
//        treeDriver.sumRootToLeafNumbers();
//        treeDriver.uniqueBST();
//        treeDriver.rightSideView();
//        treeDriver.kthSmallestElementInBST();
//        treeDriver.houseRobber3();
//        treeDriver.constructBTFromPreorderAndInorder();
//        treeDriver.sumTree();
//        treeDriver.rootToLeafPaths();
        treeDriver.zigZagTreeTraversal();

        /****************** DP *******************/
//        dpDriver.houseRobber();
//        dpDriver.climbingStairs();
//        dpDriver.targetSum();
//        dpDriver.minimumNumberForTickets();
//        dpDriver.coinChange2();
//        dpDriver.wordBreak();
//        dpDriver.decodeWays();
//        dpDriver.interleavingString();
//        dpDriver.longestIncreasingSubsequence();


        /****************** Graph *******************/
//        graphDriver.depthFirstSearch();
//        graphDriver.depthFirstSearchIterative();
//        graphDriver.breadthFirstSearchIterative();
//        graphDriver.depthFirstSearchAdjList();
//        graphDriver.topologicalSort();
//        graphDriver.dependencyResolution();
//        graphDriver.courseSchedule();
//        graphDriver.findOrder();
//        graphDriver.numberOfIslands();
//        graphDriver.cloneGraph();
//        graphDriver.wordLadder();


        /****************** String *******************/
//        stringDriver.anagram();
//        stringDriver.longestPalindromicSubstring();

        /****************** Back Tracking *******************/
//        backTrackingDriver.NQueenProblem();
//        backTrackingDriver.wordSearchProblem();
//        backTrackingDriver.permutations();
//        backTrackingDriver.permutations2();
//        backTrackingDriver.subsets();
//        backTrackingDriver.palindromePartitioning();
//        backTrackingDriver.letterCombinationsOfPhoneNumber();
//        backTrackingDriver.combinationSum();
//        backTrackingDriver.combinationSum2();


        /****************** Company *******************/
//        countryCode();
//        sortedTransactions();


        /****************** Stack *******************/
//        stackDriver.validParentheses();


        /****************** Queue *******************/


        /****************** Sliding Window *******************/


        /****************** Misc *******************/
//        miscDriver.primeFactors();

//        List<Integer> items = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
//        Collections.rotate(items, - 3);
//
//        System.out.println(items);


    }

    private static void countryCode() {
        System.out.println(CountryPhoneCode.getPhoneNumbers("Puerto Rico", "99880090"));
    }

    private static void sortedTransactions() {
        List<String> txns = Arrays.asList(new String[]{"notebook", "notebook", "mouse", "keyboard", "mouse"});
        System.out.println(SortedTransactions.groupTransactions(txns));
    }
}
