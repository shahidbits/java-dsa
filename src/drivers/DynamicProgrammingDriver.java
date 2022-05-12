package drivers;

import dp.ClimbingStairs;
import dp.CoinChange2;
import dp.DecodeWays;
import dp.HouseRobber;
import dp.InterleavingString;
import dp.LongestIncreasingSubsequence;
import dp.MinimumNumberForTickets;
import dp.TargetSum;
import dp.WordBreak;

import java.util.Arrays;

public class DynamicProgrammingDriver {

    public void houseRobber() {
        HouseRobber houseRobber = new HouseRobber();
        houseRobber.rob(new int[]{2, 7, 11, 15});
    }

    public void climbingStairs() {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println("For n=5, ways=" + climbingStairs.climbStairs(5));
    }

    public void targetSum() {
        TargetSum targetSum = new TargetSum();
        System.out.println("total=" + targetSum.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

    public void minimumNumberForTickets() {
        MinimumNumberForTickets minimumNumberForTickets = new MinimumNumberForTickets();
        System.out.println("total=" + minimumNumberForTickets.mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15}));
    }

    public void coinChange2() {
        CoinChange2 coinChange2 = new CoinChange2();
        System.out.println("total=" + coinChange2.change(5, new int[]{1, 2, 5}));
    }

    public void wordBreak() {
        WordBreak wordBreak = new WordBreak();
        System.out.println("found=" + wordBreak.wordBreak("leetcode", Arrays.asList("leet", "code")));
    }

    public void decodeWays() {
        DecodeWays decodeWays = new DecodeWays();
        System.out.println("ways=" + decodeWays.numDecodings("1"));
        System.out.println("ways=" + decodeWays.numDecodings("12"));
        System.out.println("ways=" + decodeWays.numDecodings("06"));
        System.out.println("ways=" + decodeWays.numDecodings("226"));
    }

    public void interleavingString() {
        InterleavingString interleavingString = new InterleavingString();
//        System.out.println("isInterleave=" + interleavingString.isInterleave("abx", "mbn", "ambbnx"));
//        System.out.println("isInterleave=" + interleavingString.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println("isInterleave=" + interleavingString.isInterleave("db", "b", "cbb"));
//        System.out.println("isInterleave=" + interleavingString.isInterleave("a", "b", "a"));
    }

    public void longestIncreasingSubsequence() {
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        System.out.println("max=" + longestIncreasingSubsequence.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
