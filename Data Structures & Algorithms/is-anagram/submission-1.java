class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int[] cmap = new int[26];
        for(int i=0; i<s.length(); i++){
            cmap[s.charAt(i)-'a']++;
            cmap[t.charAt(i)-'a']--;
        }

        for(int c : cmap){
            if(c!=0) return false;
        }
        return true;

        
    }
}
