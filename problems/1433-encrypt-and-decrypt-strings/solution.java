class Encrypter {
    String[] emap = new String[26];
    HashMap<String, Integer> dmap = new HashMap<>();

    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        Arrays.fill(emap, "|");
        for(int i=0; i < keys.length; i++){
            emap[keys[i] - 'a'] = values[i];
        }
        
        for(String dic : dictionary){
            String enc = encrypt(dic);
            dmap.put(enc, dmap.getOrDefault(enc, 0) + 1);
        }
    }
    
    public String encrypt(String word1) {
        StringBuilder sb = new StringBuilder();
        for(char c : word1.toCharArray()){
            sb.append(emap[c - 'a']);
        }
        return sb.toString();
    }
    
    public int decrypt(String word2) {
        return dmap.getOrDefault(word2, 0);
    }
}

/**
 * Your Encrypter object will be instantiated and called as such:
 * Encrypter obj = new Encrypter(keys, values, dictionary);
 * String param_1 = obj.encrypt(word1);
 * int param_2 = obj.decrypt(word2);
 */