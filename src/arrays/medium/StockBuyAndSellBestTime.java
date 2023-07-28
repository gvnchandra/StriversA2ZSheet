package arrays.medium;

public class StockBuyAndSellBestTime {
    public static void main(String[] args) {
        int[] prices = {7,1,5,4,3,6};
        System.out.print(bestTimeToBuyAndSellStock(prices));
    }

    public static int bestTimeToBuyAndSellStock(int []prices) {
        int cost = prices[0], maxProfit=0;
        for (int i = 0; i <prices.length ; i++) {
            maxProfit = Math.max(maxProfit, prices[i]-cost);
            cost = Math.min(cost, prices[i]);
        }
        return maxProfit;
    }
}
