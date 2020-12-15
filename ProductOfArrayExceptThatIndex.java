/*
	Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

	For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6]. 

	Follow-up: what if you can't use division?
*/





import java.util.Scanner;

class ProductOfArrayExceptThatIndex {
	
	/* Time Complexity is O(n) and Space complexity is O(1) */
	double[] solution(double[] arr) {

		double ans[] = new double[arr.length];
		double productArray = 1;

		for(int i=0; i<arr.length; i++) {

			productArray = productArray * arr[i];
		}


		for(int i=0; i<arr.length; i++) {

			ans[i] = productArray / arr[i];
		}

		return ans;
	} 


	/* Time Complexity is O(n) and Space complexity is O(n) */	
	/* without using Division */

	double[] solution(double[] arr) {

		double[] ans = new double[arr.length];
		double[] prefixProduct = new double[arr.length];
		double[] sufixProduct = new double[arr.length];

		prefixProduct[0] = arr[0];
		sufixProduct[arr.length-1] = arr[arr.length-1];

		for(int i=1; i<arr.length; i++) {

			prefixProduct[i] = prefixProduct[i-1] * arr[i];
		}

		for(int i=arr.length-2; i>= 0; i--) {

			sufixProduct[i] = sufixProduct[i+1] * arr[i];
		}

		for(int i=0; i<arr.length; i++){

			if(i == 0) {
				ans[i] = sufixProduct[i+1];
			}
			else if(i == arr.length-1) {
				ans[i] = prefixProduct[i-1];
			}
			else {
				ans[i] = prefixProduct[i-1] * sufixProduct[i+1];
			}
		}

		return ans;
	}

	public void print(double[] arr) {

		for(int i=0; i<arr.length; i++) {

			System.out.print((int) arr[i] + " ");
		}
	}

	public static void main(String... s) {

		ProductOfArrayExceptThatIndex obj = new ProductOfArrayExceptThatIndex();
		Scanner sc = new Scanner(System.in);

		int arraySize = sc.nextInt();
		double[] arr = new double[arraySize];

		for(int i=0; i<arraySize; i++) {

			arr[i] = sc.nextDouble();
		}

		double ans[] = obj.solution(arr);

		obj.print(ans);
	}
}