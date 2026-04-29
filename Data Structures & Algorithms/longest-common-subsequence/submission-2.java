class Solution {
    int solve(int i1,int i2, String s1, String s2,int[][] dp){
        if(i1>=s1.length() || i2>=s2.length()){
            return 0;
        }
        if(dp[i1][i2]!=-1) return dp[i1][i2];
        if(s1.charAt(i1)==s2.charAt(i2)){
            return dp[i1][i2] = 1+solve(i1+1,i2+1,s1,s2,dp);
        }
        return dp[i1][i2]=Math.max(solve(i1+1,i2,s1,s2,dp),solve(i1,i2+1,s1,s2,dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int i=0; i<text1.length(); i++){
            for(int j=0; j<text2.length(); j++){
                dp[i][j]=0;
            }
        }
        for(int i=1; i<=text1.length(); i++){
            for(int j=1; j<=text2.length(); j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        // return solve(0,0,text1,text2,dp);
        return dp[text1.length()][text2.length()];
    }
}
