class Solution {
    public void moveZeroes(int[] nums) {
        int r = 0; //next index
        
        for(int l = 0; l < nums.length; l++){
            if(nums[l] != 0){
                //Swap non-zero with zero
                int temp = nums[r];
                nums[r] = nums[l];
                nums[l] = temp;
                r++;
            }
        }
    }
}