class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer,Integer> m = new HashMap<>();
        // if(nums.length<=2) return nums;
        for(int t : nums){
            m.put(t,m.getOrDefault(t,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b)->m.get(a)-m.get(b)
        );

        for(int key: m.keySet()){
            pq.add(key);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[] res = new int[k];
        int i=0;
        while(!pq.isEmpty()){
            res[i++] = pq.poll();
        }
        return res;
    }
}
