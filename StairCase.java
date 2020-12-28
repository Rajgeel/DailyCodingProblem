/*
There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time. Given N, write a function that returns the number of unique ways you can climb the staircase. The order of the steps matters.

For example, if N is 4, then there are 5 unique ways:

1, 1, 1, 1
2, 1, 1
1, 2, 1
1, 1, 2
2, 2
What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number from a set of positive integers X? For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.
*/


import java.util.Scanner;


//Time Complexity is O(n) and space complexity is O(n);
class StairCase {

	int dp[];

	public int recur(int i) {

		if(i == 1) {
			return 1;
		}

		if(i == 2) {
			return 2;
		}

		if(dp[i] != -1) {
			return dp[i];
		}

		dp[i] = recur(i-1) + recur(i-2);

		return dp[i];
	}
	
	public static void main(String... s) {

		StairCase obj = new StairCase();

		Scanner sc = new Scanner(System.in);

		int stair = sc.nextInt();

		obj.dp = new int[stair+1];

		for(int i=0; i<=stair; i++) {
			obj.dp[i] = -1;
		}

		System.out.println(obj.recur(stair));
	}
}