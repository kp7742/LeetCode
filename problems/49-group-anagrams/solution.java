class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //Map for anagram groups
        Map<String, List<String>> map = new HashMap<>();
        
        //Go through each word
        for(String s : strs){
            //Sort characters of word
            char[] sArr = s.toCharArray();
            Arrays.sort(sArr);
            String sorted = new String(sArr);
            
            //Use sorted string for key
            if(!map.containsKey(sorted))
                map.put(sorted, new ArrayList<>());
            
            map.get(sorted).add(s);
        }
        
        return new ArrayList(map.values());
    }
}