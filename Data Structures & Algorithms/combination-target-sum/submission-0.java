class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    void solve(int idx, List<Integer> temp, int target, int[] nums, int n){
        if(idx>=n || target<=0){
            if(target==0){
                ans.add(new ArrayList<>(temp));
                return;
            }
            return;
        }
        int curr = nums[idx];
        temp.add(curr);
        solve(idx+1,temp,target-curr,nums,n);
        solve(idx,temp,target-curr,nums,n);
        temp.remove(temp.size()-1);
        solve(idx+1,temp,target,nums,n);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> temp = new ArrayList<>();
        solve(0,temp,target,nums,nums.length);
        Set<List<Integer>> res = new HashSet<>(ans);
        ans = new ArrayList<>(res);
        return ans;
        
    }
}
