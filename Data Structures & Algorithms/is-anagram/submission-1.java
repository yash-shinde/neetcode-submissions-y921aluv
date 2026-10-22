class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        //sort and compare nlogn + mlogm
        //compare hashmaps n + m  
        //hash table - space efficient uses constant space
        int[] charCnt = new int[26];
        int n = s.length();
        for(int i=0;i<n;i++){
            charCnt[s.charAt(i) - 'a']++;
            charCnt[t.charAt(i) - 'a']--;
        }

        //check if it is all zeroes
        for(int i=0;i<26;i++){
            if(charCnt[i] != 0) return false;
        }
        return true;

    }
}
