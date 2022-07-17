class Solution {
    public int[][] transpose(int[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        
        int[][] result = new int[c][r];
        
        for(int i = 0; i < c; i++)
            for(int j = 0; j < r; j++)
                result[i][j] = matrix[j][i];
        
        return result;
    }
}