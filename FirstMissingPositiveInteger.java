import java.util.Scanner;

class FirstMissingPositiveInteger {

	int solution(int[] arr) {

		int size = arr.length;

		for(int i=0; i<size; i++) {

			if(arr[i] != arr[i] + 1 && arr[i] > 0) {

				int temp = arr[i];
				arr[i] = arr[temp - 1];
				arr[temp - 1] = temp;
			}
		}

		int j = 0;

		while(j < size) {

			if(arr[j] > 0) {
				break;
			}

			j++;
		}

		// for(int i=j; i<size; i++) {

		// 	if(arr[i] > 0) {
		// 		if(arr[i] != arr[i] + 1) {
		// 			return arr[i] + 1;
		// 		}
		// 	}
		// }

		int i = 1;
		while(j < size) {

			if(arr[j] != i) {
				return i;
			}

			i++;
			j++;
		}

		return 1;
	}
	

	public static void main(String... s) {

		FirstMissingPositiveInteger obj = new FirstMissingPositiveInteger();
		Scanner sc = new Scanner(System.in);

		int arraySize = sc.nextInt();
		int arr[] = new int[arraySize];

		for(int i=0; i<arraySize; i++) {

			arr[i] = sc.nextInt();
		}

		System.out.print(obj.solution(arr));

	}
}