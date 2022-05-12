package array;

/*
 * LeetCode: https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
 * NeetCode: https://www.youtube.com/watch?v=ZHjKhUjcsaU&list=PLot-Xpze53lfQmTEztbgdp8ALEoydvnRQ&index=15
 *
 */
public class GreatestElementOnRight {

    public int[] replaceElements(int[] arr) {

        if (arr == null) {
            return null;
        }

        int max = -1;

        for (int i = arr.length - 1; i >= 0; i--) {

            int newMax = Math.max(arr[i], max);
            arr[i] = max;
            max = newMax;
        }

        return arr;
    }
}
