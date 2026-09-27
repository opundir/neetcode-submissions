class Solution {
    public int trap(int[] height) {
        int cnt = 0;
        int n = height.length;
        if(n<=1) return cnt;
        int[] premax = new int[n];
        int[] suffmax = new int[n];

        premax[0]=height[0];
        suffmax[n-1]=height[n-1];
        for(int i=1; i<n; i++){
            premax[i] = Math.max(premax[i-1],height[i]);
        }
        for(int i=n-2; i>=0; i--){
            suffmax[i] = Math.max(suffmax[i+1],height[i]);
        }
        for(int i=0; i<height.length; i++){
            if(height[i]<premax[i] && height[i]<suffmax[i]){
                cnt = cnt + (Math.min(premax[i],suffmax[i])-height[i]);
            }
        }
        return cnt;
    }
}
