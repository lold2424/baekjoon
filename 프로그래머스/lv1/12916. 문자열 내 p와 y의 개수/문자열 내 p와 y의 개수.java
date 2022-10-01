class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        char string[] = s.toCharArray();
        int p_cnt = 0;
        int y_cnt = 0;
		
        for(int i = 0; i < s.length(); i++) {
            if((byte)string[i] == 112 || (byte)string[i] == 80) {
            	p_cnt ++;
            }
            else if((byte)string[i] == 121 || (byte)string[i] == 89) {
            	y_cnt ++;
            }
        }
        
        if(p_cnt != y_cnt) {
        	answer = false;
        }
        
        return answer;
    }
}