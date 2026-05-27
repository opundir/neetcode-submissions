class Solution {
    public boolean validate(char ch){
        if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z') ||
        (ch>='0' && ch<='9')){
            return true;
        }
        return false;
    }
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;

        while(i<j){
            while(i<s.length() && !validate(s.charAt(i))){
                i++;
            }
            while(j>=0 && !validate(s.charAt(j))){
                j--;
            }
            if(i>j){
                return true;
            }
            char ith = Character.toLowerCase(s.charAt(i));
            char jth = Character.toLowerCase(s.charAt(j));
            if(ith!=jth) return false;
            i++; j--;
        }
        return true;
    }
}
