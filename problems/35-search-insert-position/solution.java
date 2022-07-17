class Solution {
    public int searchInsert(int[] nums, int target) {
        //Seems like binary search, O(logn)
        int l = 0, r = nums.length;
        
        while(l < r){
            int m = l + (r - l) / 2;
            
            if(nums[m] >= target){
                r = m;
            } else {
                l = m + 1;
            }
        }
        
        return r;
    }
}