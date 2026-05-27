class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i],i);
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int target = 0;
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int j = i+1;
            int k = n-1;
            while(j<k && j<n && k>=0){
                if(nums[i]+nums[j]+nums[k]==target){
                    ans.add(new ArrayList<>(List.of(nums[i],nums[j],nums[k])));
                    while(j<k && nums[j]==nums[j+1]) j++;
                    while(j<k && nums[k]==nums[k-1]) k--;
                    j++; k--;
                } else if(nums[i]+nums[j]+nums[k]<target){
                    j++;
                } else{
                    k--;
                }
            }
        }

        return ans;
    }
}
