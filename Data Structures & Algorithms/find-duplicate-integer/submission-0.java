class Solution {
    public int findDuplicate(int[] nums) {
        HashMap<Integer,Boolean> m = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(m.containsKey(nums[i])){
                return nums[i];
            }
            m.put(nums[i],true);
        }
        return -1;
    }
}
