class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        //Sort in decreasing order of number of units
        Arrays.sort(boxTypes, (a,b)-> Integer.valueOf(b[1]).compareTo(Integer.valueOf(a[1])));
        
        int result = 0;
        int boxIdx = 0;
        
        while(boxIdx < boxTypes.length && truckSize > 0){
            int box = boxTypes[boxIdx][0];
            int unit = boxTypes[boxIdx][1];
                
            if(truckSize - box > 0){
                result += (box * unit);
                truckSize -= box;
            } else {
                result += (truckSize * unit);
                truckSize = 0;
            }
            
            boxIdx++;
        }
        
        return result;
    }
}