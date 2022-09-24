class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {    	int TimeMonth;
    	int TimeYear;
    	
    	int[] answer_arr = new int[101];
    	int cnt = 0;
    	
    	for(int i = 0; i < privacies.length; i++) {
    		
			TimeMonth = 0;
			TimeYear = 0;
			
    		for(int j = 0; j < terms.length; j++) {
    			if(privacies[i].substring(11, 12).equals(terms[j].substring(0, 1))) {
    				TimeMonth = Integer.valueOf(privacies[i].substring(5, 7)) + Integer.valueOf(terms[j].substring(2));
    				// 개인정보를 받은 날 + 유효기간
    				
    				TimeYear = Integer.valueOf(privacies[i].substring(0, 4));	// 개인정보를 받은 년도
    				while(TimeMonth - 12 > 0) {	// 1년에 12개월이 최대이므로 초과할 경우
    					TimeMonth -= 12;	// 12개월을 빼준다.
    					TimeYear += 1;	// 개인정보를 받은 년도에 1년을 더해줌
    				}
    				if(TimeYear < Integer.valueOf(today.substring(0, 4))) {
    					answer_arr[cnt] = i + 1;
						cnt++;
    				}
    				else if(TimeYear == Integer.valueOf(today.substring(0, 4))) {
    					if(TimeMonth < Integer.valueOf(today.substring(5, 7))) {
    						answer_arr[cnt] = i + 1;
    						cnt++;
    					}
    					else if(TimeMonth == Integer.valueOf(today.substring(5, 7))) {
    						if(Integer.valueOf(privacies[i].substring(8, 10)) < Integer.valueOf(today.substring(8, 10))) {
    							answer_arr[cnt] = i + 1;
        						cnt++;
    						}
							else if(Integer.valueOf(privacies[i].substring(8, 10)) == Integer.valueOf(today.substring(8, 10))) {
    							answer_arr[cnt] = i + 1;
        						cnt++;
    						}
    					}
    				}
    			}
    		}
    	}
    	int[] answer = new int[cnt];
    	for(int i = 0; i < cnt; i++) {
			answer[i] = answer_arr[i];
    	}
        return answer;
    }
}
