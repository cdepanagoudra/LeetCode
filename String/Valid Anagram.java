class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }

        int[] sArr= new int[26];
       

        for(int i=0; i<s.length();i++){
            sArr[s.charAt(i)-'a']++;
            sArr[t.charAt(i)-'a']--;
        }
        for(int i : sArr){
            if(0!=i){
                return false;
            }
        }
        return true;

    }
}