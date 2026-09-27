class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = {-1,-1};
        int n = numbers.length;

        int i=0,j=numbers.length-1;
        while(i<j){
            int sum = numbers[i]+numbers[j];
            if(sum==target){
                ans[0]=i+1;
                ans[1]=j+1;
                return ans;
            }
            if(sum>target) j--;
            else i++;
        }
        return ans;
    }
}
