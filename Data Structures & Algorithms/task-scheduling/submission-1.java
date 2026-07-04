class Solution {
    public int leastInterval(char[] tasks, int n) {
        int len = tasks.length;
        int[] cnt = new int[26];
        int maxF = 0;
        for(char ch : tasks){
            cnt[ch - 'A']++;
            maxF = Math.max(cnt[ch - 'A'],maxF);
        }

        int maxCnt = 0;
        for(int c : cnt){
            if(c == maxF) maxCnt ++;
        }

        int time = (maxF-1)*(n+1) + maxCnt;

        return Math.max(len,time);
    }
}
