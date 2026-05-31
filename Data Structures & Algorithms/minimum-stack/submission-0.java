class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first = first;
        this.second = second; 
    }
}

class MinStack {
    public List<Pair> st;
    public MinStack() {
        st = new ArrayList<>();
    }
    
    public void push(int val) {
        if(st.size()==0){
            st.add(new Pair(val,val));
            return;
        }
        Pair top = st.get(st.size()-1);
        int mini = Math.min(top.second,val);
        st.add(new Pair(val,mini));
    }
    
    public void pop() {
        st.remove(st.size()-1);
    }
    
    public int top() {
        return st.get(st.size()-1).first;
    }
    
    public int getMin() {
        return st.get(st.size()-1).second;
    }
}
