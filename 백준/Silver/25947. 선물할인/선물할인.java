import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    int n, b, a;
    int nums[];
    public static void main(String args[]) throws IOException {
        Main m = new Main();
        m.sol();

    }
    public int getN(){
        boolean temp = true;
        int right =0;
        int left =0;
        for(int i = 0 ;i < a ; i++){
            b-=nums[i]/2;
            right = i+1;
            if(b < 0){
                temp = false;
                return i;
            }
        }
        if(temp){
            while(right < n){

                if(right - left < a){
                    b-=nums[right]/2;//할인된가격 산다.
                    if(b < 0) break;
                    right++;
                }else{
                    if(a >0)b-=nums[left++]/2;
                    else {
                        b-= nums[right];
                        if(b < 0)break;
                        right++;
                    }
                }
            }
            return right;
        }
        return right;
    }
    public void sol() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String q = br.readLine();
        n= Integer.parseInt(q.split(" ")[0]);
        b= Integer.parseInt(q.split(" ")[1]);
        a = Integer.parseInt(q.split(" ")[2]);//최대 선물의 수d
        nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i< n;i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        System.out.println(getN());
    }


}