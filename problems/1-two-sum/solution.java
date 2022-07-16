import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i < nums.length; i++){
            int num = nums[i];
            int iloc = map.getOrDefault(num, -1);
            if(iloc >= 0){
                return new int[]{iloc, i};
            }
            map.put(target - num, i);
        }
        return new int[]{-1,-1};
    }
}