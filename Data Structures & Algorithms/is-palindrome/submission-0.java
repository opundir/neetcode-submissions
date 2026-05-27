class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder st = new StringBuilder();
        int k = 0;
        while(k<s.length()){
            char ch = s.charAt(k);
            if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z') || (ch>='0' && ch<='9')){
                st.append(Character.toLowerCase(ch));
            }
            k++;
        }

        int i = 0, j = st.length()-1;
        while(i<j){
            char ith = st.charAt(i);
            char jth = st.charAt(j);
            if(ith!=jth){
                return false;
            }
            i++; j--;
        }
        return true;
    }
}
