class Solution {
    public boolean isValid(String s) {
        StringBuilder st = new StringBuilder(s);
        int top = -1;
        for(int i=0; i<s.length(); i++){
            if(st.charAt(i)=='(' ||
            st.charAt(i)=='[' ||
            st.charAt(i)=='{'){
                top++;
                st.setCharAt(top,st.charAt(i));
            }
            else if(st.charAt(i)==')' ||
            st.charAt(i)=='}' ||
            st.charAt(i)==']'){
                if(top==-1) return false;
                if(
                (st.charAt(i)==')' && st.charAt(top)!='(') ||
                (st.charAt(i)=='}' && st.charAt(top)!='{') ||
                (st.charAt(i)==']' && st.charAt(top)!='[')){
                return false;
            }
            top--;
            }
        }
        return top==-1;
    }
}
