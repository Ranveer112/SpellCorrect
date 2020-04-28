class Solution {
    public int minDistance(String word1, String word2) {
        if(word1.length()==0 || word2.length()==0){
            return Math.max(word1.length(), word2.length());
        }
        int[][] dp=new int[word1.length()][word2.length()];
        for(int i=word1.length()-1;i>=0;i--){
            for(int j=word2.length()-1;j>=0;j--){
                if(i==word1.length()-1 && j==word2.length()-1){
                    dp[i][j]=word1.charAt(i)==word2.charAt(j)?0:1;
                    continue;
                }
                if(i==word1.length()-1){
                    dp[i][j]=Math.min(word1.charAt(i)==word2.charAt(j)?word2.length()-1-j:Integer.MAX_VALUE, 1+dp[i][j+1]);            
                    continue;
                }
                if(j==word2.length()-1){
                    dp[i][j]=Math.min(word1.charAt(i)==word2.charAt(j)?word1.length()-1-i:Integer.MAX_VALUE, 1+dp[i+1][j]);
                    continue;
                }
                dp[i][j]=Math.min(1+dp[i][j+1], Math.min(1+dp[i+1][j], (word1.charAt(i)==word2.charAt(j)?0:1)+dp[i+1][j+1]));           
            }
        }
        return dp[0][0];
    }
}