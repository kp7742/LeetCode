class Solution {
    public int removeDuplicates(int[] nums) {
        int ndi = 0; //non-duplicate index
        int sdi = 1; //search duplicate index
        
        while(sdi < nums.length){
            //when find duplicate
            //move forward to search more
            if(nums[ndi] == nums[sdi]){
                sdi++;
                continue;
            }
            
            //when no more duplicate there
            //write new non-duplicate at next non-duplicate index
            nums[++ndi] = nums[sdi];
        }
        
        return (ndi+1);
    }
}