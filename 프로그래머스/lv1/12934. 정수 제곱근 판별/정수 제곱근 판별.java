class Solution {
    public long solution(long n) {
        long answer = 0;
        
        if(Math.sqrt(n) % 1 == 0) {
            long num = (long)Math.sqrt(n) + 1;
            answer = num * num;
            
        }
        
        else {
            answer = -1;
        }
        
        return answer;
    }
}