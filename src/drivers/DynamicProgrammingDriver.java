package drivers;

import dp.ClimbingStairs;
import dp.CoinChange2;
import dp.DecodeWays;
import dp.DistinctSubsequences;
import dp.HouseRobber;
import dp.InterleavingString;
import dp.JumpGame;
import dp.JumpGame2;
import dp.LongestIncreasingSubsequence;
import dp.MinimumNumberForTickets;
import dp.TargetSum;
import dp.TrappingRainWater;
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

    public void canJump() {
        JumpGame jumpGame = new JumpGame();
        System.out.println("canJump=" + jumpGame.canJump((new int[]{2, 3, 1, 1, 4})));
        System.out.println("canJump=" + jumpGame.canJump((new int[]{3, 2, 1, 0, 4})));
    }

    public void jump() {
        JumpGame2 jumpGame2 = new JumpGame2();
        System.out.println("jumps=" + jumpGame2.jump((new int[]{2, 3, 1, 1, 4})));
    }

    public void numDistinct() {
        DistinctSubsequences distinctSubsequences = new DistinctSubsequences();
        System.out.println("count=" + distinctSubsequences.numDistinct("rabbbit", "rabbit"));
    }

    public void trap() {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        System.out.println("trap=" + trappingRainWater.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
