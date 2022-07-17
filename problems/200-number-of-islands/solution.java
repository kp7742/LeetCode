class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                //Skip water
                if(grid[r][c] == '0')
                    continue;
                
                //Found island
                result++;
                
                //Go though island and mark the visit
                dfs(grid, r, c);
                
            }
        }
        
        return result;
    }
    
    public void dfs(char[][] grid, int r, int c){
        //Base case
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0')
            return;
        
        //Make '1' to '0' to mark the visit
        grid[r][c] = '0';
        
        //Go in all direction
        dfs(grid, r + 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r - 1, c);
        dfs(grid, r, c - 1);
    }
}