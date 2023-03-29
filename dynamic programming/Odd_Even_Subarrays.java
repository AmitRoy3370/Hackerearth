import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Odd_Even_Subarrays {
	
	static Scanner in = new Scanner(System.in);
	
	static int n;
	
	static long a[];
	
	static void solve() {
		
		long dp[] = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			if(a[i] % 2L == 0L) {
				
				dp[i] = 1L;
				
			} else {
				
				dp[i] = -1L;
				
			}
			
		}
		
		for(int i = 1; i < n; ++i) {
			
			dp[i] += dp[i - 1];
			
		}
		
		Map<Long, Integer> map = new HashMap<>();
		
		map.put(0L, 1);
		
		long sum = 0L;
		
		for(int i = 0; i < n; ++i) {
			
			sum += map.getOrDefault(dp[i], 0);
			
			map.put(dp[i], map.getOrDefault(dp[i], 0) + 1);
			
		}
		
		System.out.println(sum);
		
	}
	
	public static void main(String [] priya) {
		
		input();
		solve();
		
	}
	
	static void input() {
		
		n = in.nextInt();
		
		a = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
}