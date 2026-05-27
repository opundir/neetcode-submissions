class Solution {
    public int maxProfit(int[] prices) {
        int minval = Integer.MAX_VALUE;
        int ans = -1;
        for(int i=0; i<prices.length; i++){
            minval = Math.min(prices[i],minval);
            ans = Math.max(ans,prices[i]-minval);
        }
        return ans;
    }
}
