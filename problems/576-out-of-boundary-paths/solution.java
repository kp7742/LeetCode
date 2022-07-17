class Solution {
    int mod = (int)1e9 + 7;
    
    public long countPaths(long[][][] dp, int m, int n, int maxMove, int i, int j){
        //Found out of boundry path
        if(i < 0 || j < 0 || i >= m || j >= n){
            return 1;
        }
        
        //Found in DP
        if(dp[i][j][maxMove] != -1)
            return dp[i][j][maxMove];
        
        //No more moves left, exit this trip
        if(maxMove == 0)
            return 0;
        
        //4 Possible direction [(-1,0),(0,-1),(1,0),(0,1)]
        long count = 0;
        count += countPaths(dp, m, n, maxMove - 1, i - 1, j);
        count += countPaths(dp, m, n, maxMove - 1, i, j - 1);
        count += countPaths(dp, m, n, maxMove - 1, i + 1, j);
        count += countPaths(dp, m, n, maxMove - 1, i, j + 1);
        
        //Store in DP
        return dp[i][j][maxMove] = count % mod;
    }
    
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        long dp[][][] = new long[m][n][maxMove+1];
        
        for(long[][] row: dp){
            for(long[] col : row){
                Arrays.fill(col, -1);
            }
        }
        
        return (int)countPaths(dp, m, n, maxMove, startRow, startColumn) % mod;
    }
}