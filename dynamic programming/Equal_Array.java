import java.util.Scanner;

public class Equal_Array {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		long prefix[] = new long[n + 1];
		long suffix[] = new long[n + 1];
		
		for(int i = 1, j = n; i <= n && j >= 1; ++i, --j) {
			
			prefix[i] = prefix[i - 1] + a[i];
			
			if(j == n) {
				
				suffix[j] = a[j];
				
			} else {
				
				suffix[j] = suffix[j + 1] + a[j];
				
			}
			
		}
		
		long min_number = Long.MAX_VALUE;
		
		for(int i = 1; i <= n - 1; ++i) {
			
			if(prefix[i] > suffix[i + 1]) {
				
				continue;
				
			}
			
			long x = Math.abs(prefix[i] - suffix[i + 1]);
			
			min_number = Math.min(min_number, x);
			
		}
		
		System.out.println(min_number);
		
	}
	
	public static void main(String [] args) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			
			a = new long[n + 1];
			
			for(int i = 1; i <= n; ++i) {
				
				a[i] = in.nextLong();
				
			}
			
			solve();
			
		}
		
	}
	
}