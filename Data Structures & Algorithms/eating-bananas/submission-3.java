class Solution {
    public boolean valid(int mid, int[] piles, int h){
        long cnt = 0;
        for(int i=0; i<piles.length; i++){
            cnt+=(piles[i]+mid-1)/mid;
            if(cnt>h) return false;
        }
        return true;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;

        for(int i=0; i<piles.length; i++){
            r = Math.max(r,piles[i]);
        }

        while(l<=r){
            int mid = l + (r-l)/2;
            if(valid(mid,piles,h)){
                r = mid-1;
            } 
            else{
                l = mid+1;
            }
        }
        return l;
    }
}
