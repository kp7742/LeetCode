class Solution {
    public int removeElement(int[] nums, int val) {
        int l = 0; //length for new array after removing value
        int r = 0; //index for searching
        
        while(r < nums.length){
            if(nums[r] != val)
                nums[l++] = nums[r];
            r++;
        }
        
        return l;
    }
}