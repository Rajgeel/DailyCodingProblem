// Given an array of integers and a number k, where 1 <= k <= length of the array, compute the maximum values of each subarray of length k.

// For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:

// 10 = max(10, 5, 2)
// 7 = max(5, 2, 7)
// 8 = max(2, 7, 8)
// 8 = max(7, 8, 7)
// Do this in O(n) time and O(k) space. You can modify the input array in-place and you do not need to store the results. You can simply print them out as you compute them.



import java.util.Scanner;



//Time Complexity is O(n) ans space complexity is O(1).
class MaxValuesOfEachSubarrayOfLengthK {


	void solution(int arr[], int k) {

		int firstMax;
		int secondMax;

		if(arr[0] >= arr[1]) {

			firstMax = 0;
			secondMax = 1;
		}
		else {

			firstMax = 1;
			secondMax = 0;
		}

		int i = 0;
		int j = k-1;

		for (int ind=2; ind<k; ind++) {
			
			if(arr[ind] > arr[firstMax]) {

				firstMax = ind;
			}

			if(arr[ind] < arr[firstMax] && arr[ind] > arr[secondMax]) {

				secondMax = ind;
			}
		}

		while(j < arr.length) {

			if(arr[j] >= arr[firstMax]) {

				firstMax = j;
			}

			else if(arr[j] < arr[firstMax] && arr[j] >= arr[secondMax]) {

				secondMax = j;

				if(firstMax < i) {

					firstMax = secondMax;
				}

				
			}

			else {

				if(firstMax < i) {

					firstMax = secondMax;
				}
			}

			System.out.print(arr[firstMax] + " ");

			i++;
			j++;
		}
	}

	
	public static void main(String[] args) {

		
		MaxValuesOfEachSubarrayOfLengthK obj = new MaxValuesOfEachSubarrayOfLengthK();
		Scanner sc = new Scanner(System.in);

		int size = sc.nextInt();
		int arr[] = new int[size];

		for(int i=0; i<size; i++) {

			arr[i] = sc.nextInt();
		}

		int k = sc.nextInt();

		obj.solution(arr, k);
	}
}