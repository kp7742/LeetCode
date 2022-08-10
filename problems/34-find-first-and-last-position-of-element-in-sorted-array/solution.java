class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{binarySearch(nums, target, true), binarySearch(nums, target, false)};
    }
    
    public int binarySearch(int[] nums, int target, boolean left){
        int l = 0, r = nums.length - 1, i = -1;
        
        while(l <= r){
            int m = l + (r - l) / 2;
            
            if(nums[m] == target){
                i = m;
                //Bias left or right pointer to cross out 
                if(left){
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else if(nums[m] < target){
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        
        return i;
    }
}