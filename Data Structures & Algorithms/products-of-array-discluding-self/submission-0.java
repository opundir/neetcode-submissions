class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] st = new int[n];
        int[] end = new int[n];
        int mst = 1, mend = 1;
        
        for(int i=0; i<n; i++){
            st[i] = nums[i]*mst;
            mst = st[i];
            end[n-i-1] = nums[n-i-1]*mend;
            mend =  end[n-i-1];
        }
        int[] ans = new int[n];
        for(int i=1; i<n-1; i++){
            ans[i] = st[i-1]*end[i+1];
        }
        ans[0] = end[1];
        ans[n-1] = st[n-2];
        return ans;
        
    }
}  
