package array;

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {

        int currMinPrice = prices[0];
        int currBestProfit = 0;

        for (int price : prices) {

            currBestProfit = Math.max(price - currMinPrice, currBestProfit);

            currMinPrice = Math.min(price, currMinPrice);
        }


        return currBestProfit;
    }

    public int maxProfit2(int[] prices) {

        int max = 0;

        if (prices != null && prices.length > 0) {

            int l = 0;
            int r = 1;

            while (r < prices.length) {

                int currProfit = prices[r] - prices[l];

                if (currProfit > 0) {
                    if (currProfit > max) {
                        max = currProfit;
                    }
                    r++;
                } else {
                    l = r;
                    r = l + 1;
                }
            }

        }

        return max;

    }
}
