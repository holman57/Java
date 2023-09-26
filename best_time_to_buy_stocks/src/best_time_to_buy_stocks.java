class best_time_to_buy_stocks {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int n = prices.length;
        int[] memo = new int[n];
        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            memo[i] = Math.max(memo[i - 1], prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return memo[n - 1];
    }
}