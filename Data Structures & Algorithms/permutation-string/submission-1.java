class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq1 = new int[26];
        for(int i=0; i<s1.length(); i++){
            freq1[s1.charAt(i)-'a']++;
        }
        int i=0,j=0;
        int[] freq2 = new int[26];
        if(s1.length()>s2.length()) return false;
        while(j<s2.length() && j<s1.length()){
            freq2[s2.charAt(j)-'a']++;
            j++;
        }
        while(j<s2.length()){
            if(Arrays.equals(freq2,freq1)){
                return true;
            }
            freq2[s2.charAt(j)-'a']++;
            freq2[s2.charAt(i)-'a']--;
            i++; j++;
        }
        if(Arrays.equals(freq2,freq1)) return true;
        return false;
        
    }
}
