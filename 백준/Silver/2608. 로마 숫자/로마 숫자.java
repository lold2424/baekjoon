import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws IOException {
		char[] RomeC = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
		int[] RomeN = {1, 5, 10, 50, 100, 500, 1000};
		String[][] RSPRomeC = {{"IV", "IX"}, {"XL", "XC"}, {"CD", "CM"}};
		String[][] SPRomeC = {{"I", "V"}, {"X", "L"}, {"C", "D"}, {"M"}};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Nanswer = 0;
		
		for(int i = 0; i < 2; i++){
			String input = br.readLine();
			int whileI = 0;
			int answer = 0;
			while(whileI < input.length()){
				char temp = input.charAt(whileI);
				int index = -1;
				for(int j = 0; j < 7; j++)
					if(temp == RomeC[j]){
						index = j;
						break;
					}
				
				if(whileI != input.length() - 1 && (index % 2 == 0) && index != 6){
					char nexttemp = input.charAt(whileI + 1);
					if(nexttemp == RomeC[index + 1]){
						answer += RomeN[index + 1] - RomeN[index];
						whileI += 2;
					}
					else if(nexttemp == RomeC[index + 2]){
						answer += RomeN[index + 2] - RomeN[index];
						whileI += 2;
					}
					else{
						answer += RomeN[index];
						whileI ++;
					}
				}
				else{
					answer += RomeN[index];
					whileI ++; 
				}
			}
			Nanswer += answer;
		}
		
		String Sanswer = new String("");
		int tempN = Nanswer;
		int Nofunit = String.valueOf(tempN).length() - 1;
		int remN = (int)Math.pow(10, Nofunit);
		int curN;
		
		while(tempN > 0){
			curN = tempN / remN;
			if(curN >= 1 && curN <= 3) {
				for(int i = 0; i < curN; i++)
					Sanswer += SPRomeC[Nofunit][0];
			} else if(curN == 4) {
				Sanswer += RSPRomeC[Nofunit][0];
			} else if(curN >= 5 && curN <= 8) {
				Sanswer += SPRomeC[Nofunit][1];
				for(int i = 5; i < curN; i++) {
					Sanswer += SPRomeC[Nofunit][0];
				}
			}
			else if(curN == 9) {
				Sanswer += RSPRomeC[Nofunit][1];
			}
			tempN -= curN * remN;
			Nofunit--;
			remN /= 10;
		}
		
		System.out.println(Nanswer);
		System.out.println(Sanswer);
	}
}