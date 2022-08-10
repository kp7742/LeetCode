class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int area = 0;
        
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                //Skip water
                if(grid[r][c] == 0)
                    continue;
                
                //Go though island and mark the visit
                area = Math.max(area, dfs(grid, r, c));
            }
        }
        
        return area;
    }
    
    public int dfs(int[][] grid, int r, int c){
        //Base case
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0)
            return 0;
        
        //Make '1' to '0' to mark the visit
        grid[r][c] = 0;
        
        //Go in all direction
        int count = 1;
        count += dfs(grid, r + 1, c);
        count += dfs(grid, r, c + 1);
        count += dfs(grid, r - 1, c);
        count += dfs(grid, r, c - 1);
        
        return count;
    }
}