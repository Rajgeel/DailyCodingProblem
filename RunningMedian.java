// Compute the running median of a sequence of numbers. That is, given a stream of numbers, print out the median of the list so far on each new element.

// Recall that the median of an even-numbered list is the average of the two middle numbers.

// For example, given the sequence [2, 1, 5, 7, 2, 0, 5], your algorithm should print out:



import java.util.*; 


// Time Coplexity is O(n*nlogn) and space complexity is O(n)
class RunningMedian {

	void findMedian(ArrayList<Integer> A) {

		Collections.sort(A);

		if(A.size() % 2 == 0) {

			int secondIndex = A.size() / 2;
			int firstIndex = secondIndex - 1;

			System.out.println((float) ((A.get(firstIndex) + A.get(secondIndex)) / 2.0));
		}
		else {
			int middleIndex = A.size() / 2;

			System.out.println(A.get(middleIndex));
		}
	}

	void solution(int[] arr, int n) {

		ArrayList<Integer> A = new ArrayList<Integer>();

		for(int i=0; i<n; i++) {

			A.add(arr[i]);
			findMedian(A);
		}
	}
	
	public static void main(String... s) {

		RunningMedian obj = new RunningMedian();
		Scanner sc = new Scanner(System.in);

		int size = sc.nextInt();

		int arr[] = new int[size];

		for(int i=0; i<size; i++) {

			arr[i] = sc.nextInt();
		}


		if(arr.length == 0) {
			System.out.println(0);
		}

		else if(arr.length == 1) {
			System.out.println(arr[0]);
		}
		else {
			obj.solution(arr, size);
		}
	}
}