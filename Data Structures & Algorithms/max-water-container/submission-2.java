class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;

        int i=0,j=n-1;
        int ans = Integer.MIN_VALUE;
        while(i<j){
            ans = Math.max(ans,(j-i)*Math.min(heights[j],heights[i]));
            if(heights[j]>heights[i]){
                i++;
            }
            else{
                j--;
            }
        }
        return ans;
    }
}
