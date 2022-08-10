class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> left = new ArrayList<>();
        List<int[]> right = new ArrayList<>();
        
        for(int[] intv : intervals){
            if(newInterval[0] > intv[1]){ //When Start of new is bigger than end of curr
                left.add(intv);
            } else if(newInterval[1] < intv[0]) { //When End of new is smaller than start of cur
                right.add(intv);
            } else {
                //Merge intervals
                newInterval[0] = Math.min(newInterval[0], intv[0]);
                newInterval[1] = Math.max(newInterval[1], intv[1]);
            }
        }
        
        //Merge left part, mid part and right part
        left.add(newInterval);
        left.addAll(right);
        
        return left.toArray(new int[left.size()][]);
    }
}