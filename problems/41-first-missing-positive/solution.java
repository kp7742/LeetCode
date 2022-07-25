class Solution {
    public int firstMissingPositive(int[] nums) {
        //Cyclic sort: O(N)
        for(int i = 0; i < nums.length;){
            int num = nums[i];
            int realIdx = num - 1;
            
            if(num > 0 && num < nums.length && num != nums[realIdx]){
                //Swap with correct index
                nums[i] = nums[realIdx];
                nums[realIdx] = num;
            } else {
                //If already on right place move forward
                i++;
            }
        }
        
        //Find first missing positive from [1,nums.length + 1]
        for(int i = 1; i <= nums.length; i++){
            if(nums[i - 1] != i){
                return i;
            }
        }
        return nums.length + 1;
    }
}