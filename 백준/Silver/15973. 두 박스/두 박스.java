import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int px1 = Integer.parseInt(st.nextToken());
		int py1 = Integer.parseInt(st.nextToken());
		int px2 = Integer.parseInt(st.nextToken());
		int py2 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int qx1 = Integer.parseInt(st.nextToken());
		int qy1 = Integer.parseInt(st.nextToken());
		int qx2 = Integer.parseInt(st.nextToken());
		int qy2 = Integer.parseInt(st.nextToken());
		
		if (px2 < qx1 || px1 > qx2 || py2 < qy1 || py1 > qy2) System.out.println("NULL");
		else if (px2 == qx1 & py2 == qy1 || px2 == qx1 & py1 == qy2	||
				px1 == qx2 & py2 == qy1 || px1 == qx2 & py1 == qy2) System.out.println("POINT");
		else if (px2 == qx1 ^ py2 == qy1 || px2 == qx1 ^ py1 == qy2 ||
				px1 == qx2 ^ py2 == qy1 || px1 == qx2 ^ py1 == qy2) System.out.println("LINE");
		else System.out.println("FACE");
	}
}