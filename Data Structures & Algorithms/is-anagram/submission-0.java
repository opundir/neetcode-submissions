class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> m1 = new HashMap<>(),m2 = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            m1.put(s.charAt(i), m1.getOrDefault(s.charAt(i), 0) + 1);
        }
        for(int i=0; i<t.length(); i++){
            m2.put(t.charAt(i), m2.getOrDefault(t.charAt(i), 0) + 1);
        }
        return m1.equals(m2);

        
    }
}
