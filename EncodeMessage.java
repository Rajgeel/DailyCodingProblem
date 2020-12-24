/*
Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.

For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.

You can assume that the messages are decodable. For example, '001' is not allowed.
*/


//Time complexity is O(n) and space complexity is O(n)
import java.util.Scanner;

class EncodeMessage {
	
	public int solution(String s) {

		int n = s.length();

		int dp[] = new int[n+1];

		dp[0] = 1;
		dp[1] = 1;

		if(s.charAt(0) == '0') {
				return 0;
		}

		for(int i=2; i<=n; i++) {

			if(s.charAt(i-1) > '0') {
				dp[i] = dp[i-1];
			}

			if(s.charAt(i-2) == '1' || (s.charAt(i-2) == '2' && s.charAt(i-1) < '7')) {

				dp[i] = dp[i] + dp[i-2];
			}
		}

		return dp[n];
	}

	public static void main(String... s){

		EncodeMessage obj = new EncodeMessage();
		Scanner sc = new Scanner(System.in);

		String string = sc.next();

		int ans = obj.solution(string);

		System.out.println(ans);

	}
}