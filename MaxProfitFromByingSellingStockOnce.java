// Given a array of numbers representing the stock prices of a company in chronological order, 
// write a function that calculates the maximum profit you could have made from buying and selling that stock once. 
// You must buy before you can sell it.

// For example, given [9, 11, 8, 5, 7, 10], you should return 5, since you could buy the stock at 5 dollars and sell it at 10 dollars.



// Time Complexity is O(n) and space complexity is O(1).
class MaxProfitFromByingSellingStockOnce {
	
    public int solution(int[] stockPrices) {

        int maxProfit = 0;
        int min = stockPrices[0];

        for(int day = 1; day < stockPrices.length; day++) {

            int curMaxProfit = stockPrices[day] - min;
            maxProfit = day == 1 ? curMaxProfit : Math.max(maxProfit, curMaxProfit);
            min = Math.min(min, stockPrices[day]);
        }

        return maxProfit;
    }

    public static void main(String... args) {

    	MaxProfitFromByingSellingStockOnce obj = new MaxProfitFromByingSellingStockOnce();

        System.out.println(obj.solution(new int[] { 9, 11, 8, 5, 7, 10 }));
    }
}