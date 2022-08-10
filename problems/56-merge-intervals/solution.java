class Solution {
    public int[][] merge(int[][] intervals) {
        //Sort intervals based on start time
        Arrays.sort(intervals, (int[] x, int[] y) -> Integer.compare(x[0], y[0]));
        
        //Result list
        LinkedList<int[]> result = new LinkedList<>();
        result.add(intervals[0]);
        
        for(int[] intv : intervals){
            int start = intv[0];
            int end = intv[1];
            int[] last = result.getLast();
            
            //Merge intervals if start is not larger then previous end
            if(start <= last[1]){
                last[1] = Math.max(last[1], end);
            } else {
                //Add new interval to result
                result.add(intv);
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
}