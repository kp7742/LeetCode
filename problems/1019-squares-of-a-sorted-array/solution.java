class Solution {
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        
        if(len == 0)
            return null;
        else if(len == 1)
            return new int[] {nums[0] * nums[0]};
        
        int l = 0; //for smaller numbers
        int r = len - 1; //for bigger numbers
        int[] results = new int[len];

        while(l <= r){
            if(Math.abs(nums[l]) > Math.abs(nums[r])){
                results[r - l] = nums[l] * nums[l];
                l++;
            } else {
                results[r - l] = nums[r] * nums[r];
                r--;
            }
        }

        return results;
    }
}