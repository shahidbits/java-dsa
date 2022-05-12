package drivers;

import array.BestTimeToBuyAndSellStock;
import array.GreatestElementOnRight;
import array.MaximumSubarray;
import array.TwoSum;
import array.TwoSum2;

public class ArrayDriver {

    public void twoSum() {

        TwoSum twoSum = new TwoSum();
//        twoSum.twoSum(new int[]{2, 7, 11, 15}, 9);
        twoSum.twoSum(new int[]{3, 2, 4}, 6);
    }

    public void maximumSubarray() {
        MaximumSubarray maximumSubarray = new MaximumSubarray();
//        maximumSubarray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5});
        maximumSubarray.maxSubArray(new int[]{-2, -1, -3});
//        maximumSubarray.maxSubArray(new int[]{5,4,-1,7,8});
    }

    public void twoSum2() {
        TwoSum2 twoSum = new TwoSum2();
        twoSum.twoSum(new int[]{2, 7, 11, 15}, 9);
    }

    public void bestTimeToBuyAndSellStock() {
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
//        bestTimeToBuyAndSellStock.maxProfit(new int[]{2, 7, 11, 15});
        bestTimeToBuyAndSellStock.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
    }

    public void greatestElementOnRight() {
        GreatestElementOnRight greatestElementOnRight = new GreatestElementOnRight();
        greatestElementOnRight.replaceElements(new int[]{17, 18, 5, 4, 6, 1});
    }


}
