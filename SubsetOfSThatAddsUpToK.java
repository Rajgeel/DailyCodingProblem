// Given a list of integers S and a target number k, write a function that returns a subset of S that adds up to k. If such a subset cannot be made, then return null.

// Integers can appear more than once in the list. You may assume all numbers in the list are positive.

// For example, given S = [12, 1, 61, 5, 9, 2] and k = 24, return [12, 9, 2, 1] since it sums up to 24.



import java.util.Scanner;


//Time complexity is O(k*n) and space complexity is O(k*n);
class SubsetOfSThatAddsUpToK {

	boolean solution(int arr[], int n, int sum) {

		boolean dp[][] = new boolean[sum+1][n+1];

		for (int i=0; i<=n; i++) {
			
			dp[0][i] = true;
		}

		for (int i=0; i<=sum; i++) {
			
			dp[i][0] = false;
		}

		for(int i=1; i<=sum; i++) {
			for(int j=1; j<=n; j++) {

				dp[i][j] = dp[i][j-1];

				if(i >= arr[j-1]) {

					dp[i][j] = dp[i][j] || dp[i-arr[j-1]][j-1];
				}
			}
		}

		return dp[sum][n];

	}
	
	public static void main(String[] args) {
		
		SubsetOfSThatAddsUpToK obj = new SubsetOfSThatAddsUpToK();
		Scanner sc = new Scanner(System.in);

		int size = sc.nextInt();
		int arr[] = new int[size];

		for(int i=0; i<size; i++) {

			arr[i] = sc.nextInt();
		}

		int k = sc.nextInt();

		System.out.println(obj.solution(arr, size, k));
	}
}