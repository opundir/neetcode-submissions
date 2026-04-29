class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> ans = new HashMap<>();
        for(int i=0; i<strs.length; i++){
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String key = new String(temp);
            ans.putIfAbsent(key,new ArrayList<>());
            ans.get(key).add(strs[i]);
        }
        return new ArrayList<>(ans.values());
    }
}
