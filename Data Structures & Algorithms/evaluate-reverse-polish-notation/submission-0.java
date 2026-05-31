class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st =new Stack<>();
        for(int i=0; i<tokens.length; i++){
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){
                int a = Integer.parseInt(st.peek());
                st.pop();
                int b = Integer.parseInt(st.peek());
                st.pop();
                if(tokens[i].equals("+")){
                    st.push(String.valueOf(a+b));
                }
                else if(tokens[i].equals("-")){
                    st.push(String.valueOf(b-a));
                }
                else if(tokens[i].equals("/")){
                    st.push(String.valueOf(b/a));
                }
                else if(tokens[i].equals("*")){
                    st.push(String.valueOf(a*b));
                }
                else{
                    //
                }

            }
            else{
                st.push(tokens[i]);
            }
        }
        return Integer.parseInt(st.peek());
    }
}
