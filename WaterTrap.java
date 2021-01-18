// You are given an array of non-negative integers that represents a two-dimensional elevation map where each element is unit-width wall and the integer is the height. Suppose it will rain and all spots between two walls get filled up.

// Compute how many units of water remain trapped on the map in O(N) time and O(1) space.

// For example, given the input [2, 1, 2], we can hold 1 unit of water in the middle.

// Given the input [3, 0, 1, 3, 0, 5], we can hold 3 units in the first index, 2 in the second, and 3 in the fourth index (we cannot hold 5 since it would run off to the left), so we can trap 8 units of water.




import java.util.Scanner;


// Time complexity is O(n) and space complexity is O(1).
class WaterTrap {


	int solution(int arr[], int n) {

		int i=0;
		int j=arr.length - 1;

		int rightMax = arr[j];
		int leftMax = arr[0];

		int totalWaterTrap = 0;

		while(i < j) {

			if(arr[i] <= arr[j]) {

				if(arr[i] >= leftMax) {
					leftMax = arr[i];
				}
				else {

					totalWaterTrap += leftMax - arr[i];
				}

				i++;
			}
			else {


				if(arr[j] >= rightMax) {
					rightMax = arr[j];
				}
				else {

					totalWaterTrap += rightMax - arr[j];
				}

				j--;
			}
		}

		return totalWaterTrap;
	}
	

	public static void main(String... s) {

		WaterTrap obj = new WaterTrap();
		Scanner sc = new Scanner(System.in);

		int size = sc.nextInt();

		int arr[] = new int[size];

		for(int i=0; i<size; i++) {

			arr[i] = sc.nextInt();
		}

		System.out.println(obj.solution(arr, size));
	}
}