class Solution {
    public int countSubstrings(String s) {
     int no = 0;
     int n = s.length(); 
     int res = 0;
     for(int i = 0 ; i < n ; i++){
        res += helper(s,i,i);
        res += helper(s,i,i+1);
     }  
     return res;
    }

    private int helper(String s,int l,int r){
        int res = 0;
        int n = s.length();
        while(l>=0 && r<n && s.charAt(l) == s.charAt(r)){
            res++;
            l--;
            r++;
        } 
        return res;
    }
}
