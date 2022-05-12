package dp;

import java.util.HashMap;
import java.util.Map;

/*
 * LeetCode: https://leetcode.com/problems/minimum-cost-for-tickets/
 * NeetCode: https://www.youtube.com/watch?v=g0npyaQtAQM&list=PLot-Xpze53lcvx_tjrr_m2lgD2NsRHlNO
 *
 */
public class MinimumNumberForTickets {

    public int mincostTickets(int[] days, int[] costs) {

        if (days == null || days.length == 0) {
            return 0;
        }

        return backtrack(days, costs, 0, 0, new HashMap<Integer, Integer>());
    }

    private int backtrack(int[] days, int[] costs, int i, int amt, Map<Integer, Integer> cache) {

        if (i >= days.length) {
            return amt;
        }

        if (cache.containsKey(i)) {
            return cache.get(i);
        }

        cache.put(i, Integer.MAX_VALUE);

        int oneDayPassAmt = backtrack(days, costs, i + 1, amt + costs[0], cache);
        int sevenDayPassAmt = backtrack(days, costs, getIndex(days, i, 7), amt + costs[1], cache);
        int thirtyDayPassAmt = backtrack(days, costs, getIndex(days, i, 30), amt + costs[2], cache);

        int val = Math.min(oneDayPassAmt, Math.min(sevenDayPassAmt, thirtyDayPassAmt));

        cache.put(i, Math.min(cache.get(i), val));
//            return Math.min(oneDayPassAmt, Math.min(sevenDayPassAmt, thirtyDayPassAmt));

        return val;
//        return cache.get(i);

    }

    private int getIndex(int[] days, int i, int pass) {

        int nextIdx = days.length;

        if (i < days.length) {
            int currDay = days[i];

            int j = i;
            while (j < days.length && days[j] < (currDay + pass)) {
                j++;
            }

            return j;
        }

        return nextIdx;
    }
}
