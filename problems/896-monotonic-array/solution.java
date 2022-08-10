class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean incr = true, decr = true;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] < nums[i+1])
                decr = false;
            if(nums[i] > nums[i+1])
                incr = false;
        }
        return incr || decr;
    }
}