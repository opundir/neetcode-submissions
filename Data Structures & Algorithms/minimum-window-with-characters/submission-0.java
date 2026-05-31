class Solution {
    public String minWindow(String s, String t) {
        int n1 = s.length(), n2 = t.length();

        int minlen = Integer.MAX_VALUE;

        if(n1==0 || n2==0 || n2>n1){
            return new String();
        }
        int[] freq = new int[128];
        int count = n2;
        int startidx = 0;
        int j = 0;
        int i = 0;

        for(char ch : t.toCharArray()){
            freq[ch]++;
        }

        char[] str = s.toCharArray();

        while(j<n1){
            if(freq[str[j++]]-- > 0){
                count--;
            }
            while(count==0){
                if(j-i<minlen){
                    startidx = i;
                    minlen = j-i; 
                }
                if(freq[str[i++]]++==0){
                    count++;
                }
            }
        }
        return minlen == Integer.MAX_VALUE ? new String() : new String(str,startidx,minlen);

    }
}
