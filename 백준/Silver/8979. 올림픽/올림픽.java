import static java.util.Arrays.*;
import static java.util.stream.Collectors.*;

import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int[] input = stream(br.readLine().split(" "))
                  .mapToInt(Integer::parseInt).toArray();

         int n = input[0]; // 나라 크기
         int query = input[1]; // 등수를 구할 나라

        // 정렬 기준 : 점수 내림차순 (key)
        TreeMap<Medal, ArrayList<Integer>> ranking = new TreeMap<>();

        for(int i=0;i<n;i++){
             int[] info = stream(br.readLine().split(" "))
                      .mapToInt(Integer::parseInt).toArray();
            Medal score = new Medal(info[1],info[2],info[3]);

            if(ranking.containsKey(score)){  // 해당 금,은,동 점수의 국가가 또 존재할 경우 추가
                ranking.get(score).add(info[0]);
            }else{
                ArrayList<Integer> nations = new ArrayList<>(); // 특정 금,은,동 스코어가 처음 나오면 Map에 추가
                nations.add(info[0]);
                ranking.put(score,nations);
            }
        }

        int ans=0; // 등수

        for (var entry : ranking.entrySet()) {
            ArrayList<Integer> nations = entry.getValue();

            if(nations.contains(query)){ // entry 를 탐색하던 도중 구하고 싶은 나라가 포함되어 있으면 등수 +1 하고 출력
                System.out.println(ans+1);
                break;
            }else ans+=nations.size(); // 나라들이 포함되어 있는 리스트 사이즈 만큼 등수 추가
        }
    }
    static class Medal implements Comparable<Medal>{
        int gold,silver,bronze;

        public Medal(int gold, int silver, int bronze) {
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Medal o) {

            if(o.gold == this.gold){
                if(o.silver==this.silver)
                    return o.bronze-this.bronze;
                return o.silver-this.silver;
            }
            return o.gold-this.gold;
        }
    }
}