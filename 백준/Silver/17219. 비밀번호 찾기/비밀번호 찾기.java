import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    Map<String,String> m = new HashMap<>();
	    
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    
	    for(int i=0; i<N; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	m.put(st.nextToken(), st.nextToken());
	    }
	    
	    for(int i=0; i<M; i++) {
	    	String temp = br.readLine();
	    	bw.append(m.get(temp)+"\n");
	    }
	    
	    br.close();
	    bw.flush();
	    bw.close();
	}
}