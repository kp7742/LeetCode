class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //Cyclic Sort: O(n)
        for(int i = 0; i < nums.length;){
            int num = nums[i];
            int realIdx = num - 1;
            
            if(num != nums[realIdx]){
                nums[i] = nums[realIdx];
                nums[realIdx] = num;
            } else {
                i++;
            }
        }
        
        //Result list with numbers from [1, n] not at correct position
        List<Integer> result = new ArrayList<>();
        for(int i = 1; i <= nums.length; i++){
            if(nums[i - 1] != i)
                result.add(i);
        }
        return result;
    }
}