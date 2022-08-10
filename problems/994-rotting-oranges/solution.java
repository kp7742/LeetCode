class Solution {
    public int orangesRotting(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        int time = 0, freshOrng = 0;
        LinkedList<int[]> queue = new LinkedList<>();
        
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i, j});
                } else if(grid[i][j] == 1){
                    freshOrng++;
                }
            }
        }
        
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        while(freshOrng > 0 && !queue.isEmpty()){
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                int[] pos = queue.poll();
                
                for(int[] dir : dirs){
                    int row = pos[0] + dir[0];
                    int col = pos[1] + dir[1];
                    
                    if(row >= 0 && col >= 0 && row < R && col < C && grid[row][col] == 1){
                        queue.add(new int[]{row, col});
                        grid[row][col] = 2;
                        freshOrng--;
                    }
                }
            }
            
            time++;
        }
        
        return freshOrng > 0 ? -1 : time;
    }
}