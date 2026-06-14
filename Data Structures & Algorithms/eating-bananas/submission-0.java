class Solution {
    public boolean isValid(int mid, int[] piles, int h){
        int sum = 0;
        for(int i=0; i<piles.length; i++){
            sum += (piles[i] + mid - 1) / mid;
        }
        return sum<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        for(int i : piles){
            r = Math.max(i,r);
        }
        int ans = -1;
        int mid;
        while(l<r){
            mid = l+(r-l)/2;
            if(isValid(mid,piles,h)){
                ans = mid;
                r = mid;
            }
            else{
                 l = mid+1;
            }
        }
        return l;
    }
}
