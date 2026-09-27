class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> m = new HashMap<>();
        int n = s.length();
        int i=0,j=0;
        int ans=0;
        if(n==1) return 1;
        while(i<n && j<n){
            if(m.containsKey(s.charAt(j))){
                m.put(s.charAt(j),m.get(s.charAt(j))+1);
            }
            else{
                m.put(s.charAt(j),1);
            }
            while(i<n && m.get(s.charAt(j))>1){
                m.put(s.charAt(i),m.get(s.charAt(i))-1);
                i++;
            }
            ans = Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}
