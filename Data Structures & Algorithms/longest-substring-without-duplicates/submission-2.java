class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        HashMap<Character,Integer> m = new HashMap<>();
        int i=0,j=0;
        int n = s.length();
        while(j<n){
            m.put(s.charAt(j), m.getOrDefault(s.charAt(j), 0) + 1);
            while(m.get(s.charAt(j))>1){
                m.put(s.charAt(i),m.get(s.charAt(i))-1);
                i++;
            }
            ans = Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}
