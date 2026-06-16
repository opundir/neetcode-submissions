class Pair{
    private String first;
    private int second;
    Pair(String first, int second){
        this.first = first;
        this.second = second;
    }
    
}
class TimeMap {
    HashMap<String,HashMap<Integer,String>> m;
    public TimeMap() {
        m = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!m.containsKey(key)){
            m.put(key, new HashMap<>());
        }
        m.get(key).put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        if(!m.containsKey(key)){
            return "";
        }
        HashMap<Integer,String> m1 = m.get(key);
        while(timestamp>0){
            if(m1.containsKey(timestamp)){
                return m1.get(timestamp);
            }
            timestamp--;
        }
        return "";
    }
}
