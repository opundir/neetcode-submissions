class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> m = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(m.containsKey(nums[i])){
                m.put(nums[i],m.get(nums[i])+1);
            }
            else{
                m.put(nums[i],1);
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.second-b.second);

        for(Map.Entry<Integer,Integer> entry : m.entrySet()){
            pq.offer(new Pair(entry.getKey(),entry.getValue()));
            if(pq.size() > k){
                pq.poll();
            }
        }

        int[] res = new int[k];
        for(int i=k-1; i>=0; i--){
            res[i] = pq.poll().first;
        }
        return res;
    }
}
