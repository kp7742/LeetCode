class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        
        int start = 0;
        int end = (m * n) - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            int r = mid / n, c = mid % n;
            
            if(matrix[r][c] == target){
                return true;
            } else if(matrix[r][c] < target){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return false;
    }
}