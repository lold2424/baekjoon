import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer token = new StringTokenizer( br.readLine() );
		long injured = Long.parseLong( token.nextToken() );
		token = new StringTokenizer( br.readLine() );
		long limit = Long.parseLong( token.nextToken() );

		if ( injured == 1 )
			System.out.print( 8 * limit );
		if ( injured == 2 ) {
			if ( limit % 2 == 0 ) {
				System.out.print( 8 * (limit / 2) + 1 );
			} else {
				System.out.print( 8 * (limit / 2 + 1) - 1 );
			}
		}
		if ( injured == 3 )
			System.out.print( 4 * limit + 2 );
		if ( injured == 4 ) {
			if ( limit % 2 == 0 ) {
				System.out.print( 8 * limit / 2 + 3 );
			} else {
				System.out.print( 4 * limit + 1 );
			}
		}
		if ( injured == 5 )
			System.out.print( 8 * limit + 4 );
	}
}