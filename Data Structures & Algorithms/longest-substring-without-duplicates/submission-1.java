class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[26];
        int i=0,j=0;
        int ans = 0;
        HashMap<Character,Integer> m = new HashMap<>();
        while(j<s.length()){
            Character ch = s.charAt(j);
            if(m.containsKey(ch)){
                m.put(ch,m.get(ch)+1);
            }
            else{
                m.put(ch,1);
            }
            // freq[ch]++;
            while(i<j && m.get(ch)>1){
                m.put(s.charAt(i),m.get(s.charAt(i))-1);
                i++;
            }
            ans = Math.max(ans,j-i+1);
            j++;
        }
        ans = Math.max(ans,j-i);
        return ans;
    }
}
