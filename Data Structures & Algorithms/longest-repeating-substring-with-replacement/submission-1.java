class Solution {
    public int characterReplacement(String s, int k) {
        int i=0,j=0;
        int[] freq = new int[26];
        int ans = 0;
        int max = 0;
        while(j<s.length()){
            freq[s.charAt(j)-'A']++;
            max = Math.max(max,freq[s.charAt(j)-'A']);
            if(j-i-max+1>k){
                freq[s.charAt(i)-'A']--;
                i++;
            }
            ans = Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}
